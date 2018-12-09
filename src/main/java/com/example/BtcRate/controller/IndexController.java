package com.example.BtcRate.controller;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.repository.api.RateRepository;
import com.example.BtcRate.service.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


@RestController
public class IndexController {

    @Autowired
    RateService rateService;

    @RequestMapping(value="",method = RequestMethod.GET)
    public String index(){
        return "Start off application.";
    }

    @RequestMapping(value="/getData", method = RequestMethod.GET)
    public void getData() throws IOException {
        URL url = new URL("https://coinmate.io/api/ticker?currencyPair=BTC_CZK");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        System.out.println(content);

        String json = content.toString();
        json = json.substring(json.indexOf("\"data\":" ) +7 ,json.length() -1);

        ObjectMapper objectMapper = new ObjectMapper();
        RateEntity entity = objectMapper.readValue(json,RateEntity.class);

        rateService.createRate(entity);
    }

}
