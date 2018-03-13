package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class AgreementRecord extends AuditableMongoObject {

    @JsonIgnore
    @Id
    String id;

    @NotBlank
    String customer;

    @PastOrPresent
    @NotNull
    LocalDate dateAccepted;

    @JsonIgnore
    Boolean deleted;
}
