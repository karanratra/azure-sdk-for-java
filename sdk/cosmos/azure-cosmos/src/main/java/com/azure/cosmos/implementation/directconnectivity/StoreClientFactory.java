// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation.directconnectivity;

import com.azure.cosmos.implementation.Configs;
import com.azure.cosmos.implementation.IAuthorizationTokenProvider;
import com.azure.cosmos.implementation.SessionContainer;
import com.azure.cosmos.implementation.UserAgentContainer;

import java.time.Duration;

// TODO: DANOBLE: no support for ICommunicationEventSource ask Ji
//  Links:
//  https://msdata.visualstudio.com/CosmosDB/SDK/_workitems/edit/262496

public class StoreClientFactory implements AutoCloseable {

    private final Configs configs;
    private final int maxConcurrentConnectionOpenRequests;
    private final Duration requestTimeout;
    private final Protocol protocol;
    private final TransportClient transportClient;
    private final boolean enableTransportClientSharing;
    private volatile boolean isClosed;

    public StoreClientFactory(
        Configs configs,
        Duration requestTimeout,
        int maxConcurrentConnectionOpenRequests,
        UserAgentContainer userAgent,
        boolean enableTransportClientSharing) {

        this.configs = configs;
        this.protocol = configs.getProtocol();
        this.requestTimeout = requestTimeout;
        this.maxConcurrentConnectionOpenRequests = maxConcurrentConnectionOpenRequests;
        this.enableTransportClientSharing = enableTransportClientSharing;

        if (enableTransportClientSharing) {
            this.transportClient = SharedTransportClient.getOrCreateInstance(protocol, configs, requestTimeout, userAgent);
        } else {
            if (protocol == Protocol.HTTPS) {
                this.transportClient = new HttpTransportClient(configs, requestTimeout, userAgent);
            } else if (protocol == Protocol.TCP) {
                this.transportClient = new RntbdTransportClient(configs, requestTimeout, userAgent);
            } else {
                throw new IllegalArgumentException(String.format("protocol: %s", this.protocol));
            }
        }
    }

    public void close() throws Exception {
        this.transportClient.close();
        this.isClosed = true;
    }

    // TODO wew don't have support for the following yet
    // TODO enableReadRequestsFallback ask Ji
    // TODO useFallbackClient ask Ji
    public StoreClient createStoreClient(
        IAddressResolver addressResolver,
        SessionContainer sessionContainer,
        GatewayServiceConfigurationReader serviceConfigurationReader,
        IAuthorizationTokenProvider authorizationTokenProvider,
        boolean useMultipleWriteLocations) {
        this.throwIfClosed();

        return new StoreClient(configs,
            addressResolver,
            sessionContainer,
            serviceConfigurationReader,
            authorizationTokenProvider,
            this.transportClient,
            useMultipleWriteLocations);
    }

    private void throwIfClosed() {
        if (isClosed) {
            throw new IllegalStateException("storeClient already closed!");
        }
    }
}
