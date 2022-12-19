package com.femsa.digital.backend.domain.ports.app;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;

public interface CategoriesServiceAppPort {
    ApiResponseCategoriesDTO getCategories();
}
