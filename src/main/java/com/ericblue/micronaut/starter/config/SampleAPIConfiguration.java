package com.ericblue.micronaut.starter.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.serde.annotation.Serdeable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Configuration for an example Sample API - Reads variable info  ENV variables
 */

@Serdeable
@ConfigurationProperties("sample")
public class SampleAPIConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(SampleAPIConfiguration.class);

    private String apiKey;
    public String getApiKey() {
        return apiKey;
    }

    /* Expects syntax SAMPLE_API_KEY */
    public void setApiKey(String apiKey) {

        this.apiKey = apiKey;
    }
}
