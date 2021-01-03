package com.vladislavbakshanskij.api.configuration;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.List;

@Configuration
public class SheetConfig {
    @Value("${credential}")
    private String credentialFileName;

    @Value("${google.sheet.port}")
    private int port;

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private final List<String> scopes;

    public SheetConfig() {
        scopes = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    }

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    @Bean
    public Credential credential(final HttpTransport HTTP_TRANSPORT, JsonFactory jsonFactory) throws IOException {
        // Load client secrets.
        var in = SheetConfig.class.getResourceAsStream(credentialFileName);

        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + credentialFileName);
        }

        var clientSecrets = GoogleClientSecrets.load(jsonFactory, new InputStreamReader(in));

        final String TOKENS_DIRECTORY_PATH = "tokens";

        // Build flow and trigger user authorization request.
        var flow = new GoogleAuthorizationCodeFlow.Builder(
            HTTP_TRANSPORT, jsonFactory, clientSecrets, scopes)
            .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
            .setAccessType("offline")
            .build();

        var receiver = new LocalServerReceiver.Builder().setPort(port).build();
        return new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
    }

    @Bean
    public Sheets sheets(HttpTransport httpTransport, JsonFactory jsonFactory, Credential credential) {
        return new Sheets.Builder(httpTransport, jsonFactory, credential)
            .setApplicationName("API")
            .build();
    }
}
