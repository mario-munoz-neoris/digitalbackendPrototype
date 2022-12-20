package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import lombok.Data;

import java.util.List;
@Data
public class ApiResponseCategoryByIdDTO{

    private String status;
    private CategoriesResponse category;
}
