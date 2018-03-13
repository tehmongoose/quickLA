package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("1.0/legalAgreement")
public class LegalAgreementController {

    private final LegalAgreementService service;

    @Autowired
    public LegalAgreementController(LegalAgreementService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public LegalAgreement getLegalAgreement(@NotBlank
                                            @RequestParam String id) {
        return service.getLegalAgreement(id);
    }

    @PostMapping
    public String createLegalAgreement(@NotNull
                                       @RequestBody LegalAgreement legalAgreement) {
        return service.createLegalAgreement(legalAgreement);
    }

    @PutMapping("/{id}")
    public void updateLegalAgreement(@NotBlank
                                     @RequestParam String id,
                                     @NotNull
                                     @RequestBody LegalAgreement legalAgreement) {
        service.updateLegalAgreement(id, legalAgreement);
    }

    @DeleteMapping("/{id}")
    public void deleteLegalAgreement(@NotBlank
                                     @RequestParam String id) {
        service.deleteLegalAgreement(id);
    }
}
