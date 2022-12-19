package com.femsa.digital.backend.infra.mioxxo.dto;

import lombok.Data;

@Data
public class ResponseToken {
    /**
     * Access token for service consumption
     */
    private String access_token;

    /**
     * Access token lifetime
     */
    private Integer expires_in;

    /**
     * Type of security
     */
    private String token_type;
}
