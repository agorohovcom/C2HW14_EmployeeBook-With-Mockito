package com.agorohov.employeebookwithmockito.exception.handler;

import com.agorohov.employeebookwithmockito.exception.EmployeeAlreadyAddedException;
import com.agorohov.employeebookwithmockito.exception.EmployeeNotFoundException;
import com.agorohov.employeebookwithmockito.exception.UnsupportedNameException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EmployeeBookExceptionHandler {

    // Перехват указанных исключений с целью вывода в браузер сообщений из исключений
    // Перекрывает @ResponseStatus
    @ExceptionHandler({
            EmployeeAlreadyAddedException.class,
            EmployeeNotFoundException.class,
            UnsupportedNameException.class
    })
    public String handleEmployeeExceptions(RuntimeException e) {
        e.printStackTrace();
        return e.getMessage();
    }
}
