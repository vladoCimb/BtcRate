package com.example.BtcRate.repository.api;

import com.example.BtcRate.model.RateEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RateRepository extends JpaRepository<RateEntity, Long> {


}
