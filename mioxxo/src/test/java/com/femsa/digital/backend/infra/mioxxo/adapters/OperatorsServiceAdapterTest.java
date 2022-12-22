package com.femsa.digital.backend.infra.mioxxo.adapters;

import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;
import com.femsa.digital.backend.infra.mioxxo.services.TokenAccessService;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static com.femsa.digital.backend.infra.mioxxo.utils.UtilsTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


public class OperatorsServiceAdapterTest {

    @InjectMocks
    OperatorsServiceAdapter operatorsServiceAdapter;

    @Mock
    TokenAccessService tokenAccess;

    @Mock
    MiOxxoProperties properties;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void inicializaMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getOperators()  {
        when(restTemplate.exchange(any(), Mockito.eq(ApiResponseOperatorsDTO.class))).thenReturn(createResponseEntity());
        when(properties.getGetOperators()).thenReturn("/api/v3/operators");
        when(properties.getBaseUrl()).thenReturn("https://development.mgo.mioxxo-dev.io");
        when(tokenAccess.getToken()).thenReturn("5zYWN0aW9ucy5yZWFkIGFwaVwvYmlsbHBheW1lbnRzLmNyZWF0ZSBhcGlcL29wZXJhdG9ycy5yZWFkIGFwaVwvaW52b2ljZXMuY3JlYXRlIGFwaVwvdG9wdXBzLmNyZWF0ZSBjb25jaWxpYXRpb25cL3RvcHVwLmNyZWF0ZSBhcGlcL29yZGVycy5yZWFkIGFwaVwvcHJvdmlkZXJzLnJlYWQgY29uY2lsaWF0aW9uXC9wcm92aWRlcnMuY3JlYXRlIiwiYXV0aF9");

        ApiResponseOperatorsDTO response = operatorsServiceAdapter.getOperators("",0,0);
        Assertions.assertNotNull(response);
    }

    @Test
    public void getOperatorsError() {
        try {
            ApiResponseOperatorsDTO response = operatorsServiceAdapter.getOperators("",1,2);
            Assertions.assertNotNull(response);
        }catch (Exception ex){
            assertEquals(ex.getMessage(), SERVICE_UNAVAILABLE_CODE.toString(),  "Error {} " + ex.getMessage());
        }
    }

    @Test
    public void getOperator(){
        when(restTemplate.exchange(any(), Mockito.eq(ApiResponseOperatorDTO.class))).thenReturn(createResponseEntityOperator());
        when(properties.getGetOperators()).thenReturn("/api/v3/operators");
        when(properties.getBaseUrl()).thenReturn("https://development.mgo.mioxxo-dev.io");
        when(tokenAccess.getToken()).thenReturn("5zYWN0aW9ucy5yZWFkIGFwaVwvYmlsbHBheW1lbnRzLmNyZWF0ZSBhcGlcL29wZXJhdG9ycy5yZWFkIGFwaVwvaW52b2ljZXMuY3JlYXRlIGFwaVwvdG9wdXBzLmNyZWF0ZSBjb25jaWxpYXRpb25cL3RvcHVwLmNyZWF0ZSBhcGlcL29yZGVycy5yZWFkIGFwaVwvcHJvdmlkZXJzLnJlYWQgY29uY2lsaWF0aW9uXC9wcm92aWRlcnMuY3JlYXRlIiwiYXV0aF9");

        ApiResponseOperatorDTO response = operatorsServiceAdapter.getOperator("5bb6683481c14c14ee2f531d");
        Assertions.assertNotNull(response);
    }

    @Test
    public void getOperatorError() {
        try {
            ApiResponseOperatorDTO response = operatorsServiceAdapter.getOperator("5bb6683481c14c14ee2f531d");
            Assertions.assertNotNull(response);
        }catch (Exception ex){
            assertEquals(ex.getMessage(), SERVICE_UNAVAILABLE_CODE.toString(),  "Error {} " + ex.getMessage());
        }
    }
}