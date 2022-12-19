package com.femsa.digital.backend.config;

import com.femsa.digital.backend.domain.ports.apis.GetOperatorsServicePort;
import com.femsa.digital.backend.domain.ports.app.OperatorServiceAppPort;
import com.femsa.digital.backend.domain.services.OperatorsService;
import com.femsa.digital.backend.infra.mioxxo.adapters.OperatorsServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OperatorsConfig {
    @Bean
    public GetOperatorsServicePort getOperatorsPort() {
        return new OperatorsServiceAdapter();
    }


    @Bean
    public OperatorServiceAppPort getOperators() {
        return new OperatorsService(getOperatorsPort());
    }
}
