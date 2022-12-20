package com.femsa.digital.backend.infra.mioxxo.adapters;

/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import com.femsa.digital.backend.domain.exceptions.ConsultasExceptions;
import com.femsa.digital.backend.domain.ports.apis.GetCategoriesServicePort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoriesDTO;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseCategoryByIdDTO;
import com.femsa.digital.backend.infra.mioxxo.services.TokenAccessService;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.UNAUTHORIZED_CODE;

@Slf4j
@Service
public class CategoriesServiceAdapter implements GetCategoriesServicePort {

    @Autowired
    MiOxxoProperties properties;

    @Autowired
    TokenAccessService tokenAccess;

    @Override
    public ApiResponseCategoryByIdDTO getCategoryById(String id) {
        try{

            // Invoke service
            RestTemplate template = new RestTemplate();
            ResponseEntity<ApiResponseCategoryByIdDTO> response = template.exchange(
                    this.getEntity(this.getHeader(), id), ApiResponseCategoryByIdDTO.class);

            if(response.getBody() != null){
                return response.getBody();
            }

        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de Categorias {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de Categorias {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }

        return null;
    }

    @Override
    public ApiResponseCategoriesDTO getCategories() {
        try{

            // Invoke service
            RestTemplate template = new RestTemplate();
            ResponseEntity<ApiResponseCategoriesDTO> response = template.exchange(
                    this.getEntity(this.getHeader(), ""), ApiResponseCategoriesDTO.class);

            if(response.getBody() != null){
                return response.getBody();
            }

        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de Categorias {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de Categorias {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }

        return null;
    }

    private HttpHeaders getHeader(){
        // Prepare Header to add authenticate service
        final HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.setBearerAuth(tokenAccess.getToken());
        authHeaders.setContentType(MediaType.APPLICATION_JSON);

        return authHeaders;
    }

    private RequestEntity<ApiResponseCategoriesDTO> getEntity(
            HttpHeaders authHeaders, String id) throws URISyntaxException {

        StringBuilder strUrl = new StringBuilder(properties.getBaseUrl())
                .append(properties.getGetCategories());

        if(id != null && !id.isBlank()){
            strUrl.append("/").append(id);
        }

        URI url = new URI(strUrl.toString());
        return new RequestEntity<>(
                authHeaders, HttpMethod.GET, url);
    }

}
