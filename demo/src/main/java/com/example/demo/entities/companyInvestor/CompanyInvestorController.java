package com.example.demo.entities.companyInvestor;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.investor.InvestorRepository;

@RestController
class CompanyInvestorController {

    @Autowired
    private InvestorRepository investorRepo;

    public CompanyInvestorController() {
    }

    @GetMapping("/api/company-investors")
    List<CompanyInvestor> getCompanyInvestors(
            @RequestParam Optional<String> namePart) {
        if (namePart.isPresent()) {
            return investorRepo.findCompanyInvestorsByNamePart(namePart.get());
        }
        return investorRepo.findAll()
                .stream()
                .filter(investor -> investor instanceof CompanyInvestor)
                .map(investor -> (CompanyInvestor) investor)
                .toList();
    }

    @GetMapping("/api/company-investors/{id}")
    CompanyInvestor getCompanyInvestor(@PathVariable long id) {
        return investorRepo.findById(id)
                .filter(investor -> investor instanceof CompanyInvestor)
                .map(investor -> (CompanyInvestor) investor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor da empresa não encontrado com id " + id));
    }

    @PostMapping("/api/company-investors")
    CompanyInvestor createCompanyInvestor(@RequestBody CompanyInvestor companyInvestor) {
        companyInvestor.setCreatedAt(Instant.now());
        return investorRepo.save(companyInvestor);
    }

    @PutMapping("/api/company-investors/{companyInvestorId}")
    CompanyInvestor updateCompanyInvestor(@RequestBody CompanyInvestor companyInvestorRequest, @PathVariable long companyInvestorId) {
        return investorRepo.findById(companyInvestorId)
                .filter(investor -> investor instanceof CompanyInvestor)
                .map(investor -> {
                    if (!companyInvestorRequest.getId().equals(companyInvestorId)) {
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "O ID no corpo da solicitação deve corresponder ao ID do caminho");
                    }
                    companyInvestorRequest.setUpdatedAt(Instant.now());
                    return investorRepo.save(companyInvestorRequest);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor da empresa não encontrado com id " + companyInvestorId));
    }

    @DeleteMapping("/api/company-investors/{id}")
    void deleteCompanyInvestor(@PathVariable long id) {
        CompanyInvestor companyInvestor = investorRepo.findById(id)
                .filter(investor -> investor instanceof CompanyInvestor)
                .map(investor -> (CompanyInvestor) investor)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Investidor da empresa não encontrado com id " + id));
        investorRepo.delete(companyInvestor);
    }
}
