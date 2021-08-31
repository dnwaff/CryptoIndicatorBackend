package com.example.demo.api;
import com.example.demo.model.indicatorModel;

import com.example.demo.model.tickerModel;
import com.example.demo.service.CsvService;
import com.example.demo.service.indicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class buyIndicatorController {
    private final indicatorService service;
    private final CsvService csvService;

    @Autowired
    buyIndicatorController(indicatorService service, CsvService csvService){
        this.service = service;
        this.csvService = csvService;
    }
    @GetMapping("api/v1/signal/{ticker}")
    public indicatorModel getBuyIndicator(@PathVariable(value="ticker") String ticker){
        return this.service.getIndicator(ticker);
    }

    @GetMapping("api/v1/tickers")
    public List<tickerModel> getTickers(){
        return this.csvService.getTickers();
    }
}
