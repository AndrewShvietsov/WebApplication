package com.example.workingcondition.company;

public class Employee {

    private String name;
    private RateBilling salaryForm;
    private Preference preference;

    public Employee(String name, RateBilling salaryForm) {
        this.name = name;
        this.salaryForm = salaryForm;
        this.preference = Preference.createOffsetMode(0);

    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}
