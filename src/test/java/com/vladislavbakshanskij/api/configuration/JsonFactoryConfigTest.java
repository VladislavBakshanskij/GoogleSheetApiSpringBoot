package com.vladislavbakshanskij.api.configuration;

import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class JsonFactoryConfigTest {
    @Bean
    public JsonFactory jsonFactory() {
        return JacksonFactory.getDefaultInstance();
    }
}
