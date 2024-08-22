package com.example.ecomm.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationProperties {
    @Bean
    public RestTemplate createRestTemplate() {
        return new RestTemplate(
                new JdkClientHttpRequestFactory()
        );
    }
}
