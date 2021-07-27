package com.techcoffee.techcoffeecustomservice.mappers;

import com.techcoffee.techcoffeecustomservice.dto.CustomerRequestDto;
import com.techcoffee.techcoffeecustomservice.dto.CustomerResponseDto;
import com.techcoffee.techcoffeecustomservice.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel="spring")
public interface CustomerMapper {
    Customer customerRequestDtoToCustomer(CustomerRequestDto cusReqDto);
    CustomerResponseDto customerToCustomerResponseDto(Customer cust);
}
