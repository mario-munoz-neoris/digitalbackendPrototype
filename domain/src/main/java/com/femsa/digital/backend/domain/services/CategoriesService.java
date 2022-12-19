package com.femsa.digital.backend.domain.services;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.apis.GetCategoriesServicePort;
import com.femsa.digital.backend.domain.ports.app.CategoriesServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;

public class CategoriesService implements CategoriesServiceAppPort {

    private final GetCategoriesServicePort getCategoriesServicePort;

    public CategoriesService(GetCategoriesServicePort getCategoriesServicePort) {
        this.getCategoriesServicePort = getCategoriesServicePort;
    }

    @Override
    public ApiResponseCategoriesDTO getCategories() {
        return getCategoriesServicePort.getCategories();
    }
}
