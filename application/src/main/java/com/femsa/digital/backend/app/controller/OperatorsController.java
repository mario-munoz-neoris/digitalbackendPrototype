package com.femsa.digital.backend.app.controller;

import com.femsa.digital.backend.domain.ports.app.OperatorServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class OperatorsController {
    @Autowired
    OperatorServiceAppPort operatorServiceAppPort;

    @GetMapping(value = "/operators", produces = "application/json")
    public ResponseEntity<ApiResponseOperatorsDTO> getOperators(){
        log.info("Inicia Get operators...");
        return new ResponseEntity<>(operatorServiceAppPort.getOperators(), HttpStatus.OK);
    }
}
