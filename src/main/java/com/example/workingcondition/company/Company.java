package com.example.workingcondition.company;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private int idCompany;
    private String name;
    private final List<Department> departments = new ArrayList<>();
    private final static int START_WORKING = 9;
    private final static int END_WORKING = 18;
    public final static double KPD_HOME = 1.1;
    public final static double KPD_WORK_POSITIVE = 1.2;
    public final static double KPD_WORK_NEGATIVE = 0.8;


    public Company(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public static int getSTART_WORKING() {
        return START_WORKING;
    }

    public static int getEND_WORKING() {
        return END_WORKING;
    }



    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", departments=" + departments +
                '}';
    }

    public boolean isAddDepartment() {

        return true;
    }

    public boolean isUpdateDepartment() {

        return true;
    }

    public boolean isDeleteDepartment() {

        return true;
    }

    public double calculateEfficiency() {
        // TODO: 04.12.2021 сколько часов работы получается при нашем учете времени
        return 0.0;
    }

}
