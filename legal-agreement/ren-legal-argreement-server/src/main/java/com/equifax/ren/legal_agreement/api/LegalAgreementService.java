package com.equifax.ren.legal_agreement.api;

import com.equifax.ren.legal_agreement.domain.LegalAgreement;

import java.time.LocalDate;

public interface LegalAgreementService {
    LegalAgreement getLegalAgreement(String id);

    String createLegalAgreement(LegalAgreement legalAgreement);

    void updateLegalAgreement(String id, LegalAgreement legalAgreement);

    void deleteLegalAgreement(String id);

    void updateContent(String id, String content);

    String getContent(String id);

    LocalDate getExpirationDate(String id);

    void updateExpirationDate(String id, LocalDate newDate);

    boolean exists(String id);
}
