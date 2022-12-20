package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class OperatorDTO {
    private String id;
    private String image;
    private String name;
    private String company;
    private String type;
    private boolean hasPackages;
    private List<SectionDTO> sections;
}
