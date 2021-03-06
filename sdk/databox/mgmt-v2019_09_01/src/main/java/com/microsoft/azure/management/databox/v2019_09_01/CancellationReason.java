/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.databox.v2019_09_01;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Reason for cancellation.
 */
public class CancellationReason {
    /**
     * Reason for cancellation.
     */
    @JsonProperty(value = "reason", required = true)
    private String reason;

    /**
     * Get reason for cancellation.
     *
     * @return the reason value
     */
    public String reason() {
        return this.reason;
    }

    /**
     * Set reason for cancellation.
     *
     * @param reason the reason value to set
     * @return the CancellationReason object itself.
     */
    public CancellationReason withReason(String reason) {
        this.reason = reason;
        return this;
    }

}
