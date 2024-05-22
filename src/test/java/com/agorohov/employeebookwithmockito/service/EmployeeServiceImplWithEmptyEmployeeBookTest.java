package com.agorohov.employeebookwithmockito.service;

import com.agorohov.employeebookwithmockito.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceImplWithEmptyEmployeeBookTest {

    private final EmployeeService out;

    public EmployeeServiceImplWithEmptyEmployeeBookTest() {
        out = new EmployeeServiceImpl();
    }

    @Test()
    public void shouldThrowEmployeeNotFoundExceptionWhenItsNoEmployees() {
        assertThrows(EmployeeNotFoundException.class,
                out::findAllEmployees);
    }
}