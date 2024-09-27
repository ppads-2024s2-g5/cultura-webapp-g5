package com.example.demo.Esportes;

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
class EsporteController {

    @Autowired
    private EsporteRepo esporteRepo;

    public EsporteController() {

    }

    @GetMapping("/api/esportes")
    Iterable<Esporte> getEsportes(@RequestParam Optional<Long> faculdadeId) {
        return esporteRepo.findAll();
    }

    @GetMapping("/api/esportes/{id}")
    Optional<Esporte> getEsporte(@PathVariable long id) {
        return esporteRepo.findById(id);
    }

    @PostMapping("/api/esportes")
    Esporte createEsporte(@RequestBody Esporte e) {
        Esporte createdEs = esporteRepo.save(e);
        return createdEs;
    }

    @PutMapping("/api/esportes/{esporteId}")
    Optional<Esporte> updateEsporte(@RequestBody Esporte esporteRequest, @PathVariable long esporteId) {
        Optional<Esporte> opt = esporteRepo.findById(esporteId);
        if (opt.isPresent()) {
            if (esporteRequest.getId() == esporteId) {
                esporteRepo.save(esporteRequest);
                return opt;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Erro ao alterar dados do esporte com id " + esporteId);
    }

    @DeleteMapping(value = "/api/esportes/{id}")
    void deleteEsporte(@PathVariable long id) {
        esporteRepo.deleteById(id);
    }
}
