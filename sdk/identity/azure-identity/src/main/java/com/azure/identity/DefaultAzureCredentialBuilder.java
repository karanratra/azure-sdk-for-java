// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.identity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

/**
 * Fluent credential builder for instantiating a {@link DefaultAzureCredential}.
 *
 * @see DefaultAzureCredential
 */
public class DefaultAzureCredentialBuilder extends CredentialBuilderBase<DefaultAzureCredentialBuilder> {

    /**
     * Specifies the Azure Active Directory endpoint to acquire tokens.
     * @param authorityHost the Azure Active Directory endpoint
     * @return An updated instance of this builder with the authority host set as specified.
     */
    public DefaultAzureCredentialBuilder authorityHost(String authorityHost) {
        this.identityClientOptions.setAuthorityHost(authorityHost);
        return this;
    }

    /**
     * Specifies the ExecutorService to be used to execute the authentication requests.
     * Developer is responsible for maintaining the lifecycle of the ExecutorService.
     *
     * <p>
     * If this is not configured, the {@link ForkJoinPool#commonPool()} will be used which is
     * also shared with other application tasks. If the common pool is heavily used for other tasks, authentication
     * requests might starve and setting up this executor service should be considered.
     * </p>
     *
     * <p> The executor service and can be safely shutdown if the TokenCredential is no longer being used by the
     * Azure SDK clients and should be shutdown before the application exits. </p>
     *
     * @param executorService the executor service to use for executing authentication requests.
     * @return An updated instance of this builder with the executor service set as specified.
     */
    public DefaultAzureCredentialBuilder executorService(ExecutorService executorService) {
        this.identityClientOptions.setExecutorService(executorService);
        return this;
    }

    /**
     * Creates new {@link DefaultAzureCredential} with the configured options set.
     *
     * @return a {@link DefaultAzureCredential} with the current configurations.
     */
    public DefaultAzureCredential build() {
        return new DefaultAzureCredential(identityClientOptions);
    }
}
