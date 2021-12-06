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
        return employeeList.add(employee);
    }

    public boolean isCannotChangeTimestamp() {
        return isCannotChangeTimestamp;
    }

    public int getDepartmentWorkingStart() {
        return departmentWorkingStart;
    }

    public int getDepartmentWorkingEnd() {
        return departmentWorkingEnd;
    }

    public boolean deleteEmployee(String employeeName) {
        boolean result = false;
        List<Employee> copyList = new ArrayList<>(employeeList);
        for (Employee employee : copyList) {
            if (employeeName.equals(employee.getName())) {
                result = true;
                employeeList.remove(employee);
                break;
            }
        }
        return result;
    }

    public void timeTable() {
        if (isCannotChangeTimestamp) {
            departmentWorkingStart = Company.getSTART_WORKING();
            departmentWorkingEnd = Company.getEND_WORKING();
        } else {
            int minStart = getMinStart();
            int maxStart = getMaxStart();
            int copyStartDepartment = departmentWorkingStart;
            int copyEndDepartment = departmentWorkingEnd;
            double currentMax = 0.0;
            int tempTime = minStart;
            for (int i = minStart; i <= maxStart; i++) {
                departmentWorkingStart++;
                departmentWorkingEnd++;
                double totalTime = 0.0;
                for (Employee employee : employeeList) {
                    totalTime += employee.getWorkingTIme(this);
                }
                if (currentMax < totalTime) {
                    currentMax = totalTime;
                    tempTime = i;
                }
            }
            departmentWorkingStart = tempTime;
            departmentWorkingEnd = departmentWorkingStart + 9;
        }
    }

    private int getMaxStart() {
        int currentMax = 0;
        for (Employee employee : employeeList) {
            int temp = employee.getPreference().deltaTime + Company.getSTART_WORKING();
            if (temp > currentMax) {
                currentMax = temp;
            }
        }
        return currentMax;
    }

    private int getMinStart() {
        int currentMin = 0;
        for (Employee employee : employeeList) {
            int temp = employee.getPreference().deltaTime + Company.getSTART_WORKING();
            if (temp < currentMin) {
                currentMin = temp;
            }
        }
        return currentMin;
    }
}
