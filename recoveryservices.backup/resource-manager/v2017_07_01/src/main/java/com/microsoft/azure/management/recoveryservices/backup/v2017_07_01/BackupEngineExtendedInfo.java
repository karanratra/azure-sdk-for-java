/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.recoveryservices.backup.v2017_07_01;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Additional information on backup engine.
 */
public class BackupEngineExtendedInfo {
    /**
     * Database name of backup engine.
     */
    @JsonProperty(value = "databaseName")
    private String databaseName;

    /**
     * Number of protected items in the backup engine.
     */
    @JsonProperty(value = "protectedItemsCount")
    private Integer protectedItemsCount;

    /**
     * Number of protected servers in the backup engine.
     */
    @JsonProperty(value = "protectedServersCount")
    private Integer protectedServersCount;

    /**
     * Number of disks in the backup engine.
     */
    @JsonProperty(value = "diskCount")
    private Integer diskCount;

    /**
     * Diskspace used in the backup engine.
     */
    @JsonProperty(value = "usedDiskSpace")
    private Double usedDiskSpace;

    /**
     * Diskspace currently available in the backup engine.
     */
    @JsonProperty(value = "availableDiskSpace")
    private Double availableDiskSpace;

    /**
     * Last refresh time in the backup engine.
     */
    @JsonProperty(value = "refreshedAt")
    private DateTime refreshedAt;

    /**
     * Protected instances in the backup engine.
     */
    @JsonProperty(value = "azureProtectedInstances")
    private Integer azureProtectedInstances;

    /**
     * Get database name of backup engine.
     *
     * @return the databaseName value
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Set database name of backup engine.
     *
     * @param databaseName the databaseName value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withDatabaseName(String databaseName) {
        this.databaseName = databaseName;
        return this;
    }

    /**
     * Get number of protected items in the backup engine.
     *
     * @return the protectedItemsCount value
     */
    public Integer protectedItemsCount() {
        return this.protectedItemsCount;
    }

    /**
     * Set number of protected items in the backup engine.
     *
     * @param protectedItemsCount the protectedItemsCount value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withProtectedItemsCount(Integer protectedItemsCount) {
        this.protectedItemsCount = protectedItemsCount;
        return this;
    }

    /**
     * Get number of protected servers in the backup engine.
     *
     * @return the protectedServersCount value
     */
    public Integer protectedServersCount() {
        return this.protectedServersCount;
    }

    /**
     * Set number of protected servers in the backup engine.
     *
     * @param protectedServersCount the protectedServersCount value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withProtectedServersCount(Integer protectedServersCount) {
        this.protectedServersCount = protectedServersCount;
        return this;
    }

    /**
     * Get number of disks in the backup engine.
     *
     * @return the diskCount value
     */
    public Integer diskCount() {
        return this.diskCount;
    }

    /**
     * Set number of disks in the backup engine.
     *
     * @param diskCount the diskCount value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withDiskCount(Integer diskCount) {
        this.diskCount = diskCount;
        return this;
    }

    /**
     * Get diskspace used in the backup engine.
     *
     * @return the usedDiskSpace value
     */
    public Double usedDiskSpace() {
        return this.usedDiskSpace;
    }

    /**
     * Set diskspace used in the backup engine.
     *
     * @param usedDiskSpace the usedDiskSpace value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withUsedDiskSpace(Double usedDiskSpace) {
        this.usedDiskSpace = usedDiskSpace;
        return this;
    }

    /**
     * Get diskspace currently available in the backup engine.
     *
     * @return the availableDiskSpace value
     */
    public Double availableDiskSpace() {
        return this.availableDiskSpace;
    }

    /**
     * Set diskspace currently available in the backup engine.
     *
     * @param availableDiskSpace the availableDiskSpace value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withAvailableDiskSpace(Double availableDiskSpace) {
        this.availableDiskSpace = availableDiskSpace;
        return this;
    }

    /**
     * Get last refresh time in the backup engine.
     *
     * @return the refreshedAt value
     */
    public DateTime refreshedAt() {
        return this.refreshedAt;
    }

    /**
     * Set last refresh time in the backup engine.
     *
     * @param refreshedAt the refreshedAt value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withRefreshedAt(DateTime refreshedAt) {
        this.refreshedAt = refreshedAt;
        return this;
    }

    /**
     * Get protected instances in the backup engine.
     *
     * @return the azureProtectedInstances value
     */
    public Integer azureProtectedInstances() {
        return this.azureProtectedInstances;
    }

    /**
     * Set protected instances in the backup engine.
     *
     * @param azureProtectedInstances the azureProtectedInstances value to set
     * @return the BackupEngineExtendedInfo object itself.
     */
    public BackupEngineExtendedInfo withAzureProtectedInstances(Integer azureProtectedInstances) {
        this.azureProtectedInstances = azureProtectedInstances;
        return this;
    }

}