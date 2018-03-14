package com.equifax.ren.legal_agreement.repository;

import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AgreementRecordRepository extends MongoRepository<AgreementRecord, String> {
    boolean existsByIdAndDeletedIsFalse(String id);
    Optional<AgreementRecord> findOptionalByIdAndDeletedIsFalse(String id);
}
