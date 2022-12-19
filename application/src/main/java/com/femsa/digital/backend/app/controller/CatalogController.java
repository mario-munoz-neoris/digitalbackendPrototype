package com.femsa.digital.backend.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.femsa.digital.backend.domain.ports.app.FiscalRegimenServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseInvoiceDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CatalogController {

    @Autowired
    FiscalRegimenServiceAppPort fiscalRegimenServicePort;
    
    @GetMapping(value = "/getClientes", produces = "application/json")
    public ResponseEntity<ApiResponseInvoiceDTO> getClientes(){

        log.info("Ingresando a la consulta de clientes...");

        ApiResponseInvoiceDTO response = fiscalRegimenServicePort.getFiscalRegimen() ;      
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
