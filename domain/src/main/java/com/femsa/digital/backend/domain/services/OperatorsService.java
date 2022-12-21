package com.femsa.digital.backend.domain.services;

import com.femsa.digital.backend.domain.ports.apis.GetOperatorsServicePort;
import com.femsa.digital.backend.domain.ports.app.OperatorsServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;

public class OperatorsService implements OperatorsServiceAppPort {
    private final GetOperatorsServicePort getOperatorsServicePort;

    public OperatorsService(GetOperatorsServicePort getOperatorsServicePort) {
        this.getOperatorsServicePort = getOperatorsServicePort;
    }

    @Override
    public ApiResponseOperatorsDTO getOperators(String query, Integer page, Integer limit) {

        return getOperatorsServicePort.getOperators(query, page, limit);
    }

    @Override
    public ApiResponseOperatorDTO getOperator(String id) {
        return getOperatorsServicePort.getOperator(id);
    }
}
