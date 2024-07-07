package org.pl.mscustomer.repository;

import org.pl.mscustomer.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
