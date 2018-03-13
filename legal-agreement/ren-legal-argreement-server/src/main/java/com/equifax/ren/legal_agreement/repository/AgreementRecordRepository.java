package com.equifax.ren.legal_agreement.repository;

import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AgreementRecordRepository extends MongoRepository<AgreementRecord, String> {
}
