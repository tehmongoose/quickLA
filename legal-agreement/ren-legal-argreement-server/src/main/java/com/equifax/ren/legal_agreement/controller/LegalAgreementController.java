package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@RestController
@RequestMapping("1.0/legalAgreements")
public class LegalAgreementController {

    private final LegalAgreementService service;

    @Autowired
    public LegalAgreementController(LegalAgreementService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public LegalAgreement getLegalAgreement(@NotBlank
                                            @PathVariable("id") String id) {
        return service.getLegalAgreement(id);
    }

    @PostMapping
    public String createLegalAgreement(@NotNull
                                       @RequestBody LegalAgreement legalAgreement) {
        return service.createLegalAgreement(legalAgreement);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLegalAgreement(@NotBlank
                                     @PathVariable("id") String id,
                                     @NotNull
                                     @RequestBody LegalAgreement legalAgreement) {
        service.updateLegalAgreement(id, legalAgreement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLegalAgreement(@NotBlank
                                     @PathVariable("id") String id) {
        service.deleteLegalAgreement(id);
    }

    @GetMapping("/{id}/content")
    public String getContent(@NotBlank
                             @PathVariable("id") String id) {
        return service.getContent(id);
    }

    @PostMapping("/{id}/content")
    public void putContent(@NotBlank
                           @PathVariable("id") String id,
                           @NotNull
                           @RequestBody String content) {
        service.updateContent(id, content);
    }

    @GetMapping("/{id}/expirationDate")
    public LocalDate getExpirationDate(@NotBlank
                                       @PathVariable("id") String id) {
        return service.getExpirationDate(id);
    }

    @PutMapping("/{id}/expirationDate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExpirationDate(@NotBlank
                                     @PathVariable("id") String id,
                                     @NotNull LocalDate newDate) {
        service.updateExpirationDate(id, newDate);
    }
}
