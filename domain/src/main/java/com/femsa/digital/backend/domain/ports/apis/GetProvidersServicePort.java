package com.femsa.digital.backend.domain.ports.apis;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseProvidersDTO;

public interface GetProvidersServicePort {

    ApiResponseProvidersDTO getProviders (String provider, long limit, long page, String category);

    ApiResponseProvidersDTO getProviderById(String providerId);
}
