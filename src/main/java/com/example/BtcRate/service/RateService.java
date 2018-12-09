package com.example.BtcRate.service;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.repository.api.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateService {

    @Autowired
    RateRepository rateRepository;

    @Transactional
    public List<RateEntity> findAll()
    {
        return rateRepository.findAll();
    }

    @Transactional
    public void createRate(RateEntity entity)
    {
        rateRepository.save(entity);
    }





}
