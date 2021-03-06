/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.datafactory.v2018_06_01;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Query filter option for listing runs.
 */
public class RunQueryFilter {
    /**
     * Parameter name to be used for filter. The allowed operands to query
     * pipeline runs are PipelineName, RunStart, RunEnd and Status; to query
     * activity runs are ActivityName, ActivityRunStart, ActivityRunEnd,
     * ActivityType and Status, and to query trigger runs are TriggerName,
     * TriggerRunTimestamp and Status. Possible values include: 'PipelineName',
     * 'Status', 'RunStart', 'RunEnd', 'ActivityName', 'ActivityRunStart',
     * 'ActivityRunEnd', 'ActivityType', 'TriggerName', 'TriggerRunTimestamp',
     * 'RunGroupId', 'LatestOnly'.
     */
    @JsonProperty(value = "operand", required = true)
    private RunQueryFilterOperand operand;

    /**
     * Operator to be used for filter. Possible values include: 'Equals',
     * 'NotEquals', 'In', 'NotIn'.
     */
    @JsonProperty(value = "operator", required = true)
    private RunQueryFilterOperator operator;

    /**
     * List of filter values.
     */
    @JsonProperty(value = "values", required = true)
    private List<String> values;

    /**
     * Get parameter name to be used for filter. The allowed operands to query pipeline runs are PipelineName, RunStart, RunEnd and Status; to query activity runs are ActivityName, ActivityRunStart, ActivityRunEnd, ActivityType and Status, and to query trigger runs are TriggerName, TriggerRunTimestamp and Status. Possible values include: 'PipelineName', 'Status', 'RunStart', 'RunEnd', 'ActivityName', 'ActivityRunStart', 'ActivityRunEnd', 'ActivityType', 'TriggerName', 'TriggerRunTimestamp', 'RunGroupId', 'LatestOnly'.
     *
     * @return the operand value
     */
    public RunQueryFilterOperand operand() {
        return this.operand;
    }

    /**
     * Set parameter name to be used for filter. The allowed operands to query pipeline runs are PipelineName, RunStart, RunEnd and Status; to query activity runs are ActivityName, ActivityRunStart, ActivityRunEnd, ActivityType and Status, and to query trigger runs are TriggerName, TriggerRunTimestamp and Status. Possible values include: 'PipelineName', 'Status', 'RunStart', 'RunEnd', 'ActivityName', 'ActivityRunStart', 'ActivityRunEnd', 'ActivityType', 'TriggerName', 'TriggerRunTimestamp', 'RunGroupId', 'LatestOnly'.
     *
     * @param operand the operand value to set
     * @return the RunQueryFilter object itself.
     */
    public RunQueryFilter withOperand(RunQueryFilterOperand operand) {
        this.operand = operand;
        return this;
    }

    /**
     * Get operator to be used for filter. Possible values include: 'Equals', 'NotEquals', 'In', 'NotIn'.
     *
     * @return the operator value
     */
    public RunQueryFilterOperator operator() {
        return this.operator;
    }

    /**
     * Set operator to be used for filter. Possible values include: 'Equals', 'NotEquals', 'In', 'NotIn'.
     *
     * @param operator the operator value to set
     * @return the RunQueryFilter object itself.
     */
    public RunQueryFilter withOperator(RunQueryFilterOperator operator) {
        this.operator = operator;
        return this;
    }

    /**
     * Get list of filter values.
     *
     * @return the values value
     */
    public List<String> values() {
        return this.values;
    }

    /**
     * Set list of filter values.
     *
     * @param values the values value to set
     * @return the RunQueryFilter object itself.
     */
    public RunQueryFilter withValues(List<String> values) {
        this.values = values;
        return this;
    }

}
