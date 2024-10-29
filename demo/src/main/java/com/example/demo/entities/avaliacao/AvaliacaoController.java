package com.example.demo.entities.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> buscarAvaliacaoPorId(@PathVariable Long id) {
        Optional<Avaliacao> avaliacaoOpt = avaliacaoRepository.findById(id);
        return avaliacaoOpt.map(ResponseEntity::ok)
                           .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        avaliacao.setCreatedAt(Instant.now());
        Avaliacao novaAvaliacao = avaliacaoRepository.save(avaliacao);
        URI uri = URI.create("/avaliacoes/" + novaAvaliacao.getId());
        return ResponseEntity.created(uri).body(novaAvaliacao);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacaoAtualizada) {
        return avaliacaoRepository.findById(id).map(avaliacao -> {
            avaliacao.setNota(avaliacaoAtualizada.getNota());
            avaliacao.setComentario(avaliacaoAtualizada.getComentario());
            avaliacao.setItemCultural(avaliacaoAtualizada.getItemCultural());
            avaliacao.setGeek(avaliacaoAtualizada.getGeek());
            Avaliacao avaliacaoSalva = avaliacaoRepository.save(avaliacao);
            return ResponseEntity.ok(avaliacaoSalva);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirAvaliacao(@PathVariable Long id) {
        if (avaliacaoRepository.existsById(id)) {
            avaliacaoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

