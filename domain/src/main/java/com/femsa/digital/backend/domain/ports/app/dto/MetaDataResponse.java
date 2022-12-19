package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by zenon.cruz on 19/12/2022
 * version 1.0
 */

import lombok.Data;

@Data
public class MetaDataResponse {

    private int page;
    private int per_page;
    private int total;
    private int total_pages;
}
