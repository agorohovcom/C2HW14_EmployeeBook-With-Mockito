package com.agorohov.employeebookwithmockito.constants;

import com.agorohov.employeebookwithmockito.dto.Employee;

public class Constants {
    public static final String FIRST_NAME_1 = "Евгений";
    public static final String FIRST_NAME_2 = "Михаил";
    public static final String FIRST_NAME_3_ADDED = "Сюзанна";
    public static final String FIRST_NAME_4_ADDED = "Мишель";

    public static final String LAST_NAME_1 = "Захаров";
    public static final String LAST_NAME_2 = "Орлов";
    public static final String LAST_NAME_3_ADDED = "Шмыг";
    public static final String LAST_NAME_4_ADDED = "Джонсон";

    public static final String UNSUPPORTED_FIRST_NAME = "Сюз4анна";
    public static final String UNSUPPORTED_LAST_NAME = "Шмы г";
    public static final String UNFORMATTED_NAME_1 = "еВгенИй";
    public static final String UNFORMATTED_FIRST_NAME_3_ADDED = "сюЗаннА";

    public static final int SALARY_1 = 55000;
    public static final int SALARY_2 = 67000;
    public static final int SALARY_3_ADDED = 33003;
    public static final int SALARY_4_ADDED = 42003;

    public static final int DEPARTMENT_1 = 1;
    public static final int DEPARTMENT_2 = 2;
    public static final int DEPARTMENT_3_ADDED = 3;
    public static final int DEPARTMENT_4_ADDED = 2;

    public static final Employee EMPLOYEE_1 = new Employee(FIRST_NAME_1, LAST_NAME_1, SALARY_1, DEPARTMENT_1);
    public static final Employee EMPLOYEE_2 = new Employee(FIRST_NAME_2, LAST_NAME_2, SALARY_2, DEPARTMENT_2);
    public static final Employee EMPLOYEE_3_ADDED = new Employee(FIRST_NAME_3_ADDED, LAST_NAME_3_ADDED, SALARY_3_ADDED, DEPARTMENT_3_ADDED);
    public static final Employee EMPLOYEE_4_ADDED = new Employee(FIRST_NAME_4_ADDED, LAST_NAME_4_ADDED, SALARY_4_ADDED, DEPARTMENT_4_ADDED);

    public static final Employee EMPLOYEE_WITH_MAX_SALARY = EMPLOYEE_2;
    public static final Employee EMPLOYEE_WITH_MIN_SALARY = EMPLOYEE_3_ADDED;
}
