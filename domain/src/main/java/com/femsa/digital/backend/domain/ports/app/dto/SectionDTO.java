package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class SectionDTO {
    private String type;
    private String name;
    private String image;
    private String title;
    private List<ItemDTO> items;
}
