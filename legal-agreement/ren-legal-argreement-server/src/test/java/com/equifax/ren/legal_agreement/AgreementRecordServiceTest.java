package com.equifax.ren.legal_agreement;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgreementRecordServiceTest {

    @Autowired
    AgreementRecordService service;

    @Test
    public void createLegalAgreement() {
        AgreementRecord ar = new AgreementRecord();
        ar.setCustomer("someRandomId");
        ar.setDateAccepted(LocalDate.now());

        String id = service.createAgreementRecord(ar);
        assertNotNull(id);

        AgreementRecord agreementRecord = service.getAgreementRecord(id);
        assertNotNull(agreementRecord);
        assertEquals(id, agreementRecord.getId());
        assertEquals(ar.getCustomer(), agreementRecord.getCustomer());
        assertEquals(ar.getDateAccepted(), agreementRecord.getDateAccepted());
    }
}
