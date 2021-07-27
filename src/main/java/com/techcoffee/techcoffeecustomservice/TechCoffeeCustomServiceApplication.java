package com.techcoffee.techcoffeecustomservice;

import com.techcoffee.techcoffeecustomservice.dto.CustomerRequestDto;
import com.techcoffee.techcoffeecustomservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TechCoffeeCustomServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TechCoffeeCustomServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerService customerService){
        return  args -> {
          customerService.save(new CustomerRequestDto("Co1","CoffeTech","coffeTech@gmail.com"));
            customerService.save(new CustomerRequestDto("Co2","Seysoo","seysoech@gmail.com"));
        };
    }
}
