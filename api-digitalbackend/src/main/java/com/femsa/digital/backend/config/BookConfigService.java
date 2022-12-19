package com.femsa.digital.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.femsa.digital.backend.domain.ports.app.BookServiceAppPort;
import com.femsa.digital.backend.domain.ports.persistence.BookPersistencePort;
import com.femsa.digital.backend.domain.services.BookService;
import com.femsa.digital.backend.infra.bd.adapters.BookJpaAdapter2;



@Configuration
public class BookConfigService {

	@Bean
	public BookPersistencePort bookPersistence() {

		return new BookJpaAdapter2();
	}

	@Bean
	public BookServiceAppPort bookService() {
		return new BookService(bookPersistence());
	}
}
