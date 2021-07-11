package com.chanaka.bearstore.Model.ingredients;

public class Malt {
    private String name;
    private malt_sub_amount amount;

    public Malt(String name, malt_sub_amount amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public malt_sub_amount getAmount() {
        return amount;
    }

    public void setAmount(malt_sub_amount amount) {
        this.amount = amount;
    }
}
