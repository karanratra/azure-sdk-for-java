/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datamigration.v2018_07_15_preview;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Output for the task that validates connection to PostgreSQL and source
 * server requirements.
 */
public class ConnectToSourcePostgreSqlSyncTaskOutput {
    /**
     * Result identifier.
     */
    @JsonProperty(value = "id", access = JsonProperty.Access.WRITE_ONLY)
    private String id;

    /**
     * Version of the source server.
     */
    @JsonProperty(value = "sourceServerVersion", access = JsonProperty.Access.WRITE_ONLY)
    private String sourceServerVersion;

    /**
     * List of databases on source server.
     */
    @JsonProperty(value = "databases", access = JsonProperty.Access.WRITE_ONLY)
    private List<String> databases;

    /**
     * Source server brand version.
     */
    @JsonProperty(value = "sourceServerBrandVersion", access = JsonProperty.Access.WRITE_ONLY)
    private String sourceServerBrandVersion;

    /**
     * Validation errors associated with the task.
     */
    @JsonProperty(value = "validationErrors", access = JsonProperty.Access.WRITE_ONLY)
    private List<ReportableException> validationErrors;

    /**
     * Get result identifier.
     *
     * @return the id value
     */
    public String id() {
        return this.id;
    }

    /**
     * Get version of the source server.
     *
     * @return the sourceServerVersion value
     */
    public String sourceServerVersion() {
        return this.sourceServerVersion;
    }

    /**
     * Get list of databases on source server.
     *
     * @return the databases value
     */
    public List<String> databases() {
        return this.databases;
    }

    /**
     * Get source server brand version.
     *
     * @return the sourceServerBrandVersion value
     */
    public String sourceServerBrandVersion() {
        return this.sourceServerBrandVersion;
    }

    /**
     * Get validation errors associated with the task.
     *
     * @return the validationErrors value
     */
    public List<ReportableException> validationErrors() {
        return this.validationErrors;
    }

}
