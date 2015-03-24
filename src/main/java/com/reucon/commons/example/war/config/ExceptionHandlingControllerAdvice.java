package com.reucon.commons.example.war.config;

import com.reucon.commons.web.exception.ExceptionReportGenerator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlingControllerAdvice
{
    @Autowired
    private ExceptionReportGenerator exceptionReportGenerator;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception exception, HttpServletRequest request, HttpServletResponse response)
    {
        final String exceptionId = exceptionReportGenerator.writeExceptionReport(exception, request);
        return new ResponseEntity<>("Exception occured " + exceptionId, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
