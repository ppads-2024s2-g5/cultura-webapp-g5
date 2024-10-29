package com.example.demo.entities.avaliacao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.Instant;

import com.example.demo.entities.geek.Geek;
import com.example.demo.entities.itemCultural.ItemCultural;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant createdAt;
    private int nota;
    private String comentario;  
    @ManyToOne(optional=false)
    private ItemCultural itemCultural;
    @ManyToOne(optional=false)
    private Geek geek;
}
