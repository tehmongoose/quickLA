package com.equifax.ren.legal_agreement.service;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Service
public class LegalAgreementServiceImpl implements LegalAgreementService {
    @Override
    public LegalAgreement getLegalAgreement(@NotBlank String id) {
        return null;
    }

    @Override
    public String createLegalAgreement(@NotNull LegalAgreement legalAgreement) {
        return null;
    }

    @Override
    public void updateLegalAgreement(@NotBlank String id, @NotNull LegalAgreement legalAgreement) {

    }

    @Override
    public void deleteLegalAgreement(@NotBlank String id) {

    }
}
