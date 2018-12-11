package com.example.BtcRate.repository.api;

import com.example.BtcRate.model.RateEntity;
import com.example.BtcRate.service.RateService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface RateRepository extends JpaRepository<RateEntity, Long> {

}
