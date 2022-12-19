package com.femsa.digital.backend.domain.ports.apis;

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseInvoiceDTO;

public interface GetRegimenFiscalPort {

	public ApiResponseInvoiceDTO getFiscalRegimen();
}
