package com.example.BtcRate.service;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.repository.api.RateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
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
        List<RateEntity> list= rateRepository.findAll();
        LOGGER.info("Methid findAll() return {}:",list);
        return list;
    }

    @Transactional
    public List<RateEntity> findLastTwo(){
        LOGGER.info("Method findLastTwo() is called.");
        List<RateEntity> list = rateRepository.findAll();
        ArrayList<RateEntity> returnList = new ArrayList();
        RateEntity entity = list.get(list.size()-1);

        LOGGER.info("First rate is adding to list: {}",entity);
        returnList.add(entity);
        LOGGER.info("First added.");
        entity = list.get(list.size()-2);
        LOGGER.info("Second rate is adding to list: {}",entity);
        returnList.add(entity);

        LOGGER.info("Returning last 2 rates: {}",returnList);
        return returnList;
    }

    @Transactional
    public void createRate(RateEntity entity)
    {
        LOGGER.info("Method createRate() is called.");
        LOGGER.info("Created rate: {}",entity);
        rateRepository.save(entity);
    }


}
