package com.femsa.digital.backend.infra.mioxxo.services;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.femsa.digital.backend.domain.exceptions.ConsultasExceptions;
import com.femsa.digital.backend.infra.mioxxo.dto.ResponseToken;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.*;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TokenAccessService {

    @Autowired
    MiOxxoProperties properties;

    @Value("$(cron_token_time)")
    static final int timeDelay = 1680000; // 28 minutos activo
    
    private String token;

    public String getToken(){
        if(token == null){
            token = this.generateAccessToken();
        }

        return token;
    }

    @Scheduled(fixedDelay = timeDelay)
    public void getTokenRecurrent(){
        token = this.generateAccessToken();
    }

    public String generateAccessToken(){

        // Prepare Header to add authenticate service
        final HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.setBasicAuth(properties.getUsername(), properties.getPsw());
        authHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        String body = String.format("grant_type=%s", "client_credentials");

        try {
            // Prepare request to invoke service
            RestTemplate template = new RestTemplate();
            final HttpEntity<String> entity = new HttpEntity<>(body, authHeaders);
            URI url = new URI(properties.getGetTokenPath());

            // Invoke service
            ResponseToken response = template.postForObject(url, entity, ResponseToken.class);

            if(response == null){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }
            log.info("Response token success.");
            return response.getAccess_token();
        } catch (HttpClientErrorException httpEx){
            httpEx.printStackTrace();
            log.error("Error al consultar el servicio de token {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            ex.printStackTrace();
            log.error("Error al consumir el servicio de token {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }
    }
}
