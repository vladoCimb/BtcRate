package com.example.BtcRate.controller;


import com.example.BtcRate.model.RateEntity;
import  com.example.BtcRate.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
@RequestMapping("/rate")
public class RateController {

    @Autowired
    private RateService rateService;

    @RequestMapping(value="/all",method = RequestMethod.GET)
    public List<RateEntity> findAll(){
        return rateService.findAll();
    }

    @RequestMapping(value="",method = RequestMethod.GET)
    public List<RateEntity> findLastTwo(){
        return rateService.findLastTwo();
    }



}
