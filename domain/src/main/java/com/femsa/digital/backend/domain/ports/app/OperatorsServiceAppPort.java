package com.femsa.digital.backend.domain.ports.app;


import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;

public interface OperatorsServiceAppPort {
    public ApiResponseOperatorsDTO getOperators(String query, Integer page, Integer limit);

    public ApiResponseOperatorDTO getOperator(String id);
}
