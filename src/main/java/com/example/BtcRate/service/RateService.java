package com.example.BtcRate.service;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.repository.api.RateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateService {
    private static Logger LOGGER = LoggerFactory.getLogger(RateService.class);

    @Autowired
    RateRepository rateRepository;

    @Transactional
    public List<RateEntity> findAll()
    {
        LOGGER.info("Method findAll() is called.");
        return rateRepository.findAll();
    }

    @Transactional
    public RateEntity findLast(){
        List<RateEntity> list = rateRepository.findAll();
        return list.get(list.size()-1);
    }

    @Transactional
    public void createRate(RateEntity entity)
    {
        LOGGER.info("Created rate: {}",entity);
        rateRepository.save(entity);
    }


}
