package com.femsa.digital.backend.domain.ports.app.dto;

import lombok.Data;

import java.util.List;

@Data
public class AppPerkDTO {
    private String label;
    private List<String> services;
}
