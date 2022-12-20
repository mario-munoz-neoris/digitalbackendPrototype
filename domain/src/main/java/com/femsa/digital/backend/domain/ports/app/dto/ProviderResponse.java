package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import lombok.Data;
import java.util.List;

@Data
public class ProviderResponse {

    private String id;
    private String name;
    private String company;
    private String image;
    private String type;
    private String operation;
    private String legends;
    private boolean scannable;
    private boolean prepaId;
    private List<CategoriesResponse> categories;
    private List<InputProviderResponse> inputs;


}
