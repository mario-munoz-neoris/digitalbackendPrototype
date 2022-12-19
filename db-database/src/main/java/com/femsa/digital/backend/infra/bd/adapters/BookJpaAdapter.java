package com.femsa.digital.backend.infra.bd.adapters;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.femsa.digital.backend.domain.data.BookDTO;
import com.femsa.digital.backend.domain.ports.persistence.BookPersistencePort;
import com.femsa.digital.backend.infra.bd.entities.Book;
import com.femsa.digital.backend.infra.bd.mappers.BookMapper;
import com.femsa.digital.backend.infra.bd.repositories.BookRepository;

@Service
public class BookJpaAdapter implements BookPersistencePort {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO addBook(BookDTO bookDto) {

        Book book = BookMapper.INSTANCE_DTO_O.map(bookDto);

        Book bookSaved = bookRepository.save(book);

        return BookMapper.INSTANCE_O_DTO.map(bookSaved);
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO updateBook(BookDTO bookDto) {
        return addBook(bookDto);
    }

    @Override
    public List<BookDTO> getBooks() {

        List<Book> bookList = bookRepository.findAll();
        
		List<BookDTO> bookDTOList = null;
		
		bookDTOList = bookList.stream().map(BookMapper.INSTANCE_O_DTO::map).collect(Collectors.toList());

        return bookDTOList;
    }

    @Override
    public BookDTO getBookById(Long bookId) {

        Optional<Book> book = bookRepository.findById(bookId);

        if (book.isPresent()) {
            return BookMapper.INSTANCE_O_DTO.map(book.get());
        }

        return null;
    }
}
