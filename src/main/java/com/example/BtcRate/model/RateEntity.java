package com.example.BtcRate.model;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@ToString
public class RateEntity extends AbstractEntity{
    @Column(name = "VALUE", nullable = false)
    private double last;
    private double high;
    private double low;
    private double amount;
    private double bid;
    private double ask;
    private double change;
    private double open;
    private double timestamp;
}
