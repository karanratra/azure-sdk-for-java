/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 *
 */

package com.microsoft.azure.management.synapse.v2019_06_01_preview.implementation;

import com.microsoft.azure.arm.model.implementation.WrapperImpl;
import com.microsoft.azure.management.synapse.v2019_06_01_preview.SqlPools;
import rx.Completable;
import rx.Observable;
import rx.functions.Func1;
import com.microsoft.azure.Page;
import com.microsoft.azure.management.synapse.v2019_06_01_preview.SqlPool;

class SqlPoolsImpl extends WrapperImpl<SqlPoolsInner> implements SqlPools {
    private final SynapseManager manager;

    SqlPoolsImpl(SynapseManager manager) {
        super(manager.inner().sqlPools());
        this.manager = manager;
    }

    public SynapseManager manager() {
        return this.manager;
    }

    @Override
    public SqlPoolImpl define(String name) {
        return wrapModel(name);
    }

    private SqlPoolImpl wrapModel(SqlPoolInner inner) {
        return  new SqlPoolImpl(inner, manager());
    }

    private SqlPoolImpl wrapModel(String name) {
        return new SqlPoolImpl(name, this.manager());
    }

    @Override
    public Observable<Object> pauseAsync(String resourceGroupName, String workspaceName, String sqlPoolName) {
        SqlPoolsInner client = this.inner();
        return client.pauseAsync(resourceGroupName, workspaceName, sqlPoolName)
    ;}

    @Override
    public Observable<Object> resumeAsync(String resourceGroupName, String workspaceName, String sqlPoolName) {
        SqlPoolsInner client = this.inner();
        return client.resumeAsync(resourceGroupName, workspaceName, sqlPoolName)
    ;}

    @Override
    public Completable renameAsync(String resourceGroupName, String workspaceName, String sqlPoolName, String id) {
        SqlPoolsInner client = this.inner();
        return client.renameAsync(resourceGroupName, workspaceName, sqlPoolName, id).toCompletable();
    }

    @Override
    public Observable<SqlPool> listByWorkspaceAsync(final String resourceGroupName, final String workspaceName) {
        SqlPoolsInner client = this.inner();
        return client.listByWorkspaceAsync(resourceGroupName, workspaceName)
        .flatMapIterable(new Func1<Page<SqlPoolInner>, Iterable<SqlPoolInner>>() {
            @Override
            public Iterable<SqlPoolInner> call(Page<SqlPoolInner> page) {
                return page.items();
            }
        })
        .map(new Func1<SqlPoolInner, SqlPool>() {
            @Override
            public SqlPool call(SqlPoolInner inner) {
                return wrapModel(inner);
            }
        });
    }

    @Override
    public Observable<SqlPool> getAsync(String resourceGroupName, String workspaceName, String sqlPoolName) {
        SqlPoolsInner client = this.inner();
        return client.getAsync(resourceGroupName, workspaceName, sqlPoolName)
        .flatMap(new Func1<SqlPoolInner, Observable<SqlPool>>() {
            @Override
            public Observable<SqlPool> call(SqlPoolInner inner) {
                if (inner == null) {
                    return Observable.empty();
                } else {
                    return Observable.just((SqlPool)wrapModel(inner));
                }
            }
       });
    }

    @Override
    public Completable deleteAsync(String resourceGroupName, String workspaceName, String sqlPoolName) {
        SqlPoolsInner client = this.inner();
        return client.deleteAsync(resourceGroupName, workspaceName, sqlPoolName).toCompletable();
    }

}
