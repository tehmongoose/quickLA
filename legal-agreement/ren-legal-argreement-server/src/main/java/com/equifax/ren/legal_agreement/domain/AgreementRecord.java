package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class AgreementRecord {

    @JsonIgnore
    @Id
    String id;

    String customer;
    boolean isAccepted;
    LocalDate dateAccepted;
}
