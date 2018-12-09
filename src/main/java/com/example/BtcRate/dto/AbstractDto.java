package com.example.BtcRate.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDto {
    private Long id;
    private LocalDateTime createdTime;

}
