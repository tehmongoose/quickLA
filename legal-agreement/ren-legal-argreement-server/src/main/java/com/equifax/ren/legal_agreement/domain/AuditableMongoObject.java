package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
public class AuditableMongoObject {

    @JsonIgnore
    @CreatedBy
    private String user;

    @JsonIgnore
    @CreatedDate
    private Instant createdDate;

    @JsonIgnore
    @LastModifiedBy
    private String lastModifiedUser;

    @JsonIgnore
    @LastModifiedDate
    private Instant lastModifiedDate;
}
