package com.equifax.ren.legal_agreement;

import com.equifax.ren.legal_agreement.api.LegalAgreementService;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class LegalAgreementServiceTest {

    @Autowired
    LegalAgreementService service;

    @Test
    public void createLegalAgreement() {
        LegalAgreement la = new LegalAgreement();
        la.setExpirationDate(LocalDate.now());
        la.setContent("this is content");

        String id = service.createLegalAgreement(la);
        assertNotNull(id);

        LegalAgreement legalAgreement = service.getLegalAgreement(id);
        assertNotNull(legalAgreement);
        assertEquals(id, legalAgreement.getId());
        assertEquals(la.getContent(), legalAgreement.getContent());
    }
}
