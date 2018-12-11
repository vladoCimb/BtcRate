package com.example.BtcRate;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.service.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

@Component
public class PageConnector {

    @Autowired
    private RateService rateService;

    @PostConstruct
    public void connect(){
        final long timeInterval = 5000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    try {
                        getJsonFromGet("https://coinmate.io/api/ticker?currencyPair=BTC_CZK");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    // ------- ends here
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    public void getJsonFromGet(String url) throws IOException {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity <String> entity = new HttpEntity<String>(headers);

        String json = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
        json = json.substring(json.indexOf("\"data\":" ) +7 ,json.length() -1);

        ObjectMapper objectMapper = new ObjectMapper();

        rateService.createRate(objectMapper.readValue(json,RateEntity.class));

    }
}
