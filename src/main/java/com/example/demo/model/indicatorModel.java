package com.example.demo.model;

public class indicatorModel {
    private final String signal;
    private final String name;
    private final double percentage;

    public indicatorModel(String name, String signal, double percentage){
        this.signal = signal;
        this.percentage = percentage;
        this.name = name;
    }

    public double getPercentage() {
        return percentage;
    }

    public String getSignal() {
        return signal;
    }

    public String getName() {
        return name;
    }
}
