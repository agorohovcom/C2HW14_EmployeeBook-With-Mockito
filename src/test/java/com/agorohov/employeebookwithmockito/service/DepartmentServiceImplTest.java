package com.agorohov.employeebookwithmockito.service;

import com.agorohov.employeebookwithmockito.dto.Employee;
import com.agorohov.employeebookwithmockito.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static com.agorohov.employeebookwithmockito.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeServiceMock;

    @InjectMocks
    private DepartmentServiceImpl out;

    @BeforeEach
    public void setUp() {
        when(employeeServiceMock.findAllEmployees()).thenReturn(List.of(EMPLOYEE_3_ADDED, EMPLOYEE_4_ADDED, EMPLOYEE_5_ADDED));
    }

    @ParameterizedTest
    @ValueSource(ints = {DEPARTMENT_3_ADDED, DEPARTMENT_4_ADDED})
    void shouldGetSumMonthSalariesCorrectly(int department) {
        assertEquals(employeeServiceMock.findAllEmployees()
                        .stream()
                        .filter((e) -> e.getDepartment() == department)
                        .mapToInt(Employee::getSalary)
                        .reduce(Integer::sum)
                        .orElseThrow(),
                out.getSumMonthSalaries(department));
        assertThrows(EmployeeNotFoundException.class, () -> out.getSumMonthSalaries(DEPARTMENT_1));
    }

    @ParameterizedTest
    @ValueSource(ints = {DEPARTMENT_3_ADDED, DEPARTMENT_4_ADDED})
    void shouldGetEmployeeWithMinSalaryCorrectly(int departmentId) {
        assertEquals(employeeServiceMock.findAllEmployees()
                        .stream()
                        .filter((e) -> e.getDepartment() == departmentId)
                        .min(Comparator.comparingInt(Employee::getSalary))
                        .orElseThrow(),
                out.getEmployeeWithMinSalary(departmentId)
        );
        assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMinSalary(DEPARTMENT_1));
    }

    @Test
    @Disabled
    void getEmployeeWithMaxSalary() {
    }

    @Test
    @Disabled
    void getAverageMonthSalary() {
    }

    @Test
    @Disabled
    void findAllEmployees() {
    }

    @Test
    @Disabled
    void testFindAllEmployees() {
    }
}