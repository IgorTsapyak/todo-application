package com.inventorsoft.todo.list.common.ExceptionHandler;

import lombok.Value;

import java.util.List;
import java.util.Map;

@Value
public class ApplicationExceptionResponse {

    private String message;

    private Map<String, List<String>> details;

}
