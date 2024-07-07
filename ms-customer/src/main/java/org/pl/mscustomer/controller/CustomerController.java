package org.pl.mscustomer.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.pl.mscustomer.dto.CustomerDto;
import org.pl.mscustomer.dto.CustomerInfoDto;
import org.pl.mscustomer.dto.CustomerResponseDto;
import org.pl.mscustomer.dto.mapper.CustomerMapper;
import org.pl.mscustomer.entities.Customer;
import org.pl.mscustomer.service.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/customers")
public class CustomerController {

    private final CustomerService customerService;



    @PostMapping
    public ResponseEntity<CustomerResponseDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
        Customer customer = CustomerMapper.toCustomer(customerDto);
        Customer savedCustomer = customerService.create(customer);
        return ResponseEntity.ok().body(CustomerMapper.toCustomerDto(savedCustomer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerInfoDto> getById(@PathVariable Long id) {

        Customer customer =  customerService.findById(id);
            return ResponseEntity.ok(CustomerMapper.toInfoDto(customer));

        }
    @PutMapping("/{id}")
    public ResponseEntity<CustomerResponseDto> updateCustomer(@PathVariable Long id,
                                                              @Valid @RequestBody CustomerDto customerDto) {


        Customer customer = CustomerMapper.toCustomer(customerDto);
        customer.setId(id);
        customerService.update(customer);
        return ResponseEntity.ok(CustomerMapper.toCustomerDto(customer));

    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){

        Customer customer =  customerService.findById(id);
        customerService.delete(customer);
        return "Customer deleted";
    }

}



