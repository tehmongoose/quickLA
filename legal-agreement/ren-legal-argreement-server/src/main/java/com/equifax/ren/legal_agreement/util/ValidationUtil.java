package com.equifax.ren.legal_agreement.util;

import com.equifax.ren.legal_agreement.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Component
public class ValidationUtil {

    private final Validator validator;

    @Autowired
    public ValidationUtil(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object obj) throws ConstraintViolationException {
        Set<ConstraintViolation<Object>> violations = validator.validate(obj);
        if (!CollectionUtils.isEmpty(violations)) {
            //TODO: Finish putting the violations in message form. See exception in Customer-account
            throw new ConstraintViolationException(violations);
        }
    }
}
