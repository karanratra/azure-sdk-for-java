/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.vision.customvision.training.models;

import java.util.Collection;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.microsoft.rest.ExpandableStringEnum;

/**
 * Defines values for OrderBy.
 */
public final class OrderBy extends ExpandableStringEnum<OrderBy> {
    /** Static value Newest for OrderBy. */
    public static final OrderBy NEWEST = fromString("Newest");

    /** Static value Oldest for OrderBy. */
    public static final OrderBy OLDEST = fromString("Oldest");

    /** Static value Suggested for OrderBy. */
    public static final OrderBy SUGGESTED = fromString("Suggested");

    /**
     * Creates or finds a OrderBy from its string representation.
     * @param name a name to look for
     * @return the corresponding OrderBy
     */
    @JsonCreator
    public static OrderBy fromString(String name) {
        return fromString(name, OrderBy.class);
    }

    /**
     * @return known OrderBy values
     */
    public static Collection<OrderBy> values() {
        return values(OrderBy.class);
    }
}
