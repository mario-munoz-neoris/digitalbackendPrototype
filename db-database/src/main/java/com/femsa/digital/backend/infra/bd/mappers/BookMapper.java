package com.femsa.digital.backend.infra.bd.mappers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;

import com.femsa.digital.backend.domain.data.BookDTO;
import com.femsa.digital.backend.infra.bd.entities.Book;

public interface BookMapper {

    TypeMap<Book, BookDTO> INSTANCE_O_DTO = new ModelMapper().createTypeMap(Book.class, BookDTO.class);

    TypeMap<BookDTO, Book> INSTANCE_DTO_O = new ModelMapper().createTypeMap(BookDTO.class, Book.class);
    
    BookDTO bookToBookDto(Book book);

    Book bookDtoToBook(BookDTO bookDto);

    List<BookDTO> bookListToBookDtoList(List<Book> bookList);

    List<Book> BookDtoListToBookList(List<BookDTO> BookDtoList);
}
