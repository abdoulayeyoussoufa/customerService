package com.techcoffee.techcoffeecustomservice.services;

import com.techcoffee.techcoffeecustomservice.dto.CustomerRequestDto;
import com.techcoffee.techcoffeecustomservice.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    CustomerResponseDto save(CustomerRequestDto cstmRqstDto);
    CustomerResponseDto getCustomer(String id);
    CustomerResponseDto update( CustomerRequestDto costum);
    List<CustomerResponseDto> listCustomers();
}
