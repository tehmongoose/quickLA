package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

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

    @NotBlank(message = "AgreementRecord's customerKey field must not be blank")
    String customerKey;

    @NotBlank(message = "AgreementRecord's legalAgreementKey field must not be blank")
    String legalAgreementKey;

    @PastOrPresent
    @NotNull(message = "AgreementRecord's dateAccepted field must not be null")
    LocalDate dateAccepted;

    @JsonIgnore
    Boolean deleted;
}
