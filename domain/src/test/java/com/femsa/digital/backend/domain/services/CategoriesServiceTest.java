package com.femsa.digital.backend.domain.services;

import com.femsa.digital.backend.domain.ports.apis.GetCategoriesServicePort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoryByIdDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

class CategoriesServiceTest {

    @InjectMocks
    CategoriesService service;

    @Mock
    GetCategoriesServicePort servicePort;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCategories() {
        when(servicePort.getCategories()).thenReturn(new ApiResponseCategoriesDTO());
        ApiResponseCategoriesDTO response = service.getCategories();
        assertNotNull(response);
    }

    @Test
    void getCategoryById() {
        String id = "43fsdf345";
        when(servicePort.getCategoryById(id)).thenReturn(new ApiResponseCategoryByIdDTO());
        ApiResponseCategoryByIdDTO response = service.getCategoryById(id);
        assertNotNull(response);
    }
}