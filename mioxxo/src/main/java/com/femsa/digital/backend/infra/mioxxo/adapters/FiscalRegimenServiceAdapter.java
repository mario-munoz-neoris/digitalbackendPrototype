package com.femsa.digital.backend.infra.mioxxo.adapters;

import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.SERVICE_UNAVAILABLE_CODE;
import static com.femsa.digital.backend.domain.exceptions.ErrorCodes.UNAUTHORIZED_CODE;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.femsa.digital.backend.domain.exceptions.ConsultasExceptions;
import com.femsa.digital.backend.domain.ports.apis.GetRegimenFiscalPort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseInvoiceDTO;
import com.femsa.digital.backend.infra.mioxxo.services.TokenAccessService;
import com.femsa.digital.backend.infra.mioxxo.utils.MiOxxoProperties;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class FiscalRegimenServiceAdapter implements GetRegimenFiscalPort {

	@Autowired
    MiOxxoProperties properties;
	
	@Autowired
	TokenAccessService tokenAccess;
	
    @Override
    public ApiResponseInvoiceDTO getFiscalRegimen() {


        try {

            String token = tokenAccess.getToken();

            log.info("Toke_access: " + token);
            // Prepare Header to add authenticate service
            final HttpHeaders authHeaders = new HttpHeaders();
            authHeaders.setBearerAuth(tokenAccess.getToken());
            authHeaders.setContentType(MediaType.APPLICATION_JSON);

            // Prepare request to invoke service
            final HttpEntity<String> entity = new HttpEntity<>(authHeaders);
            URI url = new URI(properties.getBaseUrl() + properties.getGetInvoicesPath());
            RequestEntity<ApiResponseInvoiceDTO> request = new RequestEntity<>(entity.getHeaders(), HttpMethod.GET, url);

            // Invoke service
            RestTemplate template = new RestTemplate();
            ResponseEntity<ApiResponseInvoiceDTO> response = template.exchange(request, ApiResponseInvoiceDTO.class);

            log.info("Response: {}", response );
            if(response != null && response.getBody() != null){
                return response.getBody();
            }

        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de clientes {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }

            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de clientes {}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }

        return null;
    }
}
