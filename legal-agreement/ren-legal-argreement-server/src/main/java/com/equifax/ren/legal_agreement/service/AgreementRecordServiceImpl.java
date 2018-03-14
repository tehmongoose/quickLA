package com.equifax.ren.legal_agreement.service;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import com.equifax.ren.legal_agreement.exception.AgreementRecordNotFoundException;
import com.equifax.ren.legal_agreement.exception.LegalAgreementNotFoundException;
import com.equifax.ren.legal_agreement.repository.AgreementRecordRepository;
import com.equifax.ren.legal_agreement.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.validation.Valid;

@Service
public class AgreementRecordServiceImpl implements AgreementRecordService {

    private final AgreementRecordRepository repository;
    private final LegalAgreementService legalAgreementService;
    private final ValidationUtil validator;

    @Autowired
    public AgreementRecordServiceImpl(AgreementRecordRepository repository, LegalAgreementService legalAgreementService, ValidationUtil validator) {
        this.repository = repository;
        this.legalAgreementService = legalAgreementService;
        this.validator = validator;
    }

    @Override
    public AgreementRecord getAgreementRecord(String id) {
        validateId(id);
        return repository.findById(id).orElseThrow(AgreementRecordNotFoundException::new);
    }

    @Override
    public String createAgreementRecord(AgreementRecord agreementRecord) {
        validator.validate(agreementRecord);
        if (!legalAgreementService.exists(agreementRecord.getLegalAgreementKey())) {
            throw new LegalAgreementNotFoundException();
        }

        agreementRecord.setDeleted(false);
        @Valid AgreementRecord save = repository.save(agreementRecord);
        return save.getId();
    }

    @Override
    public void updateAgreementRecord(String id, AgreementRecord agreementRecord) {
        validateId(id);
        validator.validate(agreementRecord);

        agreementRecord.setDeleted(false);
        agreementRecord.setId(id);

        repository.save(agreementRecord);
    }

    @Override
    public void deleteAgreementRecord(String id) {
        validateId(id);
        AgreementRecord agreementRecord = repository.findById(id).orElseThrow(AgreementRecordNotFoundException::new);
        agreementRecord.setDeleted(true);
        repository.save(agreementRecord);
    }

    private void validateId(String id) {
        Assert.hasText(id, "Agreement Record id must not be blank");
    }
}
