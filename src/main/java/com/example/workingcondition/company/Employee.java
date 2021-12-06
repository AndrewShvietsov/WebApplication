package com.example.workingcondition.company;

public class Employee {

    private int employeeId;
    private String name;
    private RateBilling salaryForm;
    private Preference preference;
    private int actualStart = Company.getSTART_WORKING();
    private int actualEnd = Company.getEND_WORKING();

    public Employee(String name, RateBilling salaryForm) {
        this.name = name;
        this.salaryForm = salaryForm;
        this.preference = Preference.createOffsetMode(0);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    public double getWorkingTIme(Department department) {
        double result = 0.0;
        int workTime = Company.getEND_WORKING() - Company.getSTART_WORKING() - 1;
        if (preference.preferenceName.equals("Home Mode") && department.isCannotChangeTimestamp()) {
            return workTime * Company.KPD_HOME;
        } else if (preference.preferenceName.equals("Home Mode") && !department.isCannotChangeTimestamp()) {
            return workTime * Company.KPD_WORK_NEGATIVE;
        }
        int desireStart = Company.getSTART_WORKING() + preference.deltaTime;
        result = Math.abs(desireStart - department.getDepartmentWorkingStart()) * Company.KPD_WORK_NEGATIVE +
                (workTime - Math.abs(desireStart - department.getDepartmentWorkingStart())) * Company.KPD_WORK_POSITIVE;
        return result;
    }
}
