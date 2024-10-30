package com.example.demo.entities.avaliacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @GetMapping
    public List<Avaliacao> listarAvaliacoes() {
        return avaliacaoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Avaliacao> criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        Avaliacao novaAvaliacao = avaliacaoRepository.save(avaliacao);
        return ResponseEntity.ok(novaAvaliacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Avaliacao> obterAvaliacaoPorId(@PathVariable Long id) {
        return avaliacaoRepository.findById(id)
                .map(avaliacao -> ResponseEntity.ok().body(avaliacao))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Avaliacao> atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao avaliacaoAtualizada) {
        return avaliacaoRepository.findById(id)
                .map(avaliacao -> {
                    avaliacao.setNota(avaliacaoAtualizada.getNota());
                    avaliacao.setComentario(avaliacaoAtualizada.getComentario());
                    avaliacao.setItemCultural(avaliacaoAtualizada.getItemCultural());
                    avaliacao.setGeek(avaliacaoAtualizada.getGeek());
                    Avaliacao updatedAvaliacao = avaliacaoRepository.save(avaliacao);
                    return ResponseEntity.ok().body(updatedAvaliacao);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarAvaliacao(@PathVariable Long id) {
        return avaliacaoRepository.findById(id)
                .map(avaliacao -> {
                    avaliacaoRepository.delete(avaliacao);
                    return ResponseEntity.ok().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
