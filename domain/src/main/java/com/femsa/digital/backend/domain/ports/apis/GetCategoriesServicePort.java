package com.femsa.digital.backend.domain.ports.apis;

/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoryByIdDTO;

public interface GetCategoriesServicePort {
    ApiResponseCategoriesDTO getCategories();

    ApiResponseCategoryByIdDTO getCategoryById(String id);
}
