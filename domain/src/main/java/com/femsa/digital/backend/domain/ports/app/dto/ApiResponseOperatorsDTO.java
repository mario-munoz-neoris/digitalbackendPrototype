package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponseOperatorsDTO {
    private String status;
    private List<OperatorsDTO> operators;
    private MetaDataResponse metadata;
}
