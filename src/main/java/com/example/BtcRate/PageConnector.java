package com.example.BtcRate;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.service.RateService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class PageConnector {

    @Autowired
    private RateService rateService;

    @PostConstruct
    public void connect(){
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            public void run() {
                while (true) {
                    // ------- code for task to run
                    try {
                        getData();
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

        rateService.createRate(objectMapper.readValue(json,RateEntity.class));

    }
}
