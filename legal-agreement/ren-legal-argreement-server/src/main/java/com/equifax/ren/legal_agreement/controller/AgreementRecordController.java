package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("1.0/agreementRecords")
public class AgreementRecordController {

    private final AgreementRecordService service;

    @Autowired
    public AgreementRecordController(AgreementRecordService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public AgreementRecord getAgreementRecord(@PathVariable("id") String id) {
        checkId(id);
        return service.getAgreementRecord(id);
    }

    @PostMapping
    public String createAgreementRecord(@RequestBody AgreementRecord agreementRecord) {
        checkAgreementRecord(agreementRecord);
        return service.createAgreementRecord(agreementRecord);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAgreementRecord(@PathVariable("id") String id,
                                      @RequestBody AgreementRecord agreementRecord) {
        checkId(id);
        checkAgreementRecord(agreementRecord);
        service.updateAgreementRecord(id, agreementRecord);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAgreementRecord(@PathVariable("id") String id) {
        checkId(id);
        service.deleteAgreementRecord(id);
    }

    private void checkId(String id) {
        Assert.hasText(id, "The Agreement Record 'id' path variable must not be null");
    }

    private void checkAgreementRecord(AgreementRecord agreementRecord) {
        Assert.notNull(agreementRecord, "Request body must contain a non-null Agreement Record object");
    }
}
