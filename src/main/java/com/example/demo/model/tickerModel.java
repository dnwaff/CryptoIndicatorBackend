package com.example.demo.model;

import com.opencsv.bean.CsvBindByName;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;


public class tickerModel {
    @CsvBindByName
    private String Symbol;
    @CsvBindByName
    private String Name;

    public tickerModel(){}

    public tickerModel(String Name, String Symbol){
        this.Symbol = Symbol;
        this.Name = Name;
    }

    public String getName() {
        return Name.split("\\/|-")[0];
    }

    public String getSymbol() {
        return Symbol;
    }
}
