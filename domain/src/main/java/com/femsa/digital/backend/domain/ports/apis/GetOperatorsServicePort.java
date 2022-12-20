package com.femsa.digital.backend.domain.ports.apis;

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;

public interface GetOperatorsServicePort {
    public ApiResponseOperatorsDTO getOperators();
}
