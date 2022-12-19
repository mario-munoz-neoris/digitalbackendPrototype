package com.femsa.digital.backend.domain.ports.app;

import java.util.List;

import com.femsa.digital.backend.domain.data.BookDTO;

public interface BookServiceAppPort {

    BookDTO addBook(BookDTO bookDto);

    void deleteBookById(Long id);

    BookDTO updateBook(BookDTO bookDto);

    List<BookDTO> getBooks();

    BookDTO getBookById(Long bookId);
}
