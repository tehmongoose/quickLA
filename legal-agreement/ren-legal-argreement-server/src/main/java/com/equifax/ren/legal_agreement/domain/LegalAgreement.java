package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper = true)
public class LegalAgreement extends AuditableMongoObject {

    @JsonIgnore
    @Id
    String id;

    @NotBlank(message = "LegalAgreement's content field must not be blank")
    String content;

    @NotNull(message = "LegalAgreement's expirationDate field must not be null")
    LocalDate expirationDate;

    @JsonIgnore
    Boolean deleted;
}
