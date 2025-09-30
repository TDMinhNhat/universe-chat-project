package io.universechat.app.core.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.minio.MinioClient;
import io.universechat.app.core.exception.CredentialMinIOException;

@Factory
public class MinIOConfiguration {

    @Value("${minio.config.url}")
    private String url;

    @Value("${minio.config.access-key}")
    private String accessKey;

    @Value("${minio.config.secret-key}")
    private String secretKey;

    @Bean
    public MinioClient minioClient() {
        if(url == null || url.isEmpty()) {
            throw new CredentialMinIOException("MinIO URL is not configured. Please set 'minio.config.url' in the configuration file.");
        } else if(accessKey == null || accessKey.isEmpty()) {
            throw new CredentialMinIOException("MinIO access key is not configured. Please set 'minio.config.access-key' in the configuration file.");
        } else if(secretKey == null || secretKey.isEmpty()) {
            throw new CredentialMinIOException("MinIO secret key is not configured. Please set 'minio.config.secret-key' in the configuration file.");
        }
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
