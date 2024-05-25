package com.agorohov.employeebookwithmockito.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeService employeeServiceMock;

    @InjectMocks
    private DepartmentService out;

    @Test
    void getSumMonthSalaries() {
    }

    @Test
    void getEmployeeWithMinSalary() {
    }

    @Test
    void getEmployeeWithMaxSalary() {
    }

    @Test
    void getAverageMonthSalary() {
    }

    @Test
    void findAllEmployees() {
    }

    @Test
    void testFindAllEmployees() {
    }
}