package com.techcoffee.techcoffeecustomservice.servicesImpl;

import com.techcoffee.techcoffeecustomservice.dto.CustomerRequestDto;
import com.techcoffee.techcoffeecustomservice.dto.CustomerResponseDto;
import com.techcoffee.techcoffeecustomservice.entities.Customer;
import com.techcoffee.techcoffeecustomservice.mappers.CustomerMapper;
import com.techcoffee.techcoffeecustomservice.repositorises.CustomerRepository;
import com.techcoffee.techcoffeecustomservice.services.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;
    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }




    @Override
    public CustomerResponseDto save(CustomerRequestDto cstmRqstDto) {
        Customer cust = customerMapper.customerRequestDtoToCustomer(cstmRqstDto);
        Customer custSave = customerRepository.save(cust);

        CustomerResponseDto cstRespDto = customerMapper.customerToCustomerResponseDto(custSave);

        return cstRespDto;
    }

    @Override
    public CustomerResponseDto getCustomer(String id) {
        Customer cust = customerRepository.findById(id).get();

        return customerMapper.customerToCustomerResponseDto(cust);
    }

    @Override
    public CustomerResponseDto update(CustomerRequestDto costum) {
        Customer cust = customerMapper.customerRequestDtoToCustomer(costum);
        Customer saveCust = customerRepository.save(cust);
        return customerMapper.customerToCustomerResponseDto(saveCust);
    }

    @Override
    public List<CustomerResponseDto> listCustomers() {

        List<Customer> customers = customerRepository.findAll();

        List<CustomerResponseDto> customerResponseDtos = customers.stream()
                .map(cust ->customerMapper
                             .customerToCustomerResponseDto(cust)).collect(Collectors.toList());
        return customerResponseDtos;
    }
}
