package com.azure.storage.blob.batch

import com.azure.core.http.HttpPipelineBuilder
import com.azure.core.http.policy.HttpPipelinePolicy
import com.azure.core.util.Context
import com.azure.storage.blob.BlobServiceAsyncClient
import com.azure.storage.blob.models.AccessTier
import com.azure.storage.blob.models.BlobStorageException
import com.azure.storage.blob.models.DeleteSnapshotsOptionType
import spock.lang.Unroll

class BatchAPITest extends APISpec {
    static def setupCustomPolicyBatch(BlobServiceAsyncClient blobServiceAsyncClient, HttpPipelinePolicy customPolicy) {
        def clientPipeline = blobServiceAsyncClient.getHttpPipeline()

        def policies = new HttpPipelinePolicy[clientPipeline.getPolicyCount() + 1]
        for (def i = 0; i < clientPipeline.getPolicyCount(); i++) {
            policies[i] = clientPipeline.getPolicy(i)
        }

        policies[clientPipeline.getPolicyCount()] = customPolicy

        return new BlobBatch(blobServiceAsyncClient.getAccountUrl(), new HttpPipelineBuilder()
            .policies(policies)
            .httpClient(clientPipeline.getHttpClient())
            .build())
    }

    BlobBatchClient batchClient
    BlobBatchClient oauthBatchClient

    def setup() {
        batchClient = new BlobBatchClientBuilder(primaryBlobServiceClient).buildClient()
        oauthBatchClient = new BlobBatchClientBuilder(getOAuthServiceClient()).buildClient()
    }

    def "Empty batch"() {
        when:
        def batch = batchClient.getBlobBatch()
        batchClient.submitBatch(batch)

        then:
        thrown(UnsupportedOperationException)
    }

    def "Mixed batch"() {
        when:
        def batch = batchClient.getBlobBatch()
        batch.deleteBlob("container", "blob")
        batch.setBlobAccessTier("container", "blob2", AccessTier.HOT)

        then:
        thrown(UnsupportedOperationException)

        when:
        batch = batchClient.getBlobBatch()
        batch.setBlobAccessTier("container", "blob", AccessTier.HOT)
        batch.deleteBlob("container", "blob2")

        then:
        thrown(UnsupportedOperationException)
    }

    def "Set tier all succeed"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getBlockBlobClient().upload(defaultInputStream.get(), defaultDataSize)
        containerClient.getBlobClient(blobName2).getBlockBlobClient().upload(defaultInputStream.get(), defaultDataSize)

        when:
        def response1 = batch.setBlobAccessTier(containerName, blobName1, AccessTier.HOT)
        def response2 = batch.setBlobAccessTier(containerName, blobName2, AccessTier.COOL)
        batchClient.submitBatch(batch)

        then:
        notThrown(BlobStorageException)
        response1.getStatusCode() == 200
        response2.getStatusCode() == 200

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Set tier some succeed throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getBlockBlobClient().upload(defaultInputStream.get(), defaultDataSize)

        when:
        def response1 = batch.setBlobAccessTier(containerName, blobName1, AccessTier.HOT)
        def response2 = batch.setBlobAccessTier(containerName, blobName2, AccessTier.COOL)
        batchClient.submitBatch(batch)

        then:
        thrown(BlobBatchStorageException)
        response1.getStatusCode() == 200

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Set tier some succeed do not throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getBlockBlobClient().upload(defaultInputStream.get(), defaultDataSize)

        when:
        def response1 = batch.setBlobAccessTier(containerName, blobName1, AccessTier.HOT)
        def response2 = batch.setBlobAccessTier(containerName, blobName2, AccessTier.COOL)
        batchClient.submitBatchWithResponse(batch, false, null, Context.NONE)

        then:
        notThrown(BlobStorageException)
        response1.getStatusCode() == 200

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Set tier none succeed throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        primaryBlobServiceClient.createBlobContainer(containerName)

        when:
        def response1 = batch.setBlobAccessTier(containerName, blobName1, AccessTier.HOT)
        def response2 = batch.setBlobAccessTier(containerName, blobName2, AccessTier.COOL)
        batchClient.submitBatch(batch)

        then:
        def ex = thrown(BlobBatchStorageException)
        ex.getBatchExceptions().size() == 2

        when:
        response1.getStatusCode()

        then:
        thrown(BlobStorageException)

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Set tier none succeed do not throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        primaryBlobServiceClient.createBlobContainer(containerName)

        when:
        def response1 = batch.setBlobAccessTier(containerName, blobName1, AccessTier.HOT)
        def response2 = batch.setBlobAccessTier(containerName, blobName2, AccessTier.COOL)
        batchClient.submitBatchWithResponse(batch, false, null, Context.NONE)

        then:
        notThrown(BlobStorageException)

        when:
        response1.getStatusCode()

        then:
        thrown(BlobStorageException)

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Delete blob all succeed"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getPageBlobClient().create(0)
        containerClient.getBlobClient(blobName2).getPageBlobClient().create(0)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        def response2 = batch.deleteBlob(containerName, blobName2)
        batchClient.submitBatch(batch)

        then:
        notThrown(BlobStorageException)
        response1.getStatusCode() == 202
        response2.getStatusCode() == 202

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Delete blob some succeed throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getPageBlobClient().create(0)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        def response2 = batch.deleteBlob(containerName, blobName2)
        batchClient.submitBatch(batch)

        then:
        thrown(BlobBatchStorageException)
        response1.getStatusCode() == 202

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Delete blob some succeed do not throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getPageBlobClient().create(0)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        def response2 = batch.deleteBlob(containerName, blobName2)
        batchClient.submitBatchWithResponse(batch, false, null, Context.NONE)

        then:
        notThrown(BlobStorageException)
        response1.getStatusCode() == 202

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Delete blob none succeed throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        primaryBlobServiceClient.createBlobContainer(containerName)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        def response2 = batch.deleteBlob(containerName, blobName2)
        batchClient.submitBatch(batch)

        then:
        def ex = thrown(BlobBatchStorageException)
        ex.getBatchExceptions().size() == 2

        when:
        response1.getStatusCode()

        then:
        thrown(BlobStorageException)

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Delete blob none succeed do not throw on any error"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        primaryBlobServiceClient.createBlobContainer(containerName)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        def response2 = batch.deleteBlob(containerName, blobName2)
        batchClient.submitBatchWithResponse(batch, false, null, Context.NONE)

        then:
        notThrown(BlobStorageException)

        when:
        response1.getStatusCode()

        then:
        thrown(BlobStorageException)

        when:
        response2.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Accessing batch request before submission throws"() {
        setup:
        def batch = batchClient.getBlobBatch()

        when:
        def batchRequest = batch.deleteBlob("blob", "container")
        batchRequest.getStatusCode()

        then:
        thrown(UnsupportedOperationException)
    }

    def "Bulk delete blobs"() {
        setup:
        def containerName = generateContainerName()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        def blobUrls = new ArrayList<String>()
        for (def i = 0; i < 10; i++) {
            def pageBlobClient = containerClient.getBlobClient(generateBlobName()).getPageBlobClient()
            pageBlobClient.create(512)
            blobUrls.add(pageBlobClient.getBlobUrl())
        }

        when:
        def responses = batchClient.deleteBlobs(blobUrls, DeleteSnapshotsOptionType.INCLUDE)

        then:
        for (def response : responses) {
            assert response.getStatusCode() == 202
        }

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Bulk set access tier"() {
        setup:
        def containerName = generateContainerName()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        def blobUrls = new ArrayList<String>()
        for (def i = 0; i < 10; i++) {
            def pageBlobClient = containerClient.getBlobClient(generateBlobName()).getBlockBlobClient()
            pageBlobClient.upload(defaultInputStream.get(), defaultDataSize)
            blobUrls.add(pageBlobClient.getBlobUrl())
        }

        when:
        def responses = batchClient.setBlobsAccessTier(blobUrls, AccessTier.HOT)

        then:
        for (def response : responses) {
            assert response.getStatusCode() == 200
        }

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Too many operations fails"() {
        setup:
        def containerName = generateContainerName()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        def blobUrls = new ArrayList<String>()
        for (def i = 0; i < 257; i++) {
            def pageBlobClient = containerClient.getBlobClient(generateBlobName()).getPageBlobClient()
            blobUrls.add(pageBlobClient.getBlobUrl())
        }

        when:
        batchClient.deleteBlobs(blobUrls, DeleteSnapshotsOptionType.INCLUDE).iterator().next()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    def "Single operation exception throws BlobBatchStorageException"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def batch = batchClient.getBlobBatch()
        primaryBlobServiceClient.createBlobContainer(containerName)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        batchClient.submitBatch(batch)

        then:
        thrown(BlobBatchStorageException)

        when:
        response1.getStatusCode()

        then:
        thrown(BlobStorageException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }

    @Unroll
    def "Submitting same batch many times"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName2).getPageBlobClient().create(0)

        when:
        def batch = batchClient.getBlobBatch()
        batch.deleteBlob(containerName, blobName1, DeleteSnapshotsOptionType.INCLUDE, null)
        batch.deleteBlob(containerName, blobName2, DeleteSnapshotsOptionType.INCLUDE, null)
        batchClient.submitBatch(batch)

        then:
        thrown(BlobBatchStorageException)

        when:
        batchClient.submitBatch(batch)

        then:
        thrown(UnsupportedOperationException)

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)

        where:
        i << (1..20)
    }

    def "Submit batch with oauth credentials"() {
        setup:
        def containerName = generateContainerName()
        def blobName1 = generateBlobName()
        def blobName2 = generateBlobName()
        def batch = oauthBatchClient.getBlobBatch()
        def containerClient = primaryBlobServiceClient.createBlobContainer(containerName)
        containerClient.getBlobClient(blobName1).getPageBlobClient().create(0)
        containerClient.getBlobClient(blobName2).getPageBlobClient().create(0)

        when:
        def response1 = batch.deleteBlob(containerName, blobName1)
        def response2 = batch.deleteBlob(containerName, blobName2)
        oauthBatchClient.submitBatch(batch)

        then:
        notThrown(BlobStorageException)
        response1.getStatusCode() == 202
        response2.getStatusCode() == 202

        cleanup:
        primaryBlobServiceClient.deleteBlobContainer(containerName)
    }
}
