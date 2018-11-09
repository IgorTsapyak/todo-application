package com.inventorsoft.todo.list.common.ExceptionHandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Class which is responsible for application Exception handling and processing. As for example only one
 * type of the exception was handled - {@link MethodArgumentNotValidException}.
 */
@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String VALIDATION_ERROR = "Validation error";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {


        final BindingResult bindingResult = ex.getBindingResult();
        final Map<String, List<String>> errorsGrouped = bindingResult.getFieldErrors().stream()
                .collect(Collectors.groupingBy(FieldError::getField, Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())));
        return ResponseEntity.badRequest().body(new ApplicationExceptionResponse(VALIDATION_ERROR, errorsGrouped));
    }
}
