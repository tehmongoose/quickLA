package com.equifax.ren.legal_agreement;

import com.equifax.ren.legal_agreement.api.AgreementRecordService;
import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AgreementRecordServiceTest {

    @Autowired
    AgreementRecordService service;

    @MockBean
    LegalAgreementService mockLegalAgreementService;

    @Test
    public void createLegalAgreement() {
        when(mockLegalAgreementService.exists(anyString())).thenReturn(true);

        AgreementRecord ar = new AgreementRecord();
        ar.setCustomerKey("someRandomId");
        ar.setDateAccepted(LocalDate.now());
        ar.setLegalAgreementKey("someKey");

        String id = service.createAgreementRecord(ar);
        assertNotNull(id);

        AgreementRecord agreementRecord = service.getAgreementRecord(id);
        assertNotNull(agreementRecord);
        assertEquals(id, agreementRecord.getId());
        assertEquals(ar.getCustomerKey(), agreementRecord.getCustomerKey());
        assertEquals(ar.getDateAccepted(), agreementRecord.getDateAccepted());
    }
}
