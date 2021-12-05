package com.example.workingcondition.company;

import java.util.ArrayList;
import java.util.List;

public class Department {

    private int idDepartment;
    private String name;
    private boolean isSynchronizeTime;
    private boolean isCannotChangeTimestamp;
    private int departmentWorkingStart = Company.getSTART_WORKING();
    private int departmentWorkingEnd = Company.getEND_WORKING();
    List<Employee> employeeList = new ArrayList<>();

    public Department(String name, boolean isSynchronizeTime, boolean isCannotChangeTimestamp) {
        this.name = name;
        this.isSynchronizeTime = isSynchronizeTime;
        this.isCannotChangeTimestamp = isCannotChangeTimestamp;
    }

    public boolean addEmployee(Employee employee) {
        return true;
    }

    public boolean deleteEmployee(String employeeName) {
        return true;
    }

    public void timeTable() {
        // TODO: 04.12.2021 синхронизировать время работы сотрудников

        
    }
}
