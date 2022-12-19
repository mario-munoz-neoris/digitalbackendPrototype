package com.femsa.digital.backend.domain.services;

import com.femsa.digital.backend.domain.ports.apis.GetOperatorsServicePort;
import com.femsa.digital.backend.domain.ports.app.OperatorServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;

public class OperatorsService implements OperatorServiceAppPort {
    private final GetOperatorsServicePort getOperatorsServicePort;

    public OperatorsService(GetOperatorsServicePort getOperatorsServicePort) {
        this.getOperatorsServicePort = getOperatorsServicePort;
    }

    @Override
    public ApiResponseOperatorsDTO getOperators() {
        return getOperatorsServicePort.getOperators();
    }
}
