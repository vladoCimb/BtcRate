package com.example.BtcRate.dto;

import com.example.BtcRate.model.RateEntity;


import java.util.function.Function;

public class Translations {
    public static Function<RateEntity, RateDto> RATE_DOMAIN_TO_DTO = rateEntity -> {
        if (rateEntity == null) return null;

        RateDto rateDto = new RateDto();

        return rateDto;
    };

}
