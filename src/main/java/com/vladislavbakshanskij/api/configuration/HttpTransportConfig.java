package com.vladislavbakshanskij.api.configuration;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.security.GeneralSecurityException;

@Configuration
public class HttpTransportConfig {
    @Bean
    public HttpTransport httpTransport() throws GeneralSecurityException, IOException {
        return GoogleNetHttpTransport.newTrustedTransport();
    }
}
