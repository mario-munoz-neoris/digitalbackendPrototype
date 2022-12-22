package com.femsa.digital.backend.infra.mioxxo.adapters;

import com.femsa.digital.backend.domain.exceptions.ConsultasExceptions;
import com.femsa.digital.backend.domain.ports.apis.GetOperatorsServicePort;
import com.femsa.digital.backend.domain.ports.app.dto.ApiResponseOperatorDTO;
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


    RestTemplate template = new RestTemplate();

    @Override
    public ApiResponseOperatorsDTO getOperators(String query, Integer page, Integer limit) {
        try{
            boolean firstParam = true;
            // Prepare Header to add authenticate service
            final HttpHeaders authHeaders = new HttpHeaders();
            authHeaders.setBearerAuth(tokenAccess.getToken());
            authHeaders.setContentType(MediaType.APPLICATION_JSON);

            // Prepare request to invoke service
            final HttpEntity<String> entity = new HttpEntity<>(authHeaders);

            StringBuilder strUrl = new StringBuilder(properties.getBaseUrl()).append(properties.getGetOperators());

            if(query != null ){
                firstParam = false;
                strUrl.append("?query=").append(query);
            }
            if(page != null){
                if(firstParam == true){
                    firstParam = false;
                    strUrl.append("?page=").append(page);
                }else{
                    strUrl.append("&page=").append(page);
                }
            }
            if(limit != null ){
                if(firstParam == true){
                    strUrl.append("?limit=").append(limit);
                }else{
                    strUrl.append("&limit=").append(limit);
                }
            }

            URI url = new URI(strUrl.toString());
            log.info("URL {}",url);
            RequestEntity<ApiResponseOperatorsDTO> request = new RequestEntity<>(
                    entity.getHeaders(), HttpMethod.GET, url);

            // Invoke service
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

    @Override
    public ApiResponseOperatorDTO getOperator(String id) {
        try{
            // Prepare Header to add authenticate service
            final HttpHeaders authHeaders = new HttpHeaders();
            authHeaders.setBearerAuth(tokenAccess.getToken());
            authHeaders.setContentType(MediaType.APPLICATION_JSON);

            StringBuilder strUrl = new StringBuilder(properties.getBaseUrl()).append(properties.getGetOperators());
            if(id != null && !id.isBlank()){
                strUrl.append("/").append(id);
            }
            URI url = new URI(strUrl.toString());

            RequestEntity<ApiResponseOperatorDTO> request = new RequestEntity<>(authHeaders, HttpMethod.GET, url);
            log.info("request {}", request);

            // Invoke service
            ResponseEntity<ApiResponseOperatorDTO> response = template.exchange(request, ApiResponseOperatorDTO.class);
            log.info("Response: {}", response.getBody() );
            if(response.getBody() != null){
                return response.getBody();
            }

        } catch (HttpClientErrorException httpEx){
            log.error("Error al consultar el servicio de Operator by id {} ", httpEx.getMessage());
            if(httpEx.getStatusCode().value() == 401){
                throw new ConsultasExceptions(UNAUTHORIZED_CODE.toString());
            }
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }catch (Exception ex){
            log.error("Error al consumir el servicio de Operator by id{}", ex.getMessage());
            throw new ConsultasExceptions(SERVICE_UNAVAILABLE_CODE.toString());
        }

        return null;
    }

}
