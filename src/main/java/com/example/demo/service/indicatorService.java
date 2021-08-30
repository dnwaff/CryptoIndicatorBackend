package com.example.demo.service;

import com.example.demo.model.indicatorModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class indicatorService {
    public indicatorService(){}

    public indicatorModel getIndicator(String ticker, String endpoint){
        try {
            Document doc = Jsoup.connect(String.format("https://www.barchart.com/crypto/quotes/%s5E%s/opinion","%",endpoint))
                    .header("User-Agent","Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:52.0) Gecko/20100101 Firefox/52.0")
                    .get();

            double percent = Double.parseDouble(doc.select("span.opinion-percent")
                    .first()
                    .text()
                    .replace("%", ""));

            String signal = doc.select("span.opinion-signal")
                    .first()
                    .text();

            return new indicatorModel(ticker,signal,percent);
        }
        catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
