package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class ItemDTO {
    private String id;
    private String name;
    private String description;
    private Long amount;
    private String title;
    private List<PerksDTO> perks;
}
