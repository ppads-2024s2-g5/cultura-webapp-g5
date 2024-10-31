package com.example.demo.entities.investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lenders")
public class LenderController {

    private final LenderRepository lenderRepository;

    @Autowired
    public LenderController(LenderRepository lenderRepository) {
        this.lenderRepository = lenderRepository;
    }

    @GetMapping
    public List<Lender> getAllLenders() {
        return lenderRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lender> getLenderById(@PathVariable Long id) {
        Optional<Lender> lender = lenderRepository.findById(id);
        return lender.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Lender createLender(@RequestBody Lender lender) {
        return lenderRepository.save(lender);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lender> updateLender(@PathVariable Long id, @RequestBody Lender lenderDetails) {
        Optional<Lender> lenderOptional = lenderRepository.findById(id);
        
        if (lenderOptional.isPresent()) {
            Lender lender = lenderOptional.get();
            lender.setName(lenderDetails.getName());
            lender.setLenderType(lenderDetails.getLenderType());
            Lender updatedLender = lenderRepository.save(lender);
            return ResponseEntity.ok(updatedLender);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLender(@PathVariable Long id) {
        if (lenderRepository.existsById(id)) {
            lenderRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

