package com.getir.readingisgood.util;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.dto.BookDTO;

public class BookUtil {

    public static Book dtoToBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setName(bookDTO.getName());
        book.setAuthor(bookDTO.getAuthor());
        book.setPrice(bookDTO.getPrice());
        book.setStock(bookDTO.getStock());
        return book;
    }

}
