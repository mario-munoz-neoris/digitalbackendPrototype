package com.femsa.digital.backend.domain.services;

import com.femsa.digital.backend.domain.ports.apis.GetRegimenFiscalPort;
import com.femsa.digital.backend.domain.ports.app.FiscalRegimenServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseInvoiceDTO;

public class FiscalRegimenService implements FiscalRegimenServiceAppPort {

	private GetRegimenFiscalPort getRegimenFiscalPort;
	
	public FiscalRegimenService(GetRegimenFiscalPort getRegimenFiscalPort) {
		this.getRegimenFiscalPort = getRegimenFiscalPort;
	}
	
	
    @Override
    public ApiResponseInvoiceDTO getFiscalRegimen() {

    	return getRegimenFiscalPort.getFiscalRegimen();
    }
}
