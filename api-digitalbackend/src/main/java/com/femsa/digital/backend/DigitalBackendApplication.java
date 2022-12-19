package com.femsa.digital.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

@SpringBootApplication
@PropertySources({
    @PropertySource("classpath:mioxxo.properties")
})
public class DigitalBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(DigitalBackendApplication.class, args);
	}

}
