package com.chanaka.bearstore.Model.boil_vaolume;

public class bear_boil_volume {
    private double value;
    private String unit;

    public bear_boil_volume(double value, String unit) {
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
