/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.azurestack.v2017_06_01;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.microsoft.rest.serializer.JsonFlatten;

/**
 * Registration resource.
 */
@JsonFlatten
public class RegistrationParameter {
    /**
     * The token identifying registered Azure Stack.
     */
    @JsonProperty(value = "properties.registrationToken", required = true)
    private String registrationToken;

    /**
     * Location of the resource. Possible values include: 'global'.
     */
    @JsonProperty(value = "location")
    private Location location;

    /**
     * Get the token identifying registered Azure Stack.
     *
     * @return the registrationToken value
     */
    public String registrationToken() {
        return this.registrationToken;
    }

    /**
     * Set the token identifying registered Azure Stack.
     *
     * @param registrationToken the registrationToken value to set
     * @return the RegistrationParameter object itself.
     */
    public RegistrationParameter withRegistrationToken(String registrationToken) {
        this.registrationToken = registrationToken;
        return this;
    }

    /**
     * Get location of the resource. Possible values include: 'global'.
     *
     * @return the location value
     */
    public Location location() {
        return this.location;
    }

    /**
     * Set location of the resource. Possible values include: 'global'.
     *
     * @param location the location value to set
     * @return the RegistrationParameter object itself.
     */
    public RegistrationParameter withLocation(Location location) {
        this.location = location;
        return this;
    }

}
