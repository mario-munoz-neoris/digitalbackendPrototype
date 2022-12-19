package com.femsa.digital.backend.domain.ports.app.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class ApiResponseErrorDTO {

    private UUID idRespose;
    private String status;
    private Long statusCode;
    private String mensaje;
}
