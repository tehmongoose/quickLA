package com.equifax.ren.legal_agreement.service;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import com.equifax.ren.legal_agreement.exception.LegalAgreementNotFoundException;
import com.equifax.ren.legal_agreement.repository.LegalAgreementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Service
public class LegalAgreementServiceImpl implements LegalAgreementService {

    private final LegalAgreementRepository repository;

    @Autowired
    public LegalAgreementServiceImpl(LegalAgreementRepository repository) {
        this.repository = repository;
    }

    @Override
    public LegalAgreement getLegalAgreement(@NotBlank String id) {
        return repository.findById(id).orElseThrow(LegalAgreementNotFoundException::new);
    }

    @Override
    public String createLegalAgreement(@Valid LegalAgreement legalAgreement) {
        legalAgreement.setDeleted(false);
        LegalAgreement save = repository.save(legalAgreement);
        return save.getId();
    }

    @Override
    public void updateLegalAgreement(@NotBlank String id, @Valid LegalAgreement legalAgreement) {
        legalAgreement.setId(id);
        repository.save(legalAgreement);
    }

    @Override
    public void deleteLegalAgreement(@NotBlank String id) {
        LegalAgreement legalAgreement = repository.findById(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        legalAgreement.setDeleted(true);
        repository.save(legalAgreement);
    }

    @Override
    public void updateContent(@NotBlank String id, @NotBlank String content) {
        LegalAgreement legalAgreement = repository.findById(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        legalAgreement.setContent(content);
        repository.save(legalAgreement);
    }

    @Override
    public String getContent(@NotBlank String id) {
        LegalAgreement legalAgreement = repository.findById(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        return legalAgreement.getContent();
    }

    @Override
    public LocalDate getExpirationDate(@NotBlank String id) {
        LegalAgreement legalAgreement = repository.findById(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        return legalAgreement.getExpirationDate();
    }

    @Override
    public void updateExpirationDate(@NotBlank String id, @NotNull LocalDate newDate) {
        LegalAgreement legalAgreement = repository.findById(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        legalAgreement.setExpirationDate(newDate);
    }
}
