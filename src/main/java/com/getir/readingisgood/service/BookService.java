package com.getir.readingisgood.service;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.dto.BookDTO;
import com.getir.readingisgood.model.dto.BookStockDTO;
import com.getir.readingisgood.repository.BookRepository;
import com.getir.readingisgood.util.BookUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public ResponseEntity<?> addBook(BookDTO bookDTO) {
        if (bookRepository.existsByName(bookDTO.getName())) {
            return new ResponseEntity<>("The book already exists with name: " + bookDTO.getName(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        Book book = BookUtil.dtoToBook(bookDTO);
        bookRepository.save(book);
        return new ResponseEntity<>("The book has been added successfully with name: " + bookDTO.getName(), new HttpHeaders(), HttpStatus.CREATED);
    }

    @Transactional
    public ResponseEntity<?> updateBookStock(BookStockDTO bookStockDTO) {
        Optional<Book> optionalBook = bookRepository.findBookByName(bookStockDTO.getName());

        if (!optionalBook.isPresent()) {
            return new ResponseEntity<>("The book that you try to update doesn't exist with name: " + bookStockDTO.getName(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        Book book = optionalBook.get();
        Integer newQuantity = book.getStock() + bookStockDTO.getQuantity();

        if (newQuantity < 0) {
            return new ResponseEntity<>("The Book's stock can not be less than zero when you try to update: " + bookStockDTO.getName(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
        }

        book.setStock(newQuantity);
        bookRepository.save(book);
        return new ResponseEntity<>("The book has been updated successfully with name: " + bookStockDTO.getName(), new HttpHeaders(), HttpStatus.OK);
    }
}
