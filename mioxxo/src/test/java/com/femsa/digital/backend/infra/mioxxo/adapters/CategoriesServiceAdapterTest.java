package com.femsa.digital.backend.infra.mioxxo.adapters;


import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoryByIdDTO;
import com.femsa.digital.backend.domain.ports.app.dto.CategoriesResponse;
import com.femsa.digital.backend.domain.ports.app.dto.MetaDataResponse;
import com.femsa.digital.backend.infra.mioxxo.services.TokenAccessService;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.UNAUTHORIZED_CODE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@Slf4j
@RunWith(MockitoJUnitRunner.class)
class CategoriesServiceAdapterTest {

    @InjectMocks
    CategoriesServiceAdapter serviceAdapter;

    @Mock
    TokenAccessService tokenAccess;

    @Mock
    RestTemplate restTemplate;

    @Mock
    MiOxxoProperties properties;

    @Autowired
    private MockMvc mockMvc;

    private String urlBase = "https://development.mgo.mioxxo-dev.io";
    private String urlCategories = "/api/v3/categories";


    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getCategoryById() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoryByIdDTO.class)))
                    .thenReturn(ResponseEntity.ok().body(categoryById()));
            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoryByIdDTO response = serviceAdapter.getCategoryById("12");
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getMessage());
        }
    }

    @Test
    void getCategories() {
        try {

            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoriesDTO.class)))
                    .thenReturn(ResponseEntity.ok().body(createResponseCategories()));
            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoriesDTO response = serviceAdapter.getCategories();
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getMessage());
        }
    }

    @Test
    void getCategoryByIdUnauthorized() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoryByIdDTO.class)))
                    .thenThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED));
            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoryByIdDTO response = serviceAdapter.getCategoryById("12");
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getMessage());
            assertEquals(UNAUTHORIZED_CODE.toString(), ex.getMessage(), "Servicio no autorizado.");
        }
    }

    @Test
    void getCategoryByIdServiceUnavailable() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoryByIdDTO.class)))
                    .thenThrow(new HttpClientErrorException(HttpStatus.SERVICE_UNAVAILABLE));
            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoryByIdDTO response = serviceAdapter.getCategoryById("12");
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getMessage());
            assertEquals(SERVICE_UNAVAILABLE_CODE.toString(), ex.getMessage(), "Servicio no dispobible.");
        }
    }

    @Test
    void getCategoryByIdExceptions() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoryByIdDTO.class)))
                    .thenThrow(new RuntimeException());

            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoryByIdDTO response = serviceAdapter.getCategoryById("12");
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getCause());
            assertEquals(SERVICE_UNAVAILABLE_CODE.toString(), ex.getMessage());
        }
    }

    @Test
    void getCategoryByIdBodyNull() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoryByIdDTO.class)))
                    .thenReturn(ResponseEntity.ok().body(null));

            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoryByIdDTO response = serviceAdapter.getCategoryById("12");
            assertNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getCause());
            assertEquals(SERVICE_UNAVAILABLE_CODE.toString(), ex.getMessage());
        }
    }

    @Test
    void getCategoriesUnauthorized() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoriesDTO.class)))
                    .thenThrow(new HttpClientErrorException(HttpStatus.UNAUTHORIZED));
            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoriesDTO response = serviceAdapter.getCategories();
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getMessage());
            assertEquals(UNAUTHORIZED_CODE.toString(), ex.getMessage(), "Servicio no autorizado.");
        }
    }

    @Test
    void getCategoriesServiceUnavailable() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoriesDTO.class)))
                    .thenThrow(new HttpClientErrorException(HttpStatus.SERVICE_UNAVAILABLE));
            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoriesDTO response = serviceAdapter.getCategories();
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getMessage());
            assertEquals(SERVICE_UNAVAILABLE_CODE.toString(), ex.getMessage(), "Servicio no dispobible.");
        }
    }

    @Test
    void getCategoriesExceptions() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoriesDTO.class)))
                    .thenThrow(new RuntimeException());

            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoriesDTO response = serviceAdapter.getCategories();
            assertNotNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getCause());
            assertEquals(SERVICE_UNAVAILABLE_CODE.toString(), ex.getMessage());
        }
    }

    @Test
    void getCategoriesBodyNull() {
        try {
            when(restTemplate.exchange(any(), Mockito.eq(ApiResponseCategoriesDTO.class)))
                    .thenReturn(ResponseEntity.ok().body(null));

            when(properties.getGetCategories()).thenReturn(urlCategories);
            when(properties.getBaseUrl()).thenReturn(urlBase);

            ApiResponseCategoriesDTO response = serviceAdapter.getCategories();
            assertNull(response);
        }catch (Exception ex){
            log.error("No se realizo correctamente la validación: {}", ex.getCause());
            assertEquals(SERVICE_UNAVAILABLE_CODE.toString(), ex.getMessage());
        }
    }

    ApiResponseCategoriesDTO createResponseCategories(){
        ApiResponseCategoriesDTO categoriesDTO = new ApiResponseCategoriesDTO();

        MetaDataResponse metaData = new MetaDataResponse();
        metaData.setPage(1);
        metaData.setTotal(2);
        metaData.setPer_page(1);
        metaData.setTotal_pages(2);

        List<CategoriesResponse> categories = new ArrayList<>();
        CategoriesResponse categoriesResponse = new CategoriesResponse();
        categoriesResponse.setStatus("success");
        categoriesResponse.setId("22342342sdfs");
        categoriesResponse.setName("name");
        categories.add(categoriesResponse);

        categoriesResponse = new CategoriesResponse();
        categoriesResponse.setStatus("success");
        categoriesResponse.setId("85576543sdfs");
        categoriesResponse.setName("name_dos");
        categories.add(categoriesResponse);

        categoriesDTO.setStatus("Success");
        categoriesDTO.setMetadata(metaData);
        categoriesDTO.setCategories(categories);

        return categoriesDTO;
    }

    ApiResponseCategoryByIdDTO categoryById(){
        ApiResponseCategoryByIdDTO categoryByIdDTO = new ApiResponseCategoryByIdDTO();

        CategoriesResponse category = new CategoriesResponse();
        category.setName("CategoryById");
        category.setStatus("success");
        category.setId("23456");

        categoryByIdDTO.setStatus("success");
        categoryByIdDTO.setCategory(category);

        return categoryByIdDTO;
    }
}