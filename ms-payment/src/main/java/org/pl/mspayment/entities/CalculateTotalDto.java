package org.pl.mspayment.entities;

import lombok.Data;

@Data
public class CalculateTotalDto {

    private Long categoryId;

    private Integer value;
}
