package com.femsa.digital.backend.infra.mioxxo.adapters;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.exceptions.ConsultasExceptions;
import com.femsa.digital.backend.domain.ports.apis.GetProvidersServicePort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseProvidersDTO;
import com.femsa.digital.backend.infra.mioxxo.services.TokenAccessService;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.UNAUTHORIZED_CODE;

@Slf4j
@Service
public class ProvidersServiceAdapter implements GetProvidersServicePort {

    @Autowired
    MiOxxoProperties properties;

    @Autowired
    TokenAccessService tokenAccess;

    @Override
    public ApiResponseProvidersDTO getProviders (String provider, long limit, long page) {
        try {

            String token = tokenAccess.getToken();

            final HttpHeaders authHeaders = new HttpHeaders();
            authHeaders.setBearerAuth(token);
            authHeaders.setContentType(MediaType.APPLICATION_JSON);

            final HttpEntity<String> entity = new HttpEntity<>(authHeaders);

            URI uri = new URI(properties.getBaseUrl() + properties.getGetProviders());

            URI uriParams = UriComponentsBuilder.fromUri(uri)
                    .queryParam("query", provider)
                    .queryParam("limit", String.valueOf(limit))
                    .queryParam("page", String.valueOf(page)).build().toUri();

            RequestEntity request = new RequestEntity<>(entity.getHeaders(), HttpMethod.GET, uriParams);

            RestTemplate template = new RestTemplate();
            ResponseEntity<ApiResponseProvidersDTO> response = template.exchange(request, ApiResponseProvidersDTO.class);

            log.info("Response {}", response);
            if (response.getBody() != null) {
                return response.getBody();
            }
        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de Providers {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de Providers {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }
        return null;
    }


    @Override
    public ApiResponseProvidersDTO getProviderById (String providerId) {
        try {

            String token = tokenAccess.getToken();

            final HttpHeaders authHeaders = new HttpHeaders();
            authHeaders.setBearerAuth(token);
            authHeaders.setContentType(MediaType.APPLICATION_JSON);

            final HttpEntity<String> entity = new HttpEntity<>(authHeaders);

            URI uri = new URI(properties.getBaseUrl()
                    + properties.getGetProviders()
                    + "/" + providerId);

            RequestEntity request = new RequestEntity<>(entity.getHeaders(), HttpMethod.GET, uri);

            RestTemplate template = new RestTemplate();
            ResponseEntity<ApiResponseProvidersDTO> response = template.exchange(request, ApiResponseProvidersDTO.class);

            log.info("Response {}", response);
            if (response.getBody() != null) {
                return response.getBody();
            }
        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de Providers {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de Providers {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }
        return null;
    }
}
