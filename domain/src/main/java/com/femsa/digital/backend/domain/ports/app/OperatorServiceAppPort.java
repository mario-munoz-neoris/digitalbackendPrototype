package com.femsa.digital.backend.domain.ports.app;


import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;

public interface OperatorServiceAppPort {
    public ApiResponseOperatorsDTO getOperators();
}
