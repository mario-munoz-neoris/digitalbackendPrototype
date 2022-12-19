package com.femsa.digital.backend.domain.services;

import java.util.List;

import com.femsa.digital.backend.domain.data.BookDTO;
import com.femsa.digital.backend.domain.ports.app.BookServiceAppPort;
import com.femsa.digital.backend.domain.ports.persistence.BookPersistencePort;

public class BookService implements BookServiceAppPort {

    private BookPersistencePort bookPersistencePort;

    public BookService(BookPersistencePort bookPersistencePort) {
        this.bookPersistencePort = bookPersistencePort;
    }

    @Override
    public BookDTO addBook(BookDTO bookDto) {
        return bookPersistencePort.addBook(bookDto);
    }

    @Override
    public void deleteBookById(Long id) {
        bookPersistencePort.deleteBookById(id);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDto) {
        return bookPersistencePort.updateBook(bookDto);
    }

    @Override
    public List<BookDTO> getBooks() {
        return bookPersistencePort.getBooks();
    }

    @Override
    public BookDTO getBookById(Long bookId) {
        return bookPersistencePort.getBookById(bookId);
    }
}
