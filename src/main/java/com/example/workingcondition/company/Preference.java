package com.example.workingcondition.company;

public class Preference {

    public String preference;
    public int time;
    public boolean isWorkingHome;

    private Preference(String preference, int time, boolean isWorkingHome) {
        this.preference = preference;
        this.time = time;
        this.isWorkingHome = isWorkingHome;
    }

    @Override
    public String toString() {
        return "Preference{" +
                "preference='" + preference + '\'' +
                ", time=" + time +
                ", isWorkingHome=" + isWorkingHome +
                '}';
    }

    public static Preference createHomeMode() {
        return new Preference("Home Mode", 0, true);
    }

    public static Preference createOffsetMode(int delta) {
        return new Preference(delta == 0 ? "Default Mode" : "Offset Mode", delta, false);
    }
}
