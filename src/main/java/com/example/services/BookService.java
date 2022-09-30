package com.example.services;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Books;
import com.example.repos.BookRepo;

@Service
public class BookService {

    @Autowired
    private EntityManager entityManager;
    
    @Autowired
    private BookRepo bookRepo;

    public Books create(Books books) {
        return bookRepo.save(books);
    }

    public void remove(Long id) {
        bookRepo.deleteById(id);
    }

    public Iterable<Books> findAll(boolean isDeleted) {
        // return bookRepo.findAll();
        Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedBookFilter");
        filter.setParameter("isDeleted", isDeleted);
        Iterable<Books> books = bookRepo.findAll();
        session.disableFilter("deletedBookFilter");
        return books;
    }
}
