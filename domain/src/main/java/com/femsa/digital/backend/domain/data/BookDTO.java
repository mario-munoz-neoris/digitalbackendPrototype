package com.femsa.digital.backend.domain.data;

import lombok.Data;

@Data
public class BookDTO {

    private Long id;

    private String title;

    private String description;

    private Double price;
    
}