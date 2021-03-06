/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.batch.protocol.models;

import org.joda.time.DateTime;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Contains information about Jobs that have been and will be run under a Job
 * Schedule.
 */
public class JobScheduleExecutionInformation {
    /**
     * The next time at which a Job will be created under this schedule.
     * This property is meaningful only if the schedule is in the active state
     * when the time comes around. For example, if the schedule is disabled, no
     * Job will be created at nextRunTime unless the Job is enabled before
     * then.
     */
    @JsonProperty(value = "nextRunTime")
    private DateTime nextRunTime;

    /**
     * Information about the most recent Job under the Job Schedule.
     * This property is present only if the at least one Job has run under the
     * schedule.
     */
    @JsonProperty(value = "recentJob")
    private RecentJob recentJob;

    /**
     * The time at which the schedule ended.
     * This property is set only if the Job Schedule is in the completed state.
     */
    @JsonProperty(value = "endTime")
    private DateTime endTime;

    /**
     * Get this property is meaningful only if the schedule is in the active state when the time comes around. For example, if the schedule is disabled, no Job will be created at nextRunTime unless the Job is enabled before then.
     *
     * @return the nextRunTime value
     */
    public DateTime nextRunTime() {
        return this.nextRunTime;
    }

    /**
     * Set this property is meaningful only if the schedule is in the active state when the time comes around. For example, if the schedule is disabled, no Job will be created at nextRunTime unless the Job is enabled before then.
     *
     * @param nextRunTime the nextRunTime value to set
     * @return the JobScheduleExecutionInformation object itself.
     */
    public JobScheduleExecutionInformation withNextRunTime(DateTime nextRunTime) {
        this.nextRunTime = nextRunTime;
        return this;
    }

    /**
     * Get this property is present only if the at least one Job has run under the schedule.
     *
     * @return the recentJob value
     */
    public RecentJob recentJob() {
        return this.recentJob;
    }

    /**
     * Set this property is present only if the at least one Job has run under the schedule.
     *
     * @param recentJob the recentJob value to set
     * @return the JobScheduleExecutionInformation object itself.
     */
    public JobScheduleExecutionInformation withRecentJob(RecentJob recentJob) {
        this.recentJob = recentJob;
        return this;
    }

    /**
     * Get this property is set only if the Job Schedule is in the completed state.
     *
     * @return the endTime value
     */
    public DateTime endTime() {
        return this.endTime;
    }

    /**
     * Set this property is set only if the Job Schedule is in the completed state.
     *
     * @param endTime the endTime value to set
     * @return the JobScheduleExecutionInformation object itself.
     */
    public JobScheduleExecutionInformation withEndTime(DateTime endTime) {
        this.endTime = endTime;
        return this;
    }

}
