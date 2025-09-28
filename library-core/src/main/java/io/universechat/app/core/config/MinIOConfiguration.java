package io.universechat.app.core.config;

import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.context.annotation.Value;
import io.minio.MinioClient;

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
        return MinioClient.builder()
                .endpoint(url)
                .credentials(accessKey, secretKey)
                .build();
    }
}
