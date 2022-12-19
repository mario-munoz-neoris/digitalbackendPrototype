package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import lombok.Data;
import java.util.List;

@Data
public class ApiResponseProvidersDTO {

    private String status;
    private List<ProviderResponse> providers;
    private ProviderResponse provider;
    private MetaDataResponse metaData;
}
