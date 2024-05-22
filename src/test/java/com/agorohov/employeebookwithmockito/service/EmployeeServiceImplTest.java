package com.agorohov.employeebookwithmockito.service;

import com.agorohov.employeebookwithmockito.exception.EmployeeAlreadyAddedException;
import com.agorohov.employeebookwithmockito.exception.UnsupportedNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.agorohov.employeebookwithmockito.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeServiceImplTest {

    private final EmployeeService out;

    EmployeeServiceImplTest() {
        out = new EmployeeServiceImpl();
    }

    @BeforeEach
    public void setUp() {
        out.addEmployee(FIRST_NAME_3, LAST_NAME_3, SALARY_3, DEPARTMENT_3);
    }

    @Test
    void findAllEmployees() {
    }

    @Test
    void shouldAddEmployeeCorrectly() {
        assertEquals(EMPLOYEE_1, out.addEmployee(UNFORMATTED_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(FIRST_NAME_3, LAST_NAME_3, SALARY_3, DEPARTMENT_3));
        assertThrows(UnsupportedNameException.class,
                () -> out.addEmployee(UNSUPPORTED_FIRST_NAME, LAST_NAME_1, SALARY_1, DEPARTMENT_1));
        assertThrows(UnsupportedNameException.class,
                () -> out.addEmployee(FIRST_NAME_1, UNSUPPORTED_LAST_NAME, SALARY_1, DEPARTMENT_1));
    }

    @Test
    void removeEmployee() {
    }

    @Test
    void findEmployee() {

    }
}