package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.ResponseBookDTO;
import com.example.entity.Books;
import com.example.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
    
    @Autowired
    private BookService bookService;

    @PostMapping
    public Books CreateOne(@RequestBody Books books) {
        return bookService.create(books);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id) {
        bookService.remove(id);
    }

    @GetMapping
    public List<ResponseBookDTO> findAll(@RequestParam(value = "isDeleted", required = false, defaultValue = "false") boolean isDeleted) {
        List<ResponseBookDTO> resp = new ArrayList<>();
        Iterable<Books> bookList = bookService.findAll(isDeleted);
        for (Books books : bookList) {
            ResponseBookDTO data = new ResponseBookDTO<>();
            data.setTitle(books.getTitle());
            data.setPrice(books.getPrice());
            resp.add(data);
        }

        return resp;
    }
}
