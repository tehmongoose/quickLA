package com.equifax.ren.legal_agreement;

import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RenLegalAgreementServerApplicationTests {

    @Autowired
    ObjectMapper mapper;

	@Test
	public void contextLoads() throws JsonProcessingException {
		LegalAgreement la = new LegalAgreement();
		la.setExpirationDate(LocalDate.now());
		la.setContent("this is content");
		la.setDeleted(false);

        AgreementRecord ar = new AgreementRecord();
        ar.setCustomerKey("someRandomId");
        ar.setDateAccepted(LocalDate.now());


        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(la));
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ar));
	}

}
