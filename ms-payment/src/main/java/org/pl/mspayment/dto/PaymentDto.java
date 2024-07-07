package org.pl.mspayment.dto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.net.Inet4Address;
@Data
public class PaymentDto {

    private Long customerId;

    private Long categoryId;

    private Integer total;

}
