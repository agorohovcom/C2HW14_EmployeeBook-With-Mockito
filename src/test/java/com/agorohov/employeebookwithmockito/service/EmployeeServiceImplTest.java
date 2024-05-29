package com.agorohov.employeebookwithmockito.service;

import com.agorohov.employeebookwithmockito.exception.EmployeeAlreadyAddedException;
import com.agorohov.employeebookwithmockito.exception.EmployeeNotFoundException;
import com.agorohov.employeebookwithmockito.exception.UnsupportedNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static com.agorohov.employeebookwithmockito.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private final EmployeeService out;

    EmployeeServiceImplTest() {
        out = new EmployeeServiceImpl();
    }

    @BeforeEach
    public void setUp() {
        out.addEmployee(FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED, SALARY_3_ADDED, DEPARTMENT_3_ADDED);
        out.addEmployee(FIRST_NAME_4_ADDED, LAST_NAME_4_ADDED, SALARY_4_ADDED, DEPARTMENT_4_ADDED);
        out.addEmployee(FIRST_NAME_5_ADDED, LAST_NAME_5_ADDED, SALARY_5_ADDED, DEPARTMENT_4_ADDED);
    }

    @Test
    public void shouldFindAllEmployeesCorrectly() {
        assertNotNull(out.findAllEmployees());
        assertIterableEquals(List.of(EMPLOYEE_3_ADDED, EMPLOYEE_4_ADDED, EMPLOYEE_5_ADDED), out.findAllEmployees());

        out.removeEmployee(FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED);
        out.removeEmployee(FIRST_NAME_4_ADDED, LAST_NAME_4_ADDED);
        out.removeEmployee(FIRST_NAME_5_ADDED, LAST_NAME_5_ADDED);

        assertThrows(EmployeeNotFoundException.class,
                out::findAllEmployees);
    }

    @Test
    public void shouldAddEmployeeCorrectly() {
        assertEquals(EMPLOYEE_1, out.addEmployee(UNFORMATTED_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1));
        assertThrows(EmployeeAlreadyAddedException.class,
                () -> out.addEmployee(FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED, SALARY_3_ADDED, DEPARTMENT_3_ADDED));
        assertThrows(UnsupportedNameException.class,
                () -> out.addEmployee(UNSUPPORTED_FIRST_NAME, LAST_NAME_1, SALARY_1, DEPARTMENT_1));
        assertThrows(UnsupportedNameException.class,
                () -> out.addEmployee(FIRST_NAME_1, UNSUPPORTED_LAST_NAME, SALARY_1, DEPARTMENT_1));
    }

    @Test
    public void shouldRemoveEmployeeCorrectly() {
        assertEquals(EMPLOYEE_3_ADDED, out.removeEmployee(UNFORMATTED_FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED));
        assertThrows(EmployeeNotFoundException.class,
                () -> out.removeEmployee(FIRST_NAME_1, LAST_NAME_1));
    }

    @Test
    public void shouldFindEmployeeCorrectly() {
        assertEquals(EMPLOYEE_3_ADDED, out.findEmployee(FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED));
        assertEquals(EMPLOYEE_3_ADDED, out.findEmployee(UNFORMATTED_FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED));
        assertThrows(EmployeeNotFoundException.class,
                () -> out.findEmployee(FIRST_NAME_1, LAST_NAME_1));
    }
}