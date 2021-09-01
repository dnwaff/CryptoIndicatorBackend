package com.example.demo.scraper;
import com.example.demo.model.indicatorModel;

import java.util.ArrayList;
import java.util.List;

public class Scraper {
    public static indicatorModel scrape(String ticker){
        return aggregateScraper(ticker);
    }

    private static indicatorModel aggregateScraper(String ticker){
        List<ScraperInt> scrapers = new ArrayList<ScraperInt>();
        scrapers.add(new BarChartScraper(ticker));
        scrapers.add(new InvestingScraper(ticker));
        for (ScraperInt scraper : scrapers) {
            indicatorModel result = scraper.scrape();
            if (result != null){
                return result;
            }
        }
        return null;
    }
}
