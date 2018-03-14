package com.equifax.ren.legal_agreement.exception;

import javax.validation.ConstraintViolation;
import java.util.Set;

public class ConstraintViolationException extends IllegalArgumentException {


    public ConstraintViolationException(Set<ConstraintViolation<Object>> violations) {
        super(violationsToString(violations));
    }

    private static String violationsToString(Set<ConstraintViolation<Object>> violations) {
        StringBuilder builder = new StringBuilder();

        violations.forEach(violation -> {
            if (builder.length() > 0) {
                builder.append("\n");
            }

            builder.append(violation.getMessage());
        });

        return builder.toString();
    }
}
