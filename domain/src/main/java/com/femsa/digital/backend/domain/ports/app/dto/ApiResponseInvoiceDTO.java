package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class ApiResponseInvoiceDTO {

    private String status;
    private List<DataResponse> data;
}
