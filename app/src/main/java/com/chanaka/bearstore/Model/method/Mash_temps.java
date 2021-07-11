package com.chanaka.bearstore.Model.method;

public class Mash_temps {
    private mash_temp_sub_temp temp;
    private int duration;

/*    public Mash_temps(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }*/
    public Mash_temps(mash_temp_sub_temp temp, int duration) {
        this.temp = temp;
        this.duration = duration;
    }

    public mash_temp_sub_temp getTemp() {
        return temp;
    }

    public void setTemp(mash_temp_sub_temp temp) {
        this.temp = temp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
