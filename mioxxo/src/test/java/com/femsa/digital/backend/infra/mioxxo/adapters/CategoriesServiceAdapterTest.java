package com.femsa.digital.backend.infra.mioxxo.adapters;

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.AssertionErrors;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static org.junit.jupiter.api.Assertions.*;

class CategoriesServiceAdapterTest {

    @InjectMocks
    CategoriesServiceAdapter serviceAdapter;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCategoryById() {
    }

    @Test
    void getCategories() {
        try {
            ApiResponseCategoriesDTO value = serviceAdapter.getCategories();
            assertNotNull(value);
        }catch (Exception ex){
            assertEquals(ex.getMessage(), SERVICE_UNAVAILABLE_CODE.toString(),  "Error {} " + ex.getMessage());
        }
    }
}