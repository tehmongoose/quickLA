package com.equifax.ren.legal_agreement.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@Data
public class ErrorInfo {
    private final long timestamp;
    private final String error;
    private final List<String> messages = new ArrayList<>();
    private final String path;

    public ErrorInfo(String path, String error, String message) {
        this.timestamp = System.currentTimeMillis();
        this.path = path;
        this.messages.add(message);
        this.error = error;
    }

    public ErrorInfo(String path, String error, Exception ex) {
        this(path, error, ex.getLocalizedMessage());
    }


    public ErrorInfo(String path, String error, List<String> messages) {
        this.timestamp = System.currentTimeMillis();
        this.path = path;
        this.messages.addAll(messages);
        this.error = error;
    }

}