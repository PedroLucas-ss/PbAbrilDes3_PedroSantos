package org.pl.mspayment.dto.mapper;

import org.modelmapper.ModelMapper;
import org.pl.mspayment.dto.PaymentDto;
import org.pl.mspayment.entities.Payment;

import java.time.LocalDate;

public class PaymentMapper {

    public static Payment toDto(PaymentDto paymentDto) {

        Payment payment = new Payment();
        payment.setCategory_id(paymentDto.getCategoryId());
        payment.setCustomer_id(paymentDto.getCustomerId());
        payment.setTotal(paymentDto.getTotal());
        payment.setCreated_date(LocalDate.now());

        return payment;
    }

}
