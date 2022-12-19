package com.femsa.digital.backend.domain.ports.app;


import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseInvoiceDTO;

public interface FiscalRegimenServiceAppPort {

    public ApiResponseInvoiceDTO getFiscalRegimen();
}
