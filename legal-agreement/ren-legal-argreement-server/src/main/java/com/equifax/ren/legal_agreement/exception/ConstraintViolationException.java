package com.equifax.ren.legal_agreement.exception;

import lombok.Getter;

import javax.validation.ConstraintViolation;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
public class ConstraintViolationException extends IllegalArgumentException {

    private final List<String> messages = new ArrayList<>();

    public ConstraintViolationException(Set<ConstraintViolation<Object>> violations) {
        super(violationsToString(violations));
        violations.forEach(violation -> messages.add(violation.getMessage()));
    }

    private static String violationsToString(Set<ConstraintViolation<Object>> violations) {
        StringBuilder builder = new StringBuilder();

        violations.forEach(violation -> {
            if (builder.length() > 0) {
                builder.append(";   ");
            }

            builder.append(violation.getMessage());
        });

        return builder.toString();
    }
}
