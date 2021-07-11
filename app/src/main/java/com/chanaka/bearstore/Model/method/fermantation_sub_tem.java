package com.chanaka.bearstore.Model.method;

public class fermantation_sub_tem {
    private double value;
    private String unit;

    public fermantation_sub_tem(double value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
