package com.ericblue.micronaut.starter.domain;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.micronaut.serde.annotation.Serdeable;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Serdeable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@Schema(description = "Example domain object")
public class Message {

    @Schema(example = "Sample message to send/receive")
    private String text;

}

