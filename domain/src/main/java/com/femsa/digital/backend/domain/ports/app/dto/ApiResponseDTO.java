package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ApiResponseDTO {

    private UUID idResponse;
    private String message;
    private ApiResponseInvoiceDTO invoiceDTO;
}
