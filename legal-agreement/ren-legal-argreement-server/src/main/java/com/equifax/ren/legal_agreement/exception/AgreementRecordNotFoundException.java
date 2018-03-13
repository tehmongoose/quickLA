package com.equifax.ren.legal_agreement.exception;

public class AgreementRecordNotFoundException extends RuntimeException {

    public AgreementRecordNotFoundException() {
        super("Agreement Record not found");
    }
}
