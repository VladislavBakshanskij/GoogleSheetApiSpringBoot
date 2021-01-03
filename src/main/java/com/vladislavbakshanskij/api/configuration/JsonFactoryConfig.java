package com.vladislavbakshanskij.api.configuration;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonFactoryConfig {
    @Bean
    public JsonFactory jsonFactory() {
        return JacksonFactory.getDefaultInstance();
    }
}
