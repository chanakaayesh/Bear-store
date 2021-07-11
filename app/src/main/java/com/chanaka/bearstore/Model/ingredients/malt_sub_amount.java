package com.chanaka.bearstore.Model.ingredients;

public class malt_sub_amount {
    private  double value;
    private  String unit;

    public malt_sub_amount(double value, String unit) {
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
