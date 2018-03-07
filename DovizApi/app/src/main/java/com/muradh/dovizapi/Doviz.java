package com.muradh.dovizapi;

/**
 * Created by Murad on 03/03/2018.
 */

public class Doviz {

    private double selling;
    private int update_date;
    private int currency;
    private double buying;
    private double change_rate;
    private String name;
    private String full_name;
    private String code;

    public Doviz(double selling, int update_date, int currency, double buying, double change_rate, String name, String full_name, String code) {
        this.selling = selling;
        this.update_date = update_date;
        this.currency = currency;
        this.buying = buying;
        this.change_rate = change_rate;
        this.name = name;
        this.full_name = full_name;
        this.code = code;
    }

    public double getSelling() {
        return selling;
    }

    public int getUpdate_date() {
        return update_date;
    }

    public int getCurrency() {
        return currency;
    }

    public double getBuying() {
        return buying;
    }

    public double getChange_rate() {
        return change_rate;
    }

    public String getName() {
        return name;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getCode() {
        return code;
    }
}
