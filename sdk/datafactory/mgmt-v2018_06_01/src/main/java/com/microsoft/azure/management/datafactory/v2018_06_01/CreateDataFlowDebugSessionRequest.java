/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Request body structure for creating data flow debug session.
 */
public class CreateDataFlowDebugSessionRequest {
    /**
     * Compute type of the cluster. The value will be overwritten by the same
     * setting in integration runtime if provided.
     */
    @JsonProperty(value = "computeType")
    private String computeType;

    /**
     * Core count of the cluster. The value will be overwritten by the same
     * setting in integration runtime if provided.
     */
    @JsonProperty(value = "coreCount")
    private Integer coreCount;

    /**
     * Time to live setting of the cluster in minutes.
     */
    @JsonProperty(value = "timeToLive")
    private Integer timeToLive;

    /**
     * Set to use integration runtime setting for data flow debug session.
     */
    @JsonProperty(value = "integrationRuntime")
    private IntegrationRuntimeDebugResource integrationRuntime;

    /**
     * Get compute type of the cluster. The value will be overwritten by the same setting in integration runtime if provided.
     *
     * @return the computeType value
     */
    public String computeType() {
        return this.computeType;
    }

    /**
     * Set compute type of the cluster. The value will be overwritten by the same setting in integration runtime if provided.
     *
     * @param computeType the computeType value to set
     * @return the CreateDataFlowDebugSessionRequest object itself.
     */
    public CreateDataFlowDebugSessionRequest withComputeType(String computeType) {
        this.computeType = computeType;
        return this;
    }

    /**
     * Get core count of the cluster. The value will be overwritten by the same setting in integration runtime if provided.
     *
     * @return the coreCount value
     */
    public Integer coreCount() {
        return this.coreCount;
    }

    /**
     * Set core count of the cluster. The value will be overwritten by the same setting in integration runtime if provided.
     *
     * @param coreCount the coreCount value to set
     * @return the CreateDataFlowDebugSessionRequest object itself.
     */
    public CreateDataFlowDebugSessionRequest withCoreCount(Integer coreCount) {
        this.coreCount = coreCount;
        return this;
    }

    /**
     * Get time to live setting of the cluster in minutes.
     *
     * @return the timeToLive value
     */
    public Integer timeToLive() {
        return this.timeToLive;
    }

    /**
     * Set time to live setting of the cluster in minutes.
     *
     * @param timeToLive the timeToLive value to set
     * @return the CreateDataFlowDebugSessionRequest object itself.
     */
    public CreateDataFlowDebugSessionRequest withTimeToLive(Integer timeToLive) {
        this.timeToLive = timeToLive;
        return this;
    }

    /**
     * Get set to use integration runtime setting for data flow debug session.
     *
     * @return the integrationRuntime value
     */
    public IntegrationRuntimeDebugResource integrationRuntime() {
        return this.integrationRuntime;
    }

    /**
     * Set set to use integration runtime setting for data flow debug session.
     *
     * @param integrationRuntime the integrationRuntime value to set
     * @return the CreateDataFlowDebugSessionRequest object itself.
     */
    public CreateDataFlowDebugSessionRequest withIntegrationRuntime(IntegrationRuntimeDebugResource integrationRuntime) {
        this.integrationRuntime = integrationRuntime;
        return this;
    }

}
