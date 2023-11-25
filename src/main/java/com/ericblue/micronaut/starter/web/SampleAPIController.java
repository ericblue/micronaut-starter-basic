package com.ericblue.micronaut.starter.web;

import com.ericblue.micronaut.starter.config.SampleAPIConfiguration;
import com.ericblue.micronaut.starter.domain.Message;
import com.ericblue.micronaut.starter.exception.RestException;
import com.ericblue.micronaut.starter.service.SampleAPIService;
import com.ericblue.micronaut.starter.util.ConfigUtils;
import com.github.jknack.handlebars.internal.lang3.StringUtils;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import jakarta.inject.Inject;

/**
 * This controller is responsible for returning the SampleAPI configuration
 * and sending a messages to the SampleAPIService
 *
 */
@Controller("/sampleapi")
public class SampleAPIController {

    @Inject
    SampleAPIService sampleAPIService;

    /** This method returns the SampleAPI configuration */
    @Get("/config")
    public SampleAPIConfiguration getSampleAPIConfiguration() {

        if ( (sampleAPIService.getSampleAPIConfiguration().getApiKey() == null)) {
            throw new RestException("SampleAPIConfiguration is empty. API_KEY environment variable is not set.");
        }

        else {
            SampleAPIConfiguration sampleAPIConfiguration = sampleAPIService.getSampleAPIConfiguration();
            String obfuscatedKey = ConfigUtils.obfuscateApiKey(sampleAPIConfiguration.getApiKey());

            SampleAPIConfiguration returnedConfiguration = new SampleAPIConfiguration();
            returnedConfiguration.setApiKey(obfuscatedKey);

            return returnedConfiguration;

        }

    }

    /**
     * This method is called when the user sends a message to the SampleAPIService
     ** @param text Message sent by the user
     * @return ResponseMessage response from the SampleAPIService
     */

    @Get("/sendmessage")
    public Message sendMessage(@QueryValue("text") String text) {

        if (!(StringUtils.isEmpty(text))) {
            Message message = new Message(text);
            Message responseMessage = sampleAPIService.sendMessage(message);
            return responseMessage;
        } else {
            throw new RestException("message is empty");
        }

    }


}
