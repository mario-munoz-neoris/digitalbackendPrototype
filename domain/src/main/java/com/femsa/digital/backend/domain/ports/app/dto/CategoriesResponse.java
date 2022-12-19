package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import lombok.Data;

import java.util.List;

@Data
public class CategoriesResponse {
    private String id;
    private String name;
    private String image;
    private String status;
    private Integer order;
    private Boolean root;
    private List<Children> children;

}

@Data
class Children{
    private String id;
}
