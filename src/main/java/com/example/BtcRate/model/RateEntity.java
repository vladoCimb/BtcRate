package com.example.BtcRate.model;


import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class RateEntity extends AbstractEntity{
    @Column(name = "VALUE", nullable = false)
    @NonNull
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
