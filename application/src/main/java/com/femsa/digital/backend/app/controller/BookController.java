package com.femsa.digital.backend.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.femsa.digital.backend.domain.data.BookDTO;
import com.femsa.digital.backend.domain.ports.app.BookServiceAppPort;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private BookServiceAppPort bookServicePort;

	@PostMapping("/add")
	public BookDTO addBook(@RequestBody BookDTO bookDto) {
		return bookServicePort.addBook(bookDto);
	}

	@PutMapping("/update")
	public BookDTO updateBook(@RequestBody BookDTO bookDto) {
		return bookServicePort.updateBook(bookDto);
	}

	@GetMapping("/get/{id}")
	public BookDTO getBookByID(@PathVariable long id) {
		return bookServicePort.getBookById(id);
	}

	@GetMapping("/get")
	public List<BookDTO> getAllBooks() {
		log.debug("getAllBooks");
		return bookServicePort.getBooks();
	}

	@DeleteMapping("/delete/{id}")
	public void deleteBookByID(@PathVariable long id) {
		bookServicePort.deleteBookById(id);
	}

}
