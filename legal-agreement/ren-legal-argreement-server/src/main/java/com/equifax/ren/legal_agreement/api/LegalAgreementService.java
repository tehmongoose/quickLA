package com.equifax.ren.legal_agreement.api;

import com.equifax.ren.legal_agreement.domain.LegalAgreement;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface LegalAgreementService {
    LegalAgreement getLegalAgreement(@NotBlank String id);

    String createLegalAgreement(@NotNull LegalAgreement legalAgreement);

    void updateLegalAgreement(@NotBlank String id, @NotNull LegalAgreement legalAgreement);

    void deleteLegalAgreement(@NotBlank String id);
}
