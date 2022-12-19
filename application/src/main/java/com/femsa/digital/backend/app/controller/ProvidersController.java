package com.femsa.digital.backend.app.controller;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.ports.app.ProvidersServiceAppPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseProvidersDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/providers")
public class ProvidersController {

    @Autowired
    ProvidersServiceAppPort providersServiceAppPort;

    @GetMapping(produces = "application/json")
    public ResponseEntity<ApiResponseProvidersDTO> getProviders(@RequestParam String provider,
                                                                @RequestParam int limit,
                                                                @RequestParam int page) {
        log.info("Get providers");
        return ResponseEntity.ok(providersServiceAppPort.getProviders(provider, limit, page));
    }

    @GetMapping(value = "/{providerId}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<ApiResponseProvidersDTO> getPorviderById(@PathVariable("providerId") String providerId){
        log.info("Get provider by Id");
        return ResponseEntity.ok(providersServiceAppPort.getProviderById(providerId));

    }

}
