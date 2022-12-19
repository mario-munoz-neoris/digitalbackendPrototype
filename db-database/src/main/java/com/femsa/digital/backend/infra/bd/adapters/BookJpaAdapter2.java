package com.femsa.digital.backend.infra.bd.adapters;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.femsa.digital.backend.domain.data.BookDTO;
import com.femsa.digital.backend.domain.ports.persistence.BookPersistencePort;
import com.femsa.digital.backend.infra.bd.entities.Book;
import com.femsa.digital.backend.infra.bd.mappers.BookMapper;
import com.femsa.digital.backend.infra.bd.repositories.BookRepository;

@Service
public class BookJpaAdapter2 implements BookPersistencePort {

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

    	List<BookDTO> bookList = new ArrayList<>();
        Book book = new Book();
        book.setId(456L);
        book.setTitle("Title 2");
		bookList.add(BookMapper.INSTANCE_O_DTO.map(book) );
		
        return bookList;
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
