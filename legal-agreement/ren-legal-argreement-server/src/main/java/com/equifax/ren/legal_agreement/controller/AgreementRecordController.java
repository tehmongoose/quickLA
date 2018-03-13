package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("1.0/agreementRecords")
public class AgreementRecordController {

    private final AgreementRecordService service;

    @Autowired
    public AgreementRecordController(AgreementRecordService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public AgreementRecord getAgreementRecord(@NotBlank
                                              @PathVariable("id") String id) {
        return service.getAgreementRecord(id);
    }

    @PostMapping
    public String createAgreementRecord(@Valid
                                        @RequestBody AgreementRecord agreementRecord) {
        return service.createAgreementRecord(agreementRecord);
    }

    @PutMapping("/{id}") //Maybe we shouldn't allow them to be updated?? maybe require a privilege?
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateAgreementRecord(@NotBlank
                                      @PathVariable("id") String id,
                                      @Valid
                                      @RequestBody AgreementRecord agreementRecord) {
        service.updateAgreementRecord(id, agreementRecord);
    }

    @DeleteMapping("/{id}") //Maybe we shouldn't allow them to be deleted?? maybe require a privilege?
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAgreementRecord(@NotBlank
                                      @PathVariable("id") String id) {
        service.deleteAgreementRecord(id);
    }
}
