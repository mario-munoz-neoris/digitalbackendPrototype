package com.femsa.digital.backend.domain.services;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.apis.GetProvidersServicePort;
import com.femsa.digital.backend.domain.ports.app.ProvidersServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseProvidersDTO;

public class ProvidersService implements ProvidersServiceAppPort {

    private final GetProvidersServicePort getProvidersServicePort;

    public ProvidersService(GetProvidersServicePort getProvidersServicePort) {
        this.getProvidersServicePort = getProvidersServicePort;
    }

    @Override
    public ApiResponseProvidersDTO getProviders (String provider, long limit, long page, String category) {
        return getProvidersServicePort.getProviders(provider, limit, page, category);
    }

    @Override
    public ApiResponseProvidersDTO getProviderById (String providerId) {
        return getProvidersServicePort.getProviderById(providerId);
    }
}
