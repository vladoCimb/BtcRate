package com.example.BtcRate.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "serial")
    private Long id;


}
