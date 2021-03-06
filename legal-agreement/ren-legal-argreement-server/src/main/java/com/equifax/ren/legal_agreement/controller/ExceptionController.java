package com.equifax.ren.legal_agreement.controller;

import com.equifax.ren.legal_agreement.domain.AgreementRecord;
import com.equifax.ren.legal_agreement.domain.ErrorInfo;
import com.equifax.ren.legal_agreement.exception.AgreementRecordNotFoundException;
import com.equifax.ren.legal_agreement.exception.ConstraintViolationException;
import com.equifax.ren.legal_agreement.exception.LegalAgreementNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionController {
    private final static Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public @ResponseBody
    ErrorInfo handleGenericError(HttpServletRequest req, Exception ex) {
        LOGGER.error(ex.getMessage(), ex);
        return new ErrorInfo(req.getRequestURL().toString(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class, IllegalArgumentException.class})
    public @ResponseBody
    ErrorInfo handleBadRequest(HttpServletRequest req, Exception ex) {
        LOGGER.debug(ex.getMessage(), ex);
        return new ErrorInfo(req.getRequestURL().toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({ConstraintViolationException.class})
    public @ResponseBody
    ErrorInfo handleBadRequest(HttpServletRequest req, ConstraintViolationException ex) {
        LOGGER.debug(ex.getMessage(), ex);
        return new ErrorInfo(req.getRequestURL().toString(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getMessages());
    }


    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({LegalAgreementNotFoundException.class, AgreementRecordNotFoundException.class})
    public @ResponseBody
    ErrorInfo handleNotFound(HttpServletRequest req, Exception ex) {
        LOGGER.debug(ex.getMessage(), ex);
        return new ErrorInfo(req.getRequestURL().toString(), HttpStatus.NOT_FOUND.getReasonPhrase(), ex);
    }

}
