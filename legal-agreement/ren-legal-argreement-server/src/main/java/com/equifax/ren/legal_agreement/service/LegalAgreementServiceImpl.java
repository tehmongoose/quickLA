package com.equifax.ren.legal_agreement.service;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import com.equifax.ren.legal_agreement.exception.LegalAgreementNotFoundException;
import com.equifax.ren.legal_agreement.repository.LegalAgreementRepository;
import com.equifax.ren.legal_agreement.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.LocalDate;

@Service
public class LegalAgreementServiceImpl implements LegalAgreementService {

    private final LegalAgreementRepository repository;
    private final ValidationUtil validator;

    @Autowired
    public LegalAgreementServiceImpl(LegalAgreementRepository repository, ValidationUtil validator) {
        this.repository = repository;
        this.validator = validator;
    }

    @Override
    public LegalAgreement getLegalAgreement(String id) {
        validateId(id);
        return repository.findOptionalByIdAndDeletedIsFalse(id).orElseThrow(LegalAgreementNotFoundException::new);
    }

    @Override
    public String createLegalAgreement(LegalAgreement legalAgreement) {
        validator.validate(legalAgreement);
        legalAgreement.setDeleted(false);
        LegalAgreement save = repository.save(legalAgreement);
        return save.getId();
    }

    @Override
    public void updateLegalAgreement(String id, LegalAgreement legalAgreement) {
        validateId(id);
        validator.validate(legalAgreement);

        legalAgreement.setId(id);
        repository.save(legalAgreement);
    }

    @Override
    public void deleteLegalAgreement(String id) {
        validateId(id);

        LegalAgreement legalAgreement = repository.findOptionalByIdAndDeletedIsFalse(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        legalAgreement.setDeleted(true);
        repository.save(legalAgreement);
    }

    @Override
    public void updateContent(String id, String content) {
        validateId(id);
        Assert.hasText(content, "Legal Agreement's Content must not be blank");
        LegalAgreement legalAgreement = repository.findOptionalByIdAndDeletedIsFalse(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        legalAgreement.setContent(content);
        repository.save(legalAgreement);
    }

    @Override
    public String getContent(String id) {
        validateId(id);
        LegalAgreement legalAgreement = repository.findOptionalByIdAndDeletedIsFalse(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        return legalAgreement.getContent();
    }

    @Override
    public LocalDate getExpirationDate(String id) {
        validateId(id);
        LegalAgreement legalAgreement = repository.findOptionalByIdAndDeletedIsFalse(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        return legalAgreement.getExpirationDate();
    }

    @Override
    public void updateExpirationDate(String id, LocalDate newDate) {
        validateId(id);
        Assert.notNull(newDate, "New expiration date can not be null");
        LegalAgreement legalAgreement = repository.findOptionalByIdAndDeletedIsFalse(id)
                .orElseThrow(LegalAgreementNotFoundException::new);
        legalAgreement.setExpirationDate(newDate);
    }

    @Override
    public boolean exists(String id) {
        return repository.existsByIdAndDeletedIsFalse(id);
    }

    private void validateId(String id) {
        Assert.hasText(id, "Legal Agreement id must not be blank");
    }
}
