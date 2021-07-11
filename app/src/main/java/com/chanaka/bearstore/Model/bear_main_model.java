package com.chanaka.bearstore.Model;

import com.chanaka.bearstore.Model.boil_vaolume.bear_boil_volume;
import com.chanaka.bearstore.Model.ingredients.bear_ingredients;
import com.chanaka.bearstore.Model.method.bear_method;
import com.chanaka.bearstore.Model.volume.baer_volume;

import java.util.List;

public class bear_main_model {
    private  int id;
    private  String name;
    private  String tagline;
    private String image_url;

    private String first_brewed;
    private  String description;
    private  double abv;
    private  double ibu;
    private  double target_fg;
    private  double target_og;
    private  double ebc;
    private  double srm;
    private  double ph;
    private  double attenuation_level;
    private baer_volume volume;
    private bear_boil_volume boil_volume ;
    private bear_method method;
    private bear_ingredients ingredients;
    private List<String> food_pairing;
    private  String brewers_tips;
    private  String contributed_by;

    public bear_main_model() {
    }

    public bear_main_model(baer_volume volume, String name, String tagline,
                           String image_url, String first_brewed, String description,
                           double abv, double ibu, double target_fg, double target_og,
                           double ebc, double srm, double ph, double attenuation_level,
                           bear_boil_volume boil_volume, bear_method method, bear_ingredients ingredients,
                           List<String> food_pairing, String brewers_tips, String contributed_by
                           ) {
        this.name = name;
        this.tagline = tagline;
        this.image_url = image_url;
        this.first_brewed = first_brewed;
        this.description = description;
        this.abv = abv;
        this.ibu = ibu;
        this.target_fg = target_fg;
        this.target_og = target_og;
        this.ebc = ebc;
        this.srm = srm;
        this.ph = ph;
        this.attenuation_level = attenuation_level;
        this.volume=volume;
        this.boil_volume=boil_volume;
        this.method = method;
        this.ingredients= ingredients;
        this.food_pairing =food_pairing;
        this.brewers_tips=brewers_tips;
        this.contributed_by=contributed_by;
    }

    public String getBrewers_tips() {
        return brewers_tips;
    }

    public void setBrewers_tips(String brewers_tips) {
        this.brewers_tips = brewers_tips;
    }

    public String getContributed_by() {
        return contributed_by;
    }

    public void setContributed_by(String contributed_by) {
        this.contributed_by = contributed_by;
    }

    public List<String> getFood_pairing() {
        return food_pairing;
    }

    public void setFood_pairing(List<String> food_pairing) {
        this.food_pairing = food_pairing;
    }

    public bear_ingredients getIngredients() {
        return ingredients;
    }

    public void setIngredients(bear_ingredients ingredients) {
        this.ingredients = ingredients;
    }

    public bear_method getMethod() {
        return method;
    }

    public void setMethod(bear_method method) {
        this.method = method;
    }

    public bear_boil_volume getBoil_volume() {
        return boil_volume;
    }

    public void setBoil_volume(bear_boil_volume boil_volume) {
        this.boil_volume = boil_volume;
    }

    public baer_volume getVolume() {
        return volume;
    }

    public void setVolume(baer_volume volume) {
        this.volume = volume;
    }
    public String getFirst_brewed() {
        return first_brewed;
    }

    public void setFirst_brewed(String first_brewed) {
        this.first_brewed = first_brewed;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAbv() {
        return abv;
    }

    public void setAbv(double abv) {
        this.abv = abv;
    }

    public double getIbu() {
        return ibu;
    }

    public void setIbu(double ibu) {
        this.ibu = ibu;
    }

    public double getTarget_fg() {
        return target_fg;
    }

    public void setTarget_fg(double target_fg) {
        this.target_fg = target_fg;
    }

    public double getTarget_og() {
        return target_og;
    }

    public void setTarget_og(double target_og) {
        this.target_og = target_og;
    }

    public double getEbc() {
        return ebc;
    }

    public void setEbc(double ebc) {
        this.ebc = ebc;
    }

    public double getSrm() {
        return srm;
    }

    public void setSrm(double srm) {
        this.srm = srm;
    }

    public double getPh() {
        return ph;
    }

    public void setPh(double ph) {
        this.ph = ph;
    }

    public double getAttenuation_level() {
        return attenuation_level;
    }

    public void setAttenuation_level(double attenuation_level) {
        this.attenuation_level = attenuation_level;
    }


/*public bear_main_model(int id, String name, String tagline, String image_url) {
        this.id = id;
        this.name = name;
        this.tagline = tagline;
        this.image_url = image_url;
    }*/

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
