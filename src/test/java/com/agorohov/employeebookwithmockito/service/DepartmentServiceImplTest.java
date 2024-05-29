package com.agorohov.employeebookwithmockito.service;

import com.agorohov.employeebookwithmockito.dto.Employee;
import com.agorohov.employeebookwithmockito.exception.EmployeeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        assertThrows(EmployeeNotFoundException.class, () -> out.getSumMonthSalaries(DEPARTMENT_NOT_EXIST));
    }

    @ParameterizedTest
    @ValueSource(ints = {DEPARTMENT_3_ADDED, DEPARTMENT_4_ADDED})
    void shouldGetEmployeeWithMinSalaryCorrectly(int departmentId) {
        assertEquals(employeeServiceMock.findAllEmployees()
                        .stream()
                        .filter((e) -> e.getDepartment() == departmentId)
                        .min(Comparator.comparingInt(Employee::getSalary))
                        .orElseThrow(),
                out.getEmployeeWithMinSalary(departmentId));
        assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMinSalary(DEPARTMENT_NOT_EXIST));
    }

    @ParameterizedTest
    @ValueSource(ints = {DEPARTMENT_3_ADDED, DEPARTMENT_4_ADDED})
    void getEmployeeWithMaxSalary(int departmentId) {
        assertEquals(employeeServiceMock.findAllEmployees()
                        .stream()
                        .filter((e) -> e.getDepartment() == departmentId)
                        .max(Comparator.comparingInt(Employee::getSalary))
                        .orElseThrow(),
                out.getEmployeeWithMaxSalary(departmentId));
        assertThrows(EmployeeNotFoundException.class, () -> out.getEmployeeWithMaxSalary(DEPARTMENT_NOT_EXIST));
    }

    @ParameterizedTest
    @ValueSource(ints = {DEPARTMENT_3_ADDED, DEPARTMENT_4_ADDED})
    void shouldGetAverageMonthSalaryCorrectly(int departmentId) {
        assertEquals(employeeServiceMock.findAllEmployees()
                        .stream()
                        .filter((e) -> e.getDepartment() == departmentId)
                        .mapToInt(Employee::getSalary)
                        .average()
                        .orElseThrow(),
                out.getAverageMonthSalary(departmentId));
        assertThrows(EmployeeNotFoundException.class, () -> out.getAverageMonthSalary(DEPARTMENT_NOT_EXIST));
    }

    @ParameterizedTest
    @ValueSource(ints = {DEPARTMENT_3_ADDED, DEPARTMENT_4_ADDED})
    void shouldFindAllEmployeesCorrectly(int departmentId) {
        assertEquals(employeeServiceMock.findAllEmployees().stream()
                        .filter((e) -> e.getDepartment() == departmentId)
                        .collect(Collectors.toCollection(ArrayList::new)),
                out.findAllEmployees(departmentId));
        assertThrows(EmployeeNotFoundException.class, () -> out.findAllEmployees(DEPARTMENT_NOT_EXIST));
    }

    @Test
    void shouldFindAllEmployeesWithoutParameters() {
        assertEquals(employeeServiceMock.findAllEmployees().stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toList())),
                out.findAllEmployees());
    }
}