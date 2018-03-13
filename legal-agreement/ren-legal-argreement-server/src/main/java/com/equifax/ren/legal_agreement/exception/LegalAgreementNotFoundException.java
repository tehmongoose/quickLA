package com.equifax.ren.legal_agreement.exception;

public class LegalAgreementNotFoundException extends RuntimeException {

    public LegalAgreementNotFoundException() {
        super("Legal Agreement not found");
    }
}
