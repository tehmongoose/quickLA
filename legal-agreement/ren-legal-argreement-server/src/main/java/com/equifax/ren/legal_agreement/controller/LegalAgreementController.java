package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

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
    public LegalAgreement getLegalAgreement(@PathVariable("id") String id) {
        checkId(id);
        return service.getLegalAgreement(id);
    }

    @PostMapping
    public String createLegalAgreement(@RequestBody LegalAgreement legalAgreement) {
        checkLegalAgreement(legalAgreement);
        return service.createLegalAgreement(legalAgreement);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateLegalAgreement(@PathVariable("id") String id,
                                     @RequestBody LegalAgreement legalAgreement) {
        checkId(id);
        checkLegalAgreement(legalAgreement);
        service.updateLegalAgreement(id, legalAgreement);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLegalAgreement(@PathVariable("id") String id) {
        checkId(id);
        service.deleteLegalAgreement(id);
    }

    @GetMapping("/{id}/content")
    public String getContent(@PathVariable("id") String id) {
        checkId(id);
        return service.getContent(id);
    }

    @PostMapping("/{id}/content")
    public void putContent(@PathVariable("id") String id, @RequestBody String content) {
        checkId(id);
        Assert.hasText(content, "Request body must contain text");
        service.updateContent(id, content);
    }

    @GetMapping("/{id}/expirationDate")
    public LocalDate getExpirationDate(@PathVariable("id") String id) {
        checkId(id);
        return service.getExpirationDate(id);
    }

    @PutMapping("/{id}/expirationDate")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateExpirationDate(@PathVariable("id") String id, LocalDate newDate) {
        checkId(id);
        Assert.notNull(newDate, "Request body must contain a non-null date. (YYYY-MM-DD)");
        service.updateExpirationDate(id, newDate);
    }

    private void checkId(String id) {
        Assert.hasText(id, "Legal Agreement 'id' path variable must not be null");
    }

    private void checkLegalAgreement(LegalAgreement legalAgreement) {
        Assert.notNull(legalAgreement, "Request body must contain a non-null Legal Agreement object");
    }
}
