package com.femsa.digital.backend.domain.ports.app;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseProvidersDTO;

public interface ProvidersServiceAppPort {

    public ApiResponseProvidersDTO getProviders (String provider, long limit, long page, String category);

    public ApiResponseProvidersDTO getProviderById (String providerId);

}
