package org.pl.mscustomer.service;

import lombok.RequiredArgsConstructor;
import org.pl.mscustomer.entities.Customer;
import org.pl.mscustomer.repository.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomerService {


    private final CustomerRepository repository;

    public Customer create(Customer customer) {
        return repository.save(customer);
    }

    public Customer findById(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Customer update(Customer customer) {
        Customer updated = repository.findById(customer.getId()).orElse(null);
        BeanUtils.copyProperties(customer, updated, "id");
        return repository.save(customer);
    }
    public void delete(Customer customer) {repository.delete(customer);}
}
