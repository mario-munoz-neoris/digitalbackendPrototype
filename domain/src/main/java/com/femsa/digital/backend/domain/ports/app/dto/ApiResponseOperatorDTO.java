package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;


@Data
public class ApiResponseOperatorDTO {
    private String status;
    private OperatorDTO operators;
    private MetaDataResponse metadata;
}
