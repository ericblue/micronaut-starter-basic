package com.ericblue.micronaut.starter;

import io.micronaut.core.util.StringUtils;
import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.info.*;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;


@OpenAPIDefinition(
    info = @Info(
            title = "micronaut-starter-basic",
            version = "0.1"
    )
)
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);
    private static final Map<String, String> requiredEnvVars = new HashMap<>();

    static {
        requiredEnvVars.put("SAMPLE_API_KEY", "API Key for sample api service");
    }

    private static void validateEnvVars(Map<String, String> envVars) {
        envVars.forEach((name, description) -> {
            String value = System.getenv(name);
            if (StringUtils.isEmpty(value)) {
                throw new RuntimeException("ENV Variable [" + name + "] " + description + " environment variable not set");
            }
            else {
                logger.info("ENV Variable [" + name + "] " + description + " environment variable set to value: " + value);
            }

        });
    }

    public static void main(String[] args) {

        logger.info("Checking required env variables for startup");
        validateEnvVars(requiredEnvVars);

        logger.info("Starting Micronaut application");
        Micronaut.run(Application.class, args);
    }
}