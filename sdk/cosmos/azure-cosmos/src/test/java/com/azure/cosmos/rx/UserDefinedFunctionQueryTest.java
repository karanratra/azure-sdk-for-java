// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.cosmos.rx;

import com.azure.cosmos.CosmosAsyncClient;
import com.azure.cosmos.CosmosAsyncContainer;
import com.azure.cosmos.CosmosClientBuilder;
import com.azure.cosmos.CosmosClientException;
import com.azure.cosmos.CosmosPagedFlux;
import com.azure.cosmos.models.CosmosUserDefinedFunctionProperties;
import com.azure.cosmos.models.FeedOptions;
import com.azure.cosmos.implementation.Database;
import com.azure.cosmos.implementation.FailureValidator;
import com.azure.cosmos.implementation.FeedResponseListValidator;
import com.azure.cosmos.implementation.FeedResponseValidator;
import com.azure.cosmos.implementation.TestUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class UserDefinedFunctionQueryTest extends TestSuiteBase {

    private Database createdDatabase;
    private CosmosAsyncContainer createdCollection;
    private List<CosmosUserDefinedFunctionProperties> createdUDF = new ArrayList<>();

    private CosmosAsyncClient client;

    public  String getCollectionLink() {
        return TestUtils.getCollectionNameLink(createdDatabase.getId(), createdCollection.getId());
    }

    @Factory(dataProvider = "clientBuildersWithDirect")
    public UserDefinedFunctionQueryTest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void queryWithFilter() throws Exception {

        String filterId = createdUDF.get(0).getId();
        String query = String.format("SELECT * from c where c.id = '%s'", filterId);

        FeedOptions options = new FeedOptions();
        int maxItemCount = 5;
        CosmosPagedFlux<CosmosUserDefinedFunctionProperties> queryObservable = createdCollection.getScripts().queryUserDefinedFunctions(query, options);

        List<CosmosUserDefinedFunctionProperties> expectedDocs = createdUDF.stream().filter(sp -> filterId.equals(sp.getId()) ).collect(Collectors.toList());
        assertThat(expectedDocs).isNotEmpty();

        int expectedPageSize = (expectedDocs.size() + maxItemCount - 1) / maxItemCount;

        FeedResponseListValidator<CosmosUserDefinedFunctionProperties> validator = new FeedResponseListValidator.Builder<CosmosUserDefinedFunctionProperties>()
                .totalSize(expectedDocs.size())
                .exactlyContainsInAnyOrder(expectedDocs.stream().map(d -> d.getResourceId()).collect(Collectors.toList()))
                .numberOfPages(expectedPageSize)
                .pageSatisfy(0, new FeedResponseValidator.Builder<CosmosUserDefinedFunctionProperties>()
                        .requestChargeGreaterThanOrEqualTo(1.0).build())
                .build();

        validateQuerySuccess(queryObservable.byPage(maxItemCount), validator, 10000);
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void query_NoResults() throws Exception {

        String query = "SELECT * from root r where r.id = '2'";
        FeedOptions options = new FeedOptions();
        
        CosmosPagedFlux<CosmosUserDefinedFunctionProperties> queryObservable = createdCollection.getScripts().queryUserDefinedFunctions(query, options);

        FeedResponseListValidator<CosmosUserDefinedFunctionProperties> validator = new FeedResponseListValidator.Builder<CosmosUserDefinedFunctionProperties>()
                .containsExactly(new ArrayList<>())
                .numberOfPages(1)
                .pageSatisfy(0, new FeedResponseValidator.Builder<CosmosUserDefinedFunctionProperties>()
                        .requestChargeGreaterThanOrEqualTo(1.0).build())
                .build();
        validateQuerySuccess(queryObservable.byPage(), validator);
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void queryAll() throws Exception {

        String query = "SELECT * from root";
        FeedOptions options = new FeedOptions();

        int maxItemCount = 3;
        
        CosmosPagedFlux<CosmosUserDefinedFunctionProperties> queryObservable = createdCollection.getScripts().queryUserDefinedFunctions(query, options);

        List<CosmosUserDefinedFunctionProperties> expectedDocs = createdUDF;

        int expectedPageSize = (expectedDocs.size() + maxItemCount - 1) / maxItemCount;

        FeedResponseListValidator<CosmosUserDefinedFunctionProperties> validator = new FeedResponseListValidator
                .Builder<CosmosUserDefinedFunctionProperties>()
                .exactlyContainsInAnyOrder(expectedDocs
                        .stream()
                        .map(d -> d.getResourceId())
                        .collect(Collectors.toList()))
                .numberOfPages(expectedPageSize)
                .allPagesSatisfy(new FeedResponseValidator.Builder<CosmosUserDefinedFunctionProperties>()
                        .requestChargeGreaterThanOrEqualTo(1.0).build())
                .build();
        validateQuerySuccess(queryObservable.byPage(maxItemCount), validator);
    }

    @Test(groups = { "simple" }, timeOut = TIMEOUT)
    public void invalidQuerySytax() throws Exception {
        String query = "I am an invalid query";
        FeedOptions options = new FeedOptions();
        
        CosmosPagedFlux<CosmosUserDefinedFunctionProperties> queryObservable = createdCollection.getScripts().queryUserDefinedFunctions(query, options);

        FailureValidator validator = new FailureValidator.Builder()
                .instanceOf(CosmosClientException.class)
                .statusCode(400)
                .notNullActivityId()
                .build();
        validateQueryFailure(queryObservable.byPage(), validator);
    }

    public CosmosUserDefinedFunctionProperties createUserDefinedFunction(CosmosAsyncContainer cosmosContainer) {
        CosmosUserDefinedFunctionProperties storedProcedure = getUserDefinedFunctionDef();
        return cosmosContainer.getScripts().createUserDefinedFunction(storedProcedure).block().getProperties();
    }

    @BeforeClass(groups = { "simple" }, timeOut = SETUP_TIMEOUT)
    public void before_UserDefinedFunctionQueryTest() throws Exception {
        client = clientBuilder().buildAsyncClient();
        createdCollection = getSharedMultiPartitionCosmosContainer(client);
        truncateCollection(createdCollection);

        for(int i = 0; i < 5; i++) {
            createdUDF.add(createUserDefinedFunction(createdCollection));
        }

        waitIfNeededForReplicasToCatchUp(clientBuilder());
    }

    @AfterClass(groups = { "simple" }, timeOut = SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        safeClose(client);
    }

    private static CosmosUserDefinedFunctionProperties getUserDefinedFunctionDef() {
        CosmosUserDefinedFunctionProperties udf = new CosmosUserDefinedFunctionProperties();
        udf.setId(UUID.randomUUID().toString());
        udf.setBody("function() {var x = 10;}");
        return udf;
    }
}
