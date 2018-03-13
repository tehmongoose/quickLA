package com.equifax.ren.legal_agreement.repository;

import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LegalAgreementRepository extends MongoRepository<LegalAgreement, String> {
}
