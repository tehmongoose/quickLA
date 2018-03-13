package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@RestController
@RequestMapping("1.0/agreementRecord")
public class AgreementRecordController {

    private final AgreementRecordService service;

    @Autowired
    public AgreementRecordController(AgreementRecordService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public AgreementRecord getAgreementRecord(@NotBlank
                                              @RequestParam String id) {
        return service.getAgreementRecord(id);
    }

    @PostMapping
    public String createAgreementRecord(@NotNull
                                        @RequestBody AgreementRecord agreementRecord) {
        return service.createAgreementRecord(agreementRecord);
    }

    @PutMapping("/{id}")
    public void updateAgreementRecord(@NotBlank
                                      @RequestParam String id,
                                      @NotNull
                                      @RequestBody AgreementRecord agreementRecord) {
        service.updateAgreementRecord(id, agreementRecord);
    }

    @DeleteMapping("/{id}")
    public void deleteAgreementRecord(@NotBlank
                                      @RequestParam String id) {
        service.deleteAgreementRecord(id);
    }
}
