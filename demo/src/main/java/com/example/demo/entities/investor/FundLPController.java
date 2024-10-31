package com.example.demo.entities.investor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fund-lps")
public class FundLPController {

    private final FundLPRepository fundLPRepository;

    @Autowired
    public FundLPController(FundLPRepository fundLPRepository) {
        this.fundLPRepository = fundLPRepository;
    }

    @GetMapping
    public List<FundLP> getAllFundLPs() {
        return fundLPRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FundLP> getFundLPById(@PathVariable Long id) {
        Optional<FundLP> fundLP = fundLPRepository.findById(id);
        return fundLP.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public FundLP createFundLP(@RequestBody FundLP fundLP) {
        fundLP.setCreatedAt(Instant.now());
        fundLP.setUpdatedAt(Instant.now());
        return fundLPRepository.save(fundLP);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FundLP> updateFundLP(@PathVariable Long id, @RequestBody FundLP fundLPDetails) {
        Optional<FundLP> fundLPOptional = fundLPRepository.findById(id);

        if (fundLPOptional.isPresent()) {
            FundLP fundLP = fundLPOptional.get();
            fundLP.setName(fundLPDetails.getName());
            fundLP.setLpType(fundLPDetails.getLpType());
            fundLP.setUpdatedAt(Instant.now());
            FundLP updatedFundLP = fundLPRepository.save(fundLP);
            return ResponseEntity.ok(updatedFundLP);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFundLP(@PathVariable Long id) {
        if (fundLPRepository.existsById(id)) {
            fundLPRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
