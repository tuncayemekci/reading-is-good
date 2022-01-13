package com.getir.readingisgood.controller;

import com.getir.readingisgood.entity.Book;
import com.getir.readingisgood.model.dto.BookDTO;
import com.getir.readingisgood.model.dto.BookStockDTO;
import com.getir.readingisgood.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/add")
    public ResponseEntity<?> addBook(@Valid @RequestBody BookDTO bookDTO) {
        return bookService.addBook(bookDTO);
    }

    @PutMapping("/updateStock")
    public ResponseEntity<?> updateBookStock(@Valid @RequestBody BookStockDTO bookStockDTO) {
        return bookService.updateBookStock(bookStockDTO);
    }
}
