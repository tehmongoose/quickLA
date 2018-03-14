package com.equifax.ren.legal_agreement.api;

import com.equifax.ren.legal_agreement.domain.AgreementRecord;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface AgreementRecordService {
    AgreementRecord getAgreementRecord(String id);

    String createAgreementRecord(AgreementRecord agreementRecord);

    void updateAgreementRecord(String id, AgreementRecord agreementRecord);

    void deleteAgreementRecord( String id);
}
