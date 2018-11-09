package com.inventorsoft.todo.list.common.ExceptionHandler;

import lombok.Value;

import java.util.List;
import java.util.Map;

/**
 * Simple POJO which contains the data which is related to the exceptions of the application. This wrapper used
 * to decrease amount of the data which is provided from different exceptions and make it readable and understandable.
 */
@Value
public class ApplicationExceptionResponse {

    private String message;

    private Map<String, List<String>> details;

}
