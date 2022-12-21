package com.femsa.digital.backend.app.controller;

import com.femsa.digital.backend.domain.ports.app.OperatorsServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
public class OperatorsController {
    @Autowired
    OperatorsServiceAppPort operatorServiceAppPort;

    @GetMapping(value = "/operators", produces = "application/json")
    public ResponseEntity<ApiResponseOperatorsDTO> getOperators(@RequestParam(required = false) String query, @RequestParam(required = false) Integer page, @RequestParam(required = false) Integer limit){
        log.info("Inicia Get operators...");
        return new ResponseEntity<>(operatorServiceAppPort.getOperators(query, page, limit), HttpStatus.OK);
    }

    @GetMapping(value = "/operator/{id}", produces = "application/json")
    public ResponseEntity<ApiResponseOperatorDTO> getOperator(@PathVariable String id){
        log.info("Inicia Get operator...id {}",id);
        return new ResponseEntity<>(operatorServiceAppPort.getOperator(id), HttpStatus.OK);
    }
}
