package com.example.demo.api;
import com.example.demo.model.indicatorModel;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class buyIndicatorController {
    @GetMapping("api/v1/{ticker}")
    public indicatorModel getBuyIndicator(@PathVariable(value="ticker") String ticker){
        return new indicatorModel("ticker", "buy", 20.2);
    }
}
