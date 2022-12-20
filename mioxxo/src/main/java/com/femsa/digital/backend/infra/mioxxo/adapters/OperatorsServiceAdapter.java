package com.femsa.digital.backend.infra.mioxxo.adapters;

import com.femsa.digital.backend.domain.exceptions.ConsultasExceptions;
import com.femsa.digital.backend.domain.ports.apis.GetOperatorsServicePort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorsDTO;
import com.femsa.digital.backend.infra.mioxxo.services.TokenAccessService;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.UNAUTHORIZED_CODE;

@Slf4j
@Service
public class OperatorsServiceAdapter implements GetOperatorsServicePort {
    @Autowired
    MiOxxoProperties properties;

    @Autowired
    TokenAccessService tokenAccess;


    @Override
    public ApiResponseOperatorsDTO getOperators() {
        try{
            // Prepare Header to add authenticate service
            final HttpHeaders authHeaders = new HttpHeaders();
            authHeaders.setBearerAuth(tokenAccess.getToken());
            authHeaders.setContentType(MediaType.APPLICATION_JSON);

            // Prepare request to invoke service
            final HttpEntity<String> entity = new HttpEntity<>(authHeaders);
            URI url = new URI(properties.getBaseUrl() + properties.getGetOperators());
            RequestEntity<ApiResponseOperatorsDTO> request = new RequestEntity<>(
                    entity.getHeaders(), HttpMethod.GET, url);

            // Invoke service
            RestTemplate template = new RestTemplate();
            ResponseEntity<ApiResponseOperatorsDTO> response = template.exchange(
                    request, ApiResponseOperatorsDTO.class);

            log.info("Response: {}", response.getBody() );
            if(response.getBody() != null){
                return response.getBody();
            }

        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de Operators {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de Operators {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }

        return null;
    }
}
