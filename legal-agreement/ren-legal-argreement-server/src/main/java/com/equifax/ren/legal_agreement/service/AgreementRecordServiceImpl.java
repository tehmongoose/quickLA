package com.equifax.ren.legal_agreement.service;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import com.equifax.ren.legal_agreement.exception.AgreementRecordNotFoundException;
import com.equifax.ren.legal_agreement.exception.LegalAgreementNotFoundException;
import com.equifax.ren.legal_agreement.repository.AgreementRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service
public class AgreementRecordServiceImpl implements AgreementRecordService {

    private final AgreementRecordRepository repository;

    @Autowired
    public AgreementRecordServiceImpl(AgreementRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public AgreementRecord getAgreementRecord(@NotBlank String id) {
        return repository.findById(id).orElseThrow(AgreementRecordNotFoundException::new);
    }

    @Override
    public String createAgreementRecord(@Valid AgreementRecord agreementRecord) {
        agreementRecord.setDeleted(false);
        @Valid AgreementRecord save = repository.save(agreementRecord);
        return save.getId();
    }

    @Override
    public void updateAgreementRecord(@NotBlank String id, @NotNull AgreementRecord agreementRecord) {
        agreementRecord.setId(id);
        repository.save(agreementRecord);
    }

    @Override
    public void deleteAgreementRecord(@NotBlank String id) {
        AgreementRecord agreementRecord = repository.findById(id)
                .orElseThrow(AgreementRecordNotFoundException::new);
        agreementRecord.setDeleted(true);
        repository.save(agreementRecord);
    }
}
