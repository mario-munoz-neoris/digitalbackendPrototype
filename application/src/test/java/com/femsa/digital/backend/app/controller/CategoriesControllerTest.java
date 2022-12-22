package com.femsa.digital.backend.app.controller;

import com.femsa.digital.backend.domain.ports.app.CategoriesServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoryByIdDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CategoriesControllerTest {

    @InjectMocks
    CategoriesController controller;

    @Mock
    CategoriesServiceAppPort serviceAppPort;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCategories() {
        when(serviceAppPort.getCategories()).thenReturn(new ApiResponseCategoriesDTO());
        ResponseEntity<ApiResponseCategoriesDTO> response = controller.getCategories();
        assertNotNull(response);
    }

    @Test
    void getCategoryById() {
        when(serviceAppPort.getCategoryById("")).thenReturn(new ApiResponseCategoryByIdDTO());
        ResponseEntity<ApiResponseCategoryByIdDTO> response = controller.getCategoryById("1");
        assertNotNull(response);
    }
}