package org.pl.mspayment.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import feign.Client;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.pl.mspayment.entities.CalculateResponseDto;
import org.pl.mspayment.entities.Payment;
import org.pl.mspayment.entities.ProtocolPointsCustomer;
import org.pl.mspayment.infra.Clients;
import org.pl.mspayment.infra.TotalPointPublisher;
import org.pl.mspayment.repository.PaymentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.beans.BeanProperty;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    private final TotalPointPublisher totalPointPublisher;

    private final Clients clients;

    public Payment createPayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment getPayment(UUID id) {
        return paymentRepository.findById(id).orElse(null);
    }

    public ProtocolPointsCustomer totalPoints(CalculateResponseDto calc){
        try {
            totalPointPublisher.getPoins(calc);
            var protocolo =UUID.randomUUID().toString();
            return new ProtocolPointsCustomer(protocolo);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
