package com.example.demo.jogoTabuleiro;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
class JogoTabuleiroController {

    @Autowired
    private JogoTabuleiroRepo jogoTabuleiroRepo;

    public JogoTabuleiroController() {

    }

    @GetMapping("/api/jogos_tabuleiro")
    Iterable<JogoTabuleiro> getJogosTabuleiro(@RequestParam Optional<Long> faculdadeId) {
        return jogoTabuleiroRepo.findAll();
    }

    @GetMapping("/api/jogos_tabuleiro/{id}")
    Optional<JogoTabuleiro> getJogoTabuleiro(@PathVariable long id) {
        return jogoTabuleiroRepo.findById(id);
    }

    @PostMapping("/api/jogos_tabuleiro")
    JogoTabuleiro createJogoTabuleiro(@RequestBody JogoTabuleiro jogo) {
        JogoTabuleiro createdJogo = jogoTabuleiroRepo.save(jogo);
        return createdJogo;
    }

    @PutMapping("/api/jogos_tabuleiro/{jogoId}")
    Optional<JogoTabuleiro> updateJogoTabuleiro(@RequestBody JogoTabuleiro jogoRequest, @PathVariable long jogoId) {
        Optional<JogoTabuleiro> opt = jogoTabuleiroRepo.findById(jogoId);
        if (opt.isPresent()) {
            if (jogoRequest.getId() == jogoId) {
                jogoTabuleiroRepo.save(jogoRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do jogo de tabuleiro com id " + jogoId);
    }

    @DeleteMapping(value = "/api/jogos_tabuleiro/{id}")
    void deleteJogoTabuleiro(@PathVariable long id) {
        jogoTabuleiroRepo.deleteById(id);
    }
}
