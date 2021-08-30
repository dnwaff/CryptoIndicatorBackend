package com.example.demo.model;

public class indicatorModel {
    private final String buy_sell;
    private final String name;
    private final double percentage;

    public indicatorModel(String name, String buy_sell, double percentage){
        this.buy_sell = buy_sell;
        this.percentage = percentage;
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getBuy_sell() {
        return buy_sell;
    }

    public String getName() {
        return name;
    }
}
