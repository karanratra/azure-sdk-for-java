/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.cosmosdb.v2015_04_08.implementation;

import com.microsoft.azure.management.cosmosdb.v2015_04_08.IndexingPolicy;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.ContainerPartitionKey;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.UniqueKeyPolicy;
import com.microsoft.azure.management.cosmosdb.v2015_04_08.ConflictResolutionPolicy;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;
import com.microsoft.rest.SkipParentValidation;
import com.microsoft.azure.Resource;

/**
 * An Azure Cosmos DB container.
 */
@JsonFlatten
@SkipParentValidation
public class SqlContainerInner extends Resource {
    /**
     * Name of the Cosmos DB SQL container.
     */
    @JsonProperty(value = "properties.id", required = true)
    private String sqlContainerId;

    /**
     * The configuration of the indexing policy. By default, the indexing is
     * automatic for all document paths within the container.
     */
    @JsonProperty(value = "properties.indexingPolicy")
    private IndexingPolicy indexingPolicy;

    /**
     * The configuration of the partition key to be used for partitioning data
     * into multiple partitions.
     */
    @JsonProperty(value = "properties.partitionKey")
    private ContainerPartitionKey partitionKey;

    /**
     * Default time to live.
     */
    @JsonProperty(value = "properties.defaultTtl")
    private Integer defaultTtl;

    /**
     * The unique key policy configuration for specifying uniqueness
     * constraints on documents in the collection in the Azure Cosmos DB
     * service.
     */
    @JsonProperty(value = "properties.uniqueKeyPolicy")
    private UniqueKeyPolicy uniqueKeyPolicy;

    /**
     * The conflict resolution policy for the container.
     */
    @JsonProperty(value = "properties.conflictResolutionPolicy")
    private ConflictResolutionPolicy conflictResolutionPolicy;

    /**
     * A system generated property. A unique identifier.
     */
    @JsonProperty(value = "properties._rid")
    private String _rid;

    /**
     * A system generated property that denotes the last updated timestamp of
     * the resource.
     */
    @JsonProperty(value = "properties._ts")
    private Object _ts;

    /**
     * A system generated property representing the resource etag required for
     * optimistic concurrency control.
     */
    @JsonProperty(value = "properties._etag")
    private String _etag;

    /**
     * Get name of the Cosmos DB SQL container.
     *
     * @return the sqlContainerId value
     */
    public String sqlContainerId() {
        return this.sqlContainerId;
    }

    /**
     * Set name of the Cosmos DB SQL container.
     *
     * @param sqlContainerId the sqlContainerId value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner withSqlContainerId(String sqlContainerId) {
        this.sqlContainerId = sqlContainerId;
        return this;
    }

    /**
     * Get the configuration of the indexing policy. By default, the indexing is automatic for all document paths within the container.
     *
     * @return the indexingPolicy value
     */
    public IndexingPolicy indexingPolicy() {
        return this.indexingPolicy;
    }

    /**
     * Set the configuration of the indexing policy. By default, the indexing is automatic for all document paths within the container.
     *
     * @param indexingPolicy the indexingPolicy value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner withIndexingPolicy(IndexingPolicy indexingPolicy) {
        this.indexingPolicy = indexingPolicy;
        return this;
    }

    /**
     * Get the configuration of the partition key to be used for partitioning data into multiple partitions.
     *
     * @return the partitionKey value
     */
    public ContainerPartitionKey partitionKey() {
        return this.partitionKey;
    }

    /**
     * Set the configuration of the partition key to be used for partitioning data into multiple partitions.
     *
     * @param partitionKey the partitionKey value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner withPartitionKey(ContainerPartitionKey partitionKey) {
        this.partitionKey = partitionKey;
        return this;
    }

    /**
     * Get default time to live.
     *
     * @return the defaultTtl value
     */
    public Integer defaultTtl() {
        return this.defaultTtl;
    }

    /**
     * Set default time to live.
     *
     * @param defaultTtl the defaultTtl value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner withDefaultTtl(Integer defaultTtl) {
        this.defaultTtl = defaultTtl;
        return this;
    }

    /**
     * Get the unique key policy configuration for specifying uniqueness constraints on documents in the collection in the Azure Cosmos DB service.
     *
     * @return the uniqueKeyPolicy value
     */
    public UniqueKeyPolicy uniqueKeyPolicy() {
        return this.uniqueKeyPolicy;
    }

    /**
     * Set the unique key policy configuration for specifying uniqueness constraints on documents in the collection in the Azure Cosmos DB service.
     *
     * @param uniqueKeyPolicy the uniqueKeyPolicy value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner withUniqueKeyPolicy(UniqueKeyPolicy uniqueKeyPolicy) {
        this.uniqueKeyPolicy = uniqueKeyPolicy;
        return this;
    }

    /**
     * Get the conflict resolution policy for the container.
     *
     * @return the conflictResolutionPolicy value
     */
    public ConflictResolutionPolicy conflictResolutionPolicy() {
        return this.conflictResolutionPolicy;
    }

    /**
     * Set the conflict resolution policy for the container.
     *
     * @param conflictResolutionPolicy the conflictResolutionPolicy value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner withConflictResolutionPolicy(ConflictResolutionPolicy conflictResolutionPolicy) {
        this.conflictResolutionPolicy = conflictResolutionPolicy;
        return this;
    }

    /**
     * Get a system generated property. A unique identifier.
     *
     * @return the _rid value
     */
    public String _rid() {
        return this._rid;
    }

    /**
     * Set a system generated property. A unique identifier.
     *
     * @param _rid the _rid value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner with_rid(String _rid) {
        this._rid = _rid;
        return this;
    }

    /**
     * Get a system generated property that denotes the last updated timestamp of the resource.
     *
     * @return the _ts value
     */
    public Object _ts() {
        return this._ts;
    }

    /**
     * Set a system generated property that denotes the last updated timestamp of the resource.
     *
     * @param _ts the _ts value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner with_ts(Object _ts) {
        this._ts = _ts;
        return this;
    }

    /**
     * Get a system generated property representing the resource etag required for optimistic concurrency control.
     *
     * @return the _etag value
     */
    public String _etag() {
        return this._etag;
    }

    /**
     * Set a system generated property representing the resource etag required for optimistic concurrency control.
     *
     * @param _etag the _etag value to set
     * @return the SqlContainerInner object itself.
     */
    public SqlContainerInner with_etag(String _etag) {
        this._etag = _etag;
        return this;
    }

}
