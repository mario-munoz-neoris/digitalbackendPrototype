package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import lombok.Data;

import java.util.List;

@Data
public class ApiResponseCategoriesDTO {

    private String status;
    private List<CategoriesResponse> categories;
    private MetaDataResponse metadata;
}
