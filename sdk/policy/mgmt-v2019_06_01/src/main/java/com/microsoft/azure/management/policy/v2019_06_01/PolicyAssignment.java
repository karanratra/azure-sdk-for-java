/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.management.policy.v2019_06_01;

import com.microsoft.azure.arm.model.HasInner;
import com.microsoft.azure.management.policy.v2019_06_01.implementation.PolicyAssignmentInner;
import com.microsoft.azure.arm.model.Indexable;
import com.microsoft.azure.arm.model.Creatable;
import com.microsoft.azure.arm.model.Updatable;
import com.microsoft.azure.arm.model.Appliable;
import com.microsoft.azure.arm.model.Refreshable;
import com.microsoft.azure.arm.resources.models.HasManager;
import com.microsoft.azure.management.policy.v2019_06_01.implementation.PolicyManager;
import java.util.List;

/**
 * Type representing PolicyAssignment.
 */
public interface PolicyAssignment extends HasInner<PolicyAssignmentInner>, Indexable, Updatable<PolicyAssignment.Update>, Refreshable<PolicyAssignment>, HasManager<PolicyManager> {
    /**
     * @return the description value.
     */
    String description();

    /**
     * @return the displayName value.
     */
    String displayName();

    /**
     * @return the enforcementMode value.
     */
    EnforcementMode enforcementMode();

    /**
     * @return the id value.
     */
    String id();

    /**
     * @return the identity value.
     */
    Identity identity();

    /**
     * @return the location value.
     */
    String location();

    /**
     * @return the metadata value.
     */
    Object metadata();

    /**
     * @return the name value.
     */
    String name();

    /**
     * @return the notScopes value.
     */
    List<String> notScopes();

    /**
     * @return the parameters value.
     */
    Object parameters();

    /**
     * @return the policyDefinitionId value.
     */
    String policyDefinitionId();

    /**
     * @return the scopeProperty value.
     */
    String scopeProperty();

    /**
     * @return the sku value.
     */
    PolicySku sku();

    /**
     * @return the type value.
     */
    String type();

    /**
     * The entirety of the PolicyAssignment definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithScope, DefinitionStages.WithCreate {
    }

    /**
     * Grouping of PolicyAssignment definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of a PolicyAssignment definition.
         */
        interface Blank extends WithScope {
        }

        /**
         * The stage of the policyassignment definition allowing to specify Scope.
         */
        interface WithScope {
           /**
            * Specifies scope.
            * @param scope The scope of the policy assignment. Valid scopes are: management group (format: '/providers/Microsoft.Management/managementGroups/{managementGroup}'), subscription (format: '/subscriptions/{subscriptionId}'), resource group (format: '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}', or resource (format: '/subscriptions/{subscriptionId}/resourceGroups/{resourceGroupName}/providers/{resourceProviderNamespace}/[{parentResourcePath}/]{resourceType}/{resourceName}'
            * @return the next definition stage
            */
            WithCreate withScope(String scope);
        }

        /**
         * The stage of the policyassignment definition allowing to specify Description.
         */
        interface WithDescription {
            /**
             * Specifies description.
             * @param description This message will be part of response in case of policy violation
             * @return the next definition stage
             */
            WithCreate withDescription(String description);
        }

        /**
         * The stage of the policyassignment definition allowing to specify DisplayName.
         */
        interface WithDisplayName {
            /**
             * Specifies displayName.
             * @param displayName The display name of the policy assignment
             * @return the next definition stage
             */
            WithCreate withDisplayName(String displayName);
        }

        /**
         * The stage of the policyassignment definition allowing to specify EnforcementMode.
         */
        interface WithEnforcementMode {
            /**
             * Specifies enforcementMode.
             * @param enforcementMode The policy assignment enforcement mode. Possible values are Default and DoNotEnforce. Possible values include: 'Default', 'DoNotEnforce'
             * @return the next definition stage
             */
            WithCreate withEnforcementMode(EnforcementMode enforcementMode);
        }

        /**
         * The stage of the policyassignment definition allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The managed identity associated with the policy assignment
             * @return the next definition stage
             */
            WithCreate withIdentity(Identity identity);
        }

        /**
         * The stage of the policyassignment definition allowing to specify Location.
         */
        interface WithLocation {
            /**
             * Specifies location.
             * @param location The location of the policy assignment. Only required when utilizing managed identity
             * @return the next definition stage
             */
            WithCreate withLocation(String location);
        }

        /**
         * The stage of the policyassignment definition allowing to specify Metadata.
         */
        interface WithMetadata {
            /**
             * Specifies metadata.
             * @param metadata The policy assignment metadata
             * @return the next definition stage
             */
            WithCreate withMetadata(Object metadata);
        }

        /**
         * The stage of the policyassignment definition allowing to specify NotScopes.
         */
        interface WithNotScopes {
            /**
             * Specifies notScopes.
             * @param notScopes The policy's excluded scopes
             * @return the next definition stage
             */
            WithCreate withNotScopes(List<String> notScopes);
        }

        /**
         * The stage of the policyassignment definition allowing to specify Parameters.
         */
        interface WithParameters {
            /**
             * Specifies parameters.
             * @param parameters Required if a parameter is used in policy rule
             * @return the next definition stage
             */
            WithCreate withParameters(Object parameters);
        }

        /**
         * The stage of the policyassignment definition allowing to specify PolicyDefinitionId.
         */
        interface WithPolicyDefinitionId {
            /**
             * Specifies policyDefinitionId.
             * @param policyDefinitionId The ID of the policy definition or policy set definition being assigned
             * @return the next definition stage
             */
            WithCreate withPolicyDefinitionId(String policyDefinitionId);
        }

        /**
         * The stage of the policyassignment definition allowing to specify ScopeProperty.
         */
        interface WithScopeProperty {
            /**
             * Specifies scopeProperty.
             * @param scopeProperty The scope for the policy assignment
             * @return the next definition stage
             */
            WithCreate withScopeProperty(String scopeProperty);
        }

        /**
         * The stage of the policyassignment definition allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku The policy sku. This property is optional, obsolete, and will be ignored
             * @return the next definition stage
             */
            WithCreate withSku(PolicySku sku);
        }

        /**
         * The stage of the definition which contains all the minimum required inputs for
         * the resource to be created (via {@link WithCreate#create()}), but also allows
         * for any other optional settings to be specified.
         */
        interface WithCreate extends Creatable<PolicyAssignment>, DefinitionStages.WithDescription, DefinitionStages.WithDisplayName, DefinitionStages.WithEnforcementMode, DefinitionStages.WithIdentity, DefinitionStages.WithLocation, DefinitionStages.WithMetadata, DefinitionStages.WithNotScopes, DefinitionStages.WithParameters, DefinitionStages.WithPolicyDefinitionId, DefinitionStages.WithScopeProperty, DefinitionStages.WithSku {
        }
    }
    /**
     * The template for a PolicyAssignment update operation, containing all the settings that can be modified.
     */
    interface Update extends Appliable<PolicyAssignment>, UpdateStages.WithDescription, UpdateStages.WithDisplayName, UpdateStages.WithEnforcementMode, UpdateStages.WithIdentity, UpdateStages.WithLocation, UpdateStages.WithMetadata, UpdateStages.WithNotScopes, UpdateStages.WithParameters, UpdateStages.WithPolicyDefinitionId, UpdateStages.WithScopeProperty, UpdateStages.WithSku {
    }

    /**
     * Grouping of PolicyAssignment update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the policyassignment update allowing to specify Description.
         */
        interface WithDescription {
            /**
             * Specifies description.
             * @param description This message will be part of response in case of policy violation
             * @return the next update stage
             */
            Update withDescription(String description);
        }

        /**
         * The stage of the policyassignment update allowing to specify DisplayName.
         */
        interface WithDisplayName {
            /**
             * Specifies displayName.
             * @param displayName The display name of the policy assignment
             * @return the next update stage
             */
            Update withDisplayName(String displayName);
        }

        /**
         * The stage of the policyassignment update allowing to specify EnforcementMode.
         */
        interface WithEnforcementMode {
            /**
             * Specifies enforcementMode.
             * @param enforcementMode The policy assignment enforcement mode. Possible values are Default and DoNotEnforce. Possible values include: 'Default', 'DoNotEnforce'
             * @return the next update stage
             */
            Update withEnforcementMode(EnforcementMode enforcementMode);
        }

        /**
         * The stage of the policyassignment update allowing to specify Identity.
         */
        interface WithIdentity {
            /**
             * Specifies identity.
             * @param identity The managed identity associated with the policy assignment
             * @return the next update stage
             */
            Update withIdentity(Identity identity);
        }

        /**
         * The stage of the policyassignment update allowing to specify Location.
         */
        interface WithLocation {
            /**
             * Specifies location.
             * @param location The location of the policy assignment. Only required when utilizing managed identity
             * @return the next update stage
             */
            Update withLocation(String location);
        }

        /**
         * The stage of the policyassignment update allowing to specify Metadata.
         */
        interface WithMetadata {
            /**
             * Specifies metadata.
             * @param metadata The policy assignment metadata
             * @return the next update stage
             */
            Update withMetadata(Object metadata);
        }

        /**
         * The stage of the policyassignment update allowing to specify NotScopes.
         */
        interface WithNotScopes {
            /**
             * Specifies notScopes.
             * @param notScopes The policy's excluded scopes
             * @return the next update stage
             */
            Update withNotScopes(List<String> notScopes);
        }

        /**
         * The stage of the policyassignment update allowing to specify Parameters.
         */
        interface WithParameters {
            /**
             * Specifies parameters.
             * @param parameters Required if a parameter is used in policy rule
             * @return the next update stage
             */
            Update withParameters(Object parameters);
        }

        /**
         * The stage of the policyassignment update allowing to specify PolicyDefinitionId.
         */
        interface WithPolicyDefinitionId {
            /**
             * Specifies policyDefinitionId.
             * @param policyDefinitionId The ID of the policy definition or policy set definition being assigned
             * @return the next update stage
             */
            Update withPolicyDefinitionId(String policyDefinitionId);
        }

        /**
         * The stage of the policyassignment update allowing to specify ScopeProperty.
         */
        interface WithScopeProperty {
            /**
             * Specifies scopeProperty.
             * @param scopeProperty The scope for the policy assignment
             * @return the next update stage
             */
            Update withScopeProperty(String scopeProperty);
        }

        /**
         * The stage of the policyassignment update allowing to specify Sku.
         */
        interface WithSku {
            /**
             * Specifies sku.
             * @param sku The policy sku. This property is optional, obsolete, and will be ignored
             * @return the next update stage
             */
            Update withSku(PolicySku sku);
        }

    }
}
