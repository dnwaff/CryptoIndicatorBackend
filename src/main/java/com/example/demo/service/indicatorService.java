package com.example.demo.service;

import com.example.demo.scraper.Scraper;
import com.example.demo.model.indicatorModel;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class indicatorService {
    private Random rand;

    public indicatorService(){
        this.rand = new Random();
        this.rand.setSeed(1000);
    }

    public indicatorModel getRandomIndicator(String ticker){
        String[] signalChoices = {"buy", "sell", "neutral"};
        double percent = Double.valueOf(this.rand.nextInt(100));
        String signal = signalChoices[this.rand.nextInt(2)];
        indicatorModel result = new indicatorModel(signal,ticker,percent);
        return result;
    }

    public indicatorModel getIndicator(String ticker){
        return Scraper.scrape(ticker);
        }
}
