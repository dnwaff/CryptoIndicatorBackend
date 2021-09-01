package com.example.demo.service;

import com.example.demo.model.tickerModel;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.util.List;
import java.util.Optional;

@Service
public class CsvService {
    private List<tickerModel> tickers;

    public CsvService(){
        String fileName = "src/main/java/misc/BarChartTickers.csv";
        try(FileReader reader = new FileReader(fileName)) {
           this.tickers = new CsvToBeanBuilder<tickerModel>(reader)
                    .withType(tickerModel.class)
                    .build()
                    .parse();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public List<tickerModel> getTickers() {
        return this.tickers;
    }

    public void getTicker(String name) {
        Optional<tickerModel> ticker = this.tickers.stream()
                                .filter(obj -> obj.getName().contains(name))
                                .findFirst();
        if (ticker.isPresent()) {
            System.out.println(ticker.get().getSymbol());
        }
        else{
            System.out.println("Not present");
        }
    }
}
