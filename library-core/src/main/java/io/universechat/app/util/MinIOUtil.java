package io.universechat.app.util;

import io.micronaut.context.annotation.Value;
import io.minio.*;
import io.minio.errors.*;
import jakarta.inject.Singleton;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Singleton
public class MinIOUtil {

    @Value("${minio.config.bucket-name}")
    private String bucketName;
    private MinioClient minioClient;

    private void checkBucket() {
        try {
            if(bucketName != null && !bucketName.isEmpty()) {
                BucketExistsArgs checkArgs = BucketExistsArgs.builder().bucket(bucketName).build();
                boolean found = minioClient.bucketExists(checkArgs);
                if (!found) {
                    MakeBucketArgs makeArgs = MakeBucketArgs.builder().bucket(bucketName).build();
                    minioClient.makeBucket(makeArgs);
                }
            }
            throw new Exception("MinIO bucket name is not configured. Please set 'minio.config.bucket-name' in the configuration file.");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public MinIOUtil(MinioClient minioClient) {
        this.minioClient = minioClient;
        this.checkBucket();
    }

    public ObjectWriteResponse uploadFile(String objectName, InputStream inputStream) throws Exception {
        PutObjectArgs args = PutObjectArgs.builder().stream(inputStream, -1, 10485760)
                .bucket(bucketName)
                .object(objectName)
                .build();
        return minioClient.putObject(args);
    }

    public void deleteFile(String objectName) throws Exception {
        RemoveObjectArgs args = RemoveObjectArgs.builder()
                .bucket(bucketName)
                .object(objectName)
                .skipValidation(true)
                .build();
        minioClient.removeObject(args);
    }
}
