package com.chanaka.bearstore.Model.method;

import java.util.List;

public class bear_method {
   /* private Mash_temps mash_temp;*/
    private List<Mash_temps> mash_temp;
    private Fermentation fermentation;
    private String twist;

    public bear_method(List<Mash_temps> mash_temp, Fermentation fermentation, String twist) {
        this.mash_temp = mash_temp;
        this.fermentation = fermentation;
        this.twist = twist;
    }

    public List<Mash_temps> getMash_temp() {
        return mash_temp;
    }

    public void setMash_temp(List<Mash_temps> mash_temp) {
        this.mash_temp = mash_temp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }

    /*    public bear_method(*//*Mash_temps mash_temp, *//*Fermentation fermentation, String twist) {
       *//* this.mash_temp = mash_temp;*//*
        this.fermentation = fermentation;
        this.twist = twist;
    }

  *//*  public Mash_temps getMash_temp() {
        return mash_temp;
    }

    public void setMash_temp(Mash_temps mash_temp) {
        this.mash_temp = mash_temp;
    }*//*

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }*/
}
