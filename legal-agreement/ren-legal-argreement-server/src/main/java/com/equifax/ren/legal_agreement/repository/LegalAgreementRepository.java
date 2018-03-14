package com.equifax.ren.legal_agreement.repository;

import com.equifax.ren.legal_agreement.domain.LegalAgreement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LegalAgreementRepository extends MongoRepository<LegalAgreement, String> {
    boolean existsByIdAndDeletedIsFalse(String id);
    Optional<LegalAgreement> findOptionalByIdAndDeletedIsFalse(String id);
}
