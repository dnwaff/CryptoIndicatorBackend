package com.example.demo.scraper;

import com.example.demo.model.indicatorModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

public class InvestingScraper implements ScraperInt {
    private String ticker;
    public InvestingScraper(String ticker){ this.ticker = ticker;}

    public indicatorModel scrape(){
        try {
            Document doc = Jsoup.connect(String.format("https://www.investing.com/indices/investing.com-%s-technical", this.ticker))
                    .header("User-Agent","Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0")
                    .get();

            String signal = doc.select("div#techinalContent")
                    .select("div.newTechStudiesRight")
                    .select("div.summary")
                    .select("span")
                    .first()
                    .text();
            return new indicatorModel(this.ticker,signal,0);
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
