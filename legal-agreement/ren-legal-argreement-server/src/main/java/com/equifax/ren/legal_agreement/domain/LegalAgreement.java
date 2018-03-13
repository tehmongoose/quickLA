package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.Id;
import java.time.LocalDate;

@Data
public class LegalAgreement {

    @JsonIgnore
    @Id
    String id;

    String content;
    LocalDate created;
    LocalDate validThrough;
    boolean isDeleted;
}
