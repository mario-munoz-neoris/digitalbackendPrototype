package com.femsa.digital.backend.config;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */


import com.femsa.digital.backend.infra.mioxxo.adapters.ProvidersServiceAdapter;
import com.femsa.digital.backend.domain.ports.apis.GetProvidersServicePort;
import com.femsa.digital.backend.domain.ports.app.ProvidersServiceAppPort;
import com.femsa.digital.backend.domain.services.ProvidersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProvidersConfig {

    @Bean
    public GetProvidersServicePort getProvidersServicePort() {
        return new ProvidersServiceAdapter();
    }


    @Bean
    public ProvidersServiceAppPort getProviders() {
        return new ProvidersService(getProvidersServicePort());
    }
}
