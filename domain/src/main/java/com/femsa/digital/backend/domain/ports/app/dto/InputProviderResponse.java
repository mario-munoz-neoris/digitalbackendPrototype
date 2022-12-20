package com.femsa.digital.backend.domain.ports.app.dto;
/*
 * Created by edwin.perez on 19/12/2022
 * version 1.0
 */

import lombok.Data;

@Data
public class InputProviderResponse {

    private String reference_type;
    private String field;
    private String fieldMessage;
    private String helpImage;
    private boolean editable;
    private boolean confirmation;
    private boolean alphanumeric;

}
