package com.chanaka.bearstore.Model.ingredients;

public class Hops {
    private String name;
    private hops_sub_amount amount;
    private String add;
    private String attribute;

    public Hops(String name,hops_sub_amount amount, String add, String attribute) {
       this.name = name;
        this.amount = amount;
        this.add = add;
        this.attribute = attribute;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public hops_sub_amount getAmount() {
        return amount;
    }

    public void setAmount(hops_sub_amount amount) {
        this.amount = amount;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
