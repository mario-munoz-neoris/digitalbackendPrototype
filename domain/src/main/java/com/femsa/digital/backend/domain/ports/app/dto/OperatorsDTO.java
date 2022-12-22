package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

@Data
public class OperatorsDTO {
    private String id;
    private String image;
    private String name;
    private String company;
    private String type;
    private boolean hasPackages;
}
