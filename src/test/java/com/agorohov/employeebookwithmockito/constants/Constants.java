package com.agorohov.employeebookwithmockito.constants;

import com.agorohov.employeebookwithmockito.dto.Employee;

public class Constants {
    public static final String FIRST_NAME_1 = "Евгений";
    public static final String FIRST_NAME_2 = "Михаил";
    public static final String FIRST_NAME_ADDED = "Сюзанна";

    public static final String LAST_NAME_1 = "Захаров";
    public static final String LAST_NAME_2 = "Орлов";
    public static final String LAST_NAME_ADDED = "Шмыг";

    public static final String UNSUPPORTED_FIRST_NAME = "Сюз4анна";
    public static final String UNSUPPORTED_LAST_NAME = "Шмы г";
    public static final String UNFORMATTED_NAME_1 = "еВгенИй";
    public static final String UNFORMATTED_FIRST_NAME_ADDED = "сюЗаннА";

    public static final int SALARY_1 = 55000;
    public static final int SALARY_2 = 67000;
    public static final int SALARY_3 = 33003;

    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_2 = 2;
    public static final int DEPARTMENT_3 = 3;

    public static final Employee EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1);
    public static final Employee EMPLOYEE_2 = new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2);
    public static final Employee EMPLOYEE_ADDED = new Employee(FIRST_NAME_ADDED, LAST_NAME_ADDED, SALARY_3, DEPARTMENT_3);

    public static final Employee EMPLOYEE_WITH_MAX_SALARY = EMPLOYEE_2;
    public static final Employee EMPLOYEE_WITH_MIN_SALARY = EMPLOYEE_ADDED;
}
