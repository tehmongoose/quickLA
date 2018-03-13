package com.equifax.ren.legal_agreement.api;

import com.equifax.ren.legal_agreement.domain.LegalAgreement;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public interface LegalAgreementService {
    LegalAgreement getLegalAgreement(@NotBlank String id);

    String createLegalAgreement(@NotNull LegalAgreement legalAgreement);

    void updateLegalAgreement(@NotBlank String id, @NotNull LegalAgreement legalAgreement);

    void deleteLegalAgreement(@NotBlank String id);

    void updateContent(@NotBlank String id, @NotNull String content);

    String getContent(@NotBlank String id);

    LocalDate getExpirationDate(@NotBlank String id);

    void updateExpirationDate(@NotBlank String id, @NotNull LocalDate newDate);
}
