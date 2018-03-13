package com.equifax.ren.legal_agreement.service;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service
public class AgreementRecordServiceImpl implements AgreementRecordService {
    @Override
    public AgreementRecord getAgreementRecord(@NotBlank String id) {
        return null;
    }

    @Override
    public String createAgreementRecord(@NotNull AgreementRecord agreementRecord) {
        return null;
    }

    @Override
    public void updateAgreementRecord(@NotBlank String id, @NotNull AgreementRecord agreementRecord) {

    }

    @Override
    public void deleteAgreementRecord(@NotBlank String id) {

    }
}
