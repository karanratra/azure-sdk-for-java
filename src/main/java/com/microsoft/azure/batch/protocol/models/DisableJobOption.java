/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Defines values for DisableJobOption.
 */
public enum DisableJobOption {
    /** Terminate running tasks and requeue them. The tasks will run again when the job is enabled. */
    REQUEUE("requeue"),

    /** Terminate running tasks. The tasks will be completed with failureInfo indicating that they were terminated, and will not run again. */
    TERMINATE("terminate"),

    /** Allow currently running tasks to complete. */
    WAIT("wait");

    /** The actual serialized value for a DisableJobOption instance. */
    private String value;

    DisableJobOption(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a DisableJobOption instance.
     *
     * @param value the serialized value to parse.
     * @return the parsed DisableJobOption object, or null if unable to parse.
     */
    @JsonCreator
    public static DisableJobOption fromString(String value) {
        DisableJobOption[] items = DisableJobOption.values();
        for (DisableJobOption item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}