package com.equifax.ren.legal_agreement.api;

import com.equifax.ren.legal_agreement.domain.AgreementRecord;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface AgreementRecordService {
    AgreementRecord getAgreementRecord(@NotBlank String id);

    String createAgreementRecord(@NotNull AgreementRecord agreementRecord);

    void updateAgreementRecord(@NotBlank String id, @NotNull AgreementRecord agreementRecord);

    void deleteAgreementRecord(@NotBlank String id);
}
