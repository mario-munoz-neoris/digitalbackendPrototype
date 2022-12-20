package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class PerksDTO {
    private String expired;
    private String legend;
    private String megas;
    private String sku;
    private String itemId;
    private List<AppPerkDTO> appsPerks;
}
