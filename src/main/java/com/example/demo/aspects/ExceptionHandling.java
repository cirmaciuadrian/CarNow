package com.example.demo.aspects;
import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.Exceptions;
import com.example.demo.repository.ExceptionsRepository;
import com.example.demo.utils.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ExceptionHandling {

    @Autowired
    private ExceptionsRepository exceptionsRepository;

    @ExceptionHandler({MethodArgumentNotValidException.class})
    public ResponseEntity<Object> productContentValidation(MethodArgumentNotValidException exception){
        Map<String,Object> body = new HashMap<>();
        List<ObjectError> errors = exception.getAllErrors();
        List<ErrorResponse> bodyResponse = errors.stream()
                .map(err -> new ErrorResponse(err.getDefaultMessage()))
                .collect(Collectors.toList());
        body.put("timestamp", LocalDate.now());
        body.put("errors",bodyResponse);
        for(int i=0; i< bodyResponse.size();i++){
            Exceptions exceptionBd = new Exceptions();
            exceptionBd.date= LocalDate.now().toString();
            exceptionBd.message=bodyResponse.get(i).getMessage();
            exceptionsRepository.addException(exceptionBd);
        }
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<Object> invalidInput(NotFoundException exception){
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        Exceptions exceptionBd = new Exceptions();
        exceptionBd.date= LocalDate.now().toString();
        exceptionBd.message=exception.getMessage();
        exceptionsRepository.addException(exceptionBd);
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<Object> invalidInput(BadRequestException exception){
        Map<String,Object> body = new HashMap<>();
        body.put("timestamp", LocalDate.now());
        body.put("errors", exception.getMessage());
        Exceptions exceptionBd = new Exceptions();
        exceptionBd.date= LocalDate.now().toString();
        exceptionBd.message=exception.getMessage();
        exceptionsRepository.addException(exceptionBd);
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }


}