package org.pl.mscustomer.dto.mapper;

import org.modelmapper.ModelMapper;
import org.pl.mscustomer.dto.CustomerDto;
import org.pl.mscustomer.dto.CustomerInfoDto;
import org.pl.mscustomer.dto.CustomerResponseDto;
import org.pl.mscustomer.entities.Customer;

public class CustomerMapper {

    public static Customer toCustomer(CustomerDto customerDto) {

        customerDto.setPoints(0L);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customerDto, Customer.class);
    }

    public static CustomerResponseDto toCustomerDto(Customer customer) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customer, CustomerResponseDto.class);
    }

    public static CustomerInfoDto toInfoDto(Customer customer) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customer, CustomerInfoDto.class);
    }

}
