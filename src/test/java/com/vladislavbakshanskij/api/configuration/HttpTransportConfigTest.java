package com.vladislavbakshanskij.api.configuration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.security.GeneralSecurityException;

@TestConfiguration
public class HttpTransportConfigTest {
    @Bean
    public HttpTransport httpTransport() throws GeneralSecurityException, IOException {
        return GoogleNetHttpTransport.newTrustedTransport();
    }
}
