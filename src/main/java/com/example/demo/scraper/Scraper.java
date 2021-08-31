package com.example.demo.scraper;
import com.example.demo.model.indicatorModel;

public class Scraper {
    public static indicatorModel scrape(String ticker){
        return aggregateScraper(ticker);
    }

    private static indicatorModel aggregateScraper(String ticker){
        BarChartScraper scraper = new BarChartScraper(ticker);
        return scraper.scrape();
    }
}
