package com.femsa.digital.backend.app.controller;

import com.femsa.digital.backend.domain.ports.app.OperatorsServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static com.femsa.digital.backend.app.utils.UtilsTest.createResponseOperatorDTO;
import static com.femsa.digital.backend.app.utils.UtilsTest.createResponseOperatorsDTO;
import static org.mockito.Mockito.when;

class OperatorsControllerTest {

    @InjectMocks
    private OperatorsController operatorsController;

    @Mock
    OperatorsServiceAppPort operatorServiceAppPort;

    @BeforeEach
    public void inicializaMocks() {
        MockitoAnnotations.initMocks(this);
    }

    String operator = "5bb6683481c14c14ee2f531d";

    @Test
    public void getOperators(){
        when(operatorServiceAppPort.getOperators("",1,1)).thenReturn(createResponseOperatorsDTO());
        ResponseEntity<ApiResponseOperatorsDTO> response = operatorsController.getOperators("",1,1);
        Assertions.assertNotNull(response);
    }

    @Test
    public void getOperator(){
        when(operatorServiceAppPort.getOperator(operator)).thenReturn(createResponseOperatorDTO());
        ResponseEntity<ApiResponseOperatorDTO> response = operatorsController.getOperator(operator);
        Assertions.assertNotNull(response);
    }
}