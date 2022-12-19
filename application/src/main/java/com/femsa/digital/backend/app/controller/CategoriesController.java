package com.femsa.digital.backend.app.controller;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.app.CategoriesServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class CategoriesController {
    @Autowired
    CategoriesServiceAppPort categoriesServiceAppPort;

    @GetMapping(value = "/categories", produces = "application/json")
    public ResponseEntity<ApiResponseCategoriesDTO> getCategories(){

        log.info("Get categories...");
        return new ResponseEntity<>(categoriesServiceAppPort.getCategories(), HttpStatus.OK);
    }
}
