package org.pl.mspayment.repository;

import org.pl.mspayment.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
