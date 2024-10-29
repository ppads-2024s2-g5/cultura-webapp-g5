package com.example.demo.entities.geek;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.Instant;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Geek {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Instant createdAt;
    private String email;
    private String dataNascimento;
}
