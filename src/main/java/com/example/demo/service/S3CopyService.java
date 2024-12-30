package com.example.demo.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.CopyObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import org.springframework.stereotype.Service;

@Service
public class S3CopyService {

    private final AmazonS3 s3Client;

    public S3CopyService() {
        this.s3Client = AmazonS3ClientBuilder.standard()
                .withRegion("us-west-2") // Source bucket region
                .build();
    }

    public String copyObjects(String sourceBucket, String destinationBucket) {
        StringBuilder log = new StringBuilder();
        ListObjectsV2Request request = new ListObjectsV2Request().withBucketName(sourceBucket);

        ListObjectsV2Result result;
        do {
            result = s3Client.listObjectsV2(request);
            for (S3ObjectSummary obj : result.getObjectSummaries()) {
                String sourceKey = obj.getKey();
                log.append("Copying: ").append(sourceKey).append("\n");

                CopyObjectRequest copyRequest = new CopyObjectRequest(
                        sourceBucket, sourceKey, destinationBucket, sourceKey);

                s3Client.copyObject(copyRequest);
                log.append("Copied: ").append(sourceKey).append("\n");
            }

            request.setContinuationToken(result.getNextContinuationToken());
        } while (result.isTruncated());

        return log.toString();
    }
}

