package com.example.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Books;

public interface BookRepo extends CrudRepository<Books, Long> {}
