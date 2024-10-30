package com.example.demo.entities.avaliacao;

import jakarta.persistence.*;
import java.time.Instant;
import com.example.demo.entities.geek.Geek;
import com.example.demo.entities.itemCultural.ItemCultural;
import lombok.Data;

@Entity
@Data
public class Avaliacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Instant createdAt = Instant.now();
    
    private int nota; 
    
    private String comentario;
    
    @ManyToOne(optional = false)
    @JoinColumn(name = "item_cultural_id", nullable = false)
    private ItemCultural itemCultural;

    @ManyToOne(optional = false)
    @JoinColumn(name = "geek_id", nullable = false)
    private Geek geek;
}
