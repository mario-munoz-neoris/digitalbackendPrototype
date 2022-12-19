package com.femsa.digital.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.femsa.digital.backend.domain.ports.apis.GetRegimenFiscalPort;
import com.femsa.digital.backend.domain.ports.app.FiscalRegimenServiceAppPort;
import com.femsa.digital.backend.domain.services.FiscalRegimenService;
import com.femsa.digital.backend.infra.mioxxo.adapters.FiscalRegimenServiceAdapter;

@Configuration
public class RegimenFiscalConfig {

	@Bean
	public GetRegimenFiscalPort getRegimenFiscalPort() {
		return new FiscalRegimenServiceAdapter();
	}
	
	
	@Bean
	public FiscalRegimenServiceAppPort getFiscalRegimenService() {
		return new FiscalRegimenService(getRegimenFiscalPort());
	}
}
