package com.techcoffee.techcoffeecustomservice.web;

import com.techcoffee.techcoffeecustomservice.dto.CustomerRequestDto;
import com.techcoffee.techcoffeecustomservice.dto.CustomerResponseDto;
import com.techcoffee.techcoffeecustomservice.repositorises.CustomerRepository;
import com.techcoffee.techcoffeecustomservice.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api")
public class CustomerRestApi {
   private CustomerService customerService ;

    public CustomerRestApi(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "custmers")
    List<CustomerResponseDto> getCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping(path = "/customers")
    CustomerResponseDto save(@RequestBody CustomerRequestDto customerRequestDto){
       customerRequestDto.setId(UUID.randomUUID().toString());
        return  customerService.save(customerRequestDto);
    }

    @GetMapping(path = "/customers/{id}")
    CustomerResponseDto getCustomer(@PathVariable String id){
        return  customerService.getCustomer(id);
    }

}
