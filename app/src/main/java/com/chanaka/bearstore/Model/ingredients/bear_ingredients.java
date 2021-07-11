package com.chanaka.bearstore.Model.ingredients;

import java.util.List;

public class bear_ingredients {
    private List<Malt> malt;
    private List<Hops> hops;
    private String yeast;

    public bear_ingredients(List<Malt> malt, List<Hops> hops, String yeast) {
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
    }

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }

    public List<Hops> getHops() {
        return hops;
    }

    public void setHops(List<Hops> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
}
