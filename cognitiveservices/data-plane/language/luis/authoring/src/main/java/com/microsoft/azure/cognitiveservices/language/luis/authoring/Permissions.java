/**
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See License.txt in the project root for
 * license information.
 *
 * Code generated by Microsoft (R) AutoRest Code Generator.
 */

package com.microsoft.azure.cognitiveservices.language.luis.authoring;

import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.AddPermissionsOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.DeletePermissionsOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.UpdatePermissionsOptionalParameter;
import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.ErrorResponseException;
import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.OperationStatus;
import com.microsoft.azure.cognitiveservices.language.luis.authoring.models.UserAccessList;
import java.util.List;
import java.util.UUID;
import rx.Observable;

/**
 * An instance of this class provides access to all the operations defined
 * in Permissions.
 */
public interface Permissions {

    /**
     * Gets the list of user emails that have permissions to access your application.
     *
     * @param appId The application ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the UserAccessList object if successful.
     */
    UserAccessList list(UUID appId);

    /**
     * Gets the list of user emails that have permissions to access your application.
     *
     * @param appId The application ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the UserAccessList object
     */
    Observable<UserAccessList> listAsync(UUID appId);


    /**
     * Adds a user to the allowed list of users to access this LUIS application. Users are added using their email
     *   address.
     *
     * @param appId The application ID.
     * @param addOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the OperationStatus object if successful.
     */
    @Deprecated
    OperationStatus add(UUID appId, AddPermissionsOptionalParameter addOptionalParameter);

    /**
     * Adds a user to the allowed list of users to access this LUIS application. Users are added using their email
     *   address.
     *
     * @param appId The application ID.
     * @param addOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OperationStatus object
     */
    @Deprecated
    Observable<OperationStatus> addAsync(UUID appId, AddPermissionsOptionalParameter addOptionalParameter);

    /**
     * Adds a user to the allowed list of users to access this LUIS application. Users are added using their email
     *   address.
     *
     * @return the first stage of the add call
     */
    PermissionsAddDefinitionStages.WithAppId add();

    /**
     * Grouping of add definition stages.
     */
    interface PermissionsAddDefinitionStages {
        /**
         * The stage of the definition to be specify appId.
         */
        interface WithAppId {
            /**
             * The application ID.
             *
             * @return next definition stage
             */
            PermissionsAddDefinitionStages.WithExecute withAppId(UUID appId);
        }

        /**
         * The stage of the definition which allows for any other optional settings to be specified.
         */
        interface WithAllOptions {
            /**
             * The email address of the user.
             *
             * @return next definition stage
             */
            PermissionsAddDefinitionStages.WithExecute withEmail(String email);

        }

        /**
         * The last stage of the definition which will make the operation call.
        */
        interface WithExecute extends PermissionsAddDefinitionStages.WithAllOptions {
            /**
             * Execute the request.
             *
             * @return the OperationStatus object if successful.
             */
            OperationStatus execute();

            /**
             * Execute the request asynchronously.
             *
             * @return the observable to the OperationStatus object
             */
            Observable<OperationStatus> executeAsync();
        }
    }

    /**
     * The entirety of add definition.
     */
    interface PermissionsAddDefinition extends
        PermissionsAddDefinitionStages.WithAppId,
        PermissionsAddDefinitionStages.WithExecute {
    }

    /**
     * Removes a user from the allowed list of users to access this LUIS application. Users are removed using their
     *   email address.
     *
     * @param appId The application ID.
     * @param deleteOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the OperationStatus object if successful.
     */
    @Deprecated
    OperationStatus delete(UUID appId, DeletePermissionsOptionalParameter deleteOptionalParameter);

    /**
     * Removes a user from the allowed list of users to access this LUIS application. Users are removed using their
     *   email address.
     *
     * @param appId The application ID.
     * @param deleteOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OperationStatus object
     */
    @Deprecated
    Observable<OperationStatus> deleteAsync(UUID appId, DeletePermissionsOptionalParameter deleteOptionalParameter);

    /**
     * Removes a user from the allowed list of users to access this LUIS application. Users are removed using their
     *   email address.
     *
     * @return the first stage of the delete call
     */
    PermissionsDeleteDefinitionStages.WithAppId delete();

    /**
     * Grouping of delete definition stages.
     */
    interface PermissionsDeleteDefinitionStages {
        /**
         * The stage of the definition to be specify appId.
         */
        interface WithAppId {
            /**
             * The application ID.
             *
             * @return next definition stage
             */
            PermissionsDeleteDefinitionStages.WithExecute withAppId(UUID appId);
        }

        /**
         * The stage of the definition which allows for any other optional settings to be specified.
         */
        interface WithAllOptions {
            /**
             * The email address of the user.
             *
             * @return next definition stage
             */
            PermissionsDeleteDefinitionStages.WithExecute withEmail(String email);

        }

        /**
         * The last stage of the definition which will make the operation call.
        */
        interface WithExecute extends PermissionsDeleteDefinitionStages.WithAllOptions {
            /**
             * Execute the request.
             *
             * @return the OperationStatus object if successful.
             */
            OperationStatus execute();

            /**
             * Execute the request asynchronously.
             *
             * @return the observable to the OperationStatus object
             */
            Observable<OperationStatus> executeAsync();
        }
    }

    /**
     * The entirety of delete definition.
     */
    interface PermissionsDeleteDefinition extends
        PermissionsDeleteDefinitionStages.WithAppId,
        PermissionsDeleteDefinitionStages.WithExecute {
    }

    /**
     * Replaces the current users access list with the one sent in the body. If an empty list is sent, all access
     *   to other users will be removed.
     *
     * @param appId The application ID.
     * @param updateOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @throws ErrorResponseException thrown if the request is rejected by server
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent
     * @return the OperationStatus object if successful.
     */
    @Deprecated
    OperationStatus update(UUID appId, UpdatePermissionsOptionalParameter updateOptionalParameter);

    /**
     * Replaces the current users access list with the one sent in the body. If an empty list is sent, all access
     *   to other users will be removed.
     *
     * @param appId The application ID.
     * @param updateOptionalParameter the object representing the optional parameters to be set before calling this API
     * @throws IllegalArgumentException thrown if parameters fail the validation
     * @return the observable to the OperationStatus object
     */
    @Deprecated
    Observable<OperationStatus> updateAsync(UUID appId, UpdatePermissionsOptionalParameter updateOptionalParameter);

    /**
     * Replaces the current users access list with the one sent in the body. If an empty list is sent, all access
     *   to other users will be removed.
     *
     * @return the first stage of the update call
     */
    PermissionsUpdateDefinitionStages.WithAppId update();

    /**
     * Grouping of update definition stages.
     */
    interface PermissionsUpdateDefinitionStages {
        /**
         * The stage of the definition to be specify appId.
         */
        interface WithAppId {
            /**
             * The application ID.
             *
             * @return next definition stage
             */
            PermissionsUpdateDefinitionStages.WithExecute withAppId(UUID appId);
        }

        /**
         * The stage of the definition which allows for any other optional settings to be specified.
         */
        interface WithAllOptions {
            /**
             * The email address of the users.
             *
             * @return next definition stage
             */
            PermissionsUpdateDefinitionStages.WithExecute withEmails(List<String> emails);

        }

        /**
         * The last stage of the definition which will make the operation call.
        */
        interface WithExecute extends PermissionsUpdateDefinitionStages.WithAllOptions {
            /**
             * Execute the request.
             *
             * @return the OperationStatus object if successful.
             */
            OperationStatus execute();

            /**
             * Execute the request asynchronously.
             *
             * @return the observable to the OperationStatus object
             */
            Observable<OperationStatus> executeAsync();
        }
    }

    /**
     * The entirety of update definition.
     */
    interface PermissionsUpdateDefinition extends
        PermissionsUpdateDefinitionStages.WithAppId,
        PermissionsUpdateDefinitionStages.WithExecute {
    }

}