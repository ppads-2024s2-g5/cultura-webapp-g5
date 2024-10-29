package com.example.demo.entities.livro;

import org.springframework.data.repository.CrudRepository;

public interface LivroRepo extends CrudRepository<Livro, Long> {
}