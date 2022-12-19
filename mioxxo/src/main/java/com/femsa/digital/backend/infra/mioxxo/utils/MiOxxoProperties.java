package com.femsa.digital.backend.infra.mioxxo.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class MiOxxoProperties {

	@Value("${mioxxo.api.baseurl}")
	private String baseUrl;

	@Value("${mioxxo.api.username}")
	private String username;

	@Value("${mioxxo.api.psw}")
	private String psw;
	
	@Value("${mioxxo.api.gettoken.path}")
	private String getTokenPath;
	
	@Value("${mioxxo.api.getinvoices.path}")
	private String getInvoicesPath;

}
