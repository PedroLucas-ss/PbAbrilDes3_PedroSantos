package org.pl.mspayment.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.pl.mspayment.dto.PaymentDto;
import org.pl.mspayment.dto.mapper.PaymentMapper;
import org.pl.mspayment.dto.mapper.PaymentToCalculateMapper;
import org.pl.mspayment.entities.CalculateResponseDto;
import org.pl.mspayment.entities.Payment;
import org.pl.mspayment.entities.ProtocolPointsCustomer;
import org.pl.mspayment.infra.Clients;
import org.pl.mspayment.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    private final Clients clients;

    @PostMapping
    public ResponseEntity<Payment> payment(@RequestBody Payment payment) {
        CalculateResponseDto total = new CalculateResponseDto();
        total.setTotal(clients.calculate(PaymentToCalculateMapper.calculatePayment(payment)).getBody().getTotal());
        total.setCustomerId(payment.getCustomer_id());

        ProtocolPointsCustomer total1 = paymentService.totalPoints(total);

        log.info(clients.calculate(PaymentToCalculateMapper.calculatePayment(payment)).toString());
        log.info(total.getTotal().toString());
        paymentService.createPayment(payment);

        return ResponseEntity.ok().body(payment);

    }


    @GetMapping("/{paymentId}")
    public ResponseEntity<Payment> getPayment(@PathVariable UUID paymentId) {


        return ResponseEntity.ok().body(paymentService.getPayment(paymentId));

    }


}
