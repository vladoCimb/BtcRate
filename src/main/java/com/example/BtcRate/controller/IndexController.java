package com.example.BtcRate.controller;

import com.example.BtcRate.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @Autowired
    RateService rateService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public String index()
    {
        return "Start off application.";
    }


}
