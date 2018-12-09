package com.example.BtcRate.dto;

import lombok.*;

import javax.persistence.Entity;

@Getter
@Setter
@NoArgsConstructor
public class RateDto extends AbstractDto{
    private long last;
    private long high;
    private long low;
    private long amount;
    private long bid;
    private long ask;
    private long change;
    private long open;
    private long timestamp;


}

