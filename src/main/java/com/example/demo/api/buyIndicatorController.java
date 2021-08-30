package com.example.demo.api;
import com.example.demo.model.indicatorModel;

import com.example.demo.service.indicatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class buyIndicatorController {
    private final indicatorService service;

    @Autowired
    buyIndicatorController(indicatorService service){
        this.service = service;
    }
    @GetMapping("api/v1/{ticker}")
    public indicatorModel getBuyIndicator(@PathVariable(value="ticker") String ticker){
        return this.service.getIndicator(ticker,"LTCUSD");
    }
}
