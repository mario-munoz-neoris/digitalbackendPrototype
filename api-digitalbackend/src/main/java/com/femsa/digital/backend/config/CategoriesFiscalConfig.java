package com.femsa.digital.backend.config;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.apis.GetCategoriesServicePort;
import com.femsa.digital.backend.domain.ports.app.CategoriesServiceAppPort;
import com.femsa.digital.backend.domain.services.CategoriesService;
import com.femsa.digital.backend.infra.mioxxo.adapters.CategoriesServiceAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CategoriesFiscalConfig {

    @Bean
    public GetCategoriesServicePort getCategoriesPort() {
        return new CategoriesServiceAdapter();
    }


    @Bean
    public CategoriesServiceAppPort getCategories() {
        return new CategoriesService(getCategoriesPort());
    }
}
