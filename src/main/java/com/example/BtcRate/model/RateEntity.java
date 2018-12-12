package com.example.BtcRate.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="RATES")
public class RateEntity extends AbstractEntity{
    @Column(name = "LAST", nullable = false)
    private double last;
    @Column(name = "HIGH")
    private double high;
    @Column(name = "LOW")
    private double low;
    @Column(name = "AMOUNT")
    private double amount;
    @Column(name = "BID")
    private double bid;
    @Column(name = "ASK")
    private double ask;
    @Column(name = "CHANGE")
    private double change;
    @Column(name = "OPEN")
    private double open;
    @Column(name = "TIMESTAMP")
    private double timestamp;
}
