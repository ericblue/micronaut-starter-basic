package com.ericblue.micronaut.starter.service;

import com.ericblue.micronaut.starter.config.SampleAPIConfiguration;
import com.ericblue.micronaut.starter.domain.Message;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.runtime.context.scope.ThreadLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * This class is a wrapper for the sample API client
 */

@ThreadLocal
public class SampleAPIService {

    private static final Logger logger = LoggerFactory.getLogger(SampleAPIService.class);

    private final SampleAPIConfiguration sampleAPIConfiguration;

    /**
     * Constructor
     *
     * @param sampleAPIConfiguration Sample API configuration containing the API key
     */
    public SampleAPIService(@Nullable SampleAPIConfiguration sampleAPIConfiguration) {

        logger.info("Initializing Sample API Service");
        this.sampleAPIConfiguration = sampleAPIConfiguration;

    }

    public SampleAPIConfiguration getSampleAPIConfiguration() {
        return sampleAPIConfiguration;
    }

    /**
     * This method calls the sample API client to send a message
     *
     * @param message Message sent by the user
     * @return String response from the sample API client
     */
    public Message sendMessage(Message message) {

        Message responseMessage = new Message("Hello! The message you sent was: " + message.getText());

        return responseMessage;
    }


}
