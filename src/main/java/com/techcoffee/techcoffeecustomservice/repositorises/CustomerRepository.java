package com.techcoffee.techcoffeecustomservice.repositorises;

import com.techcoffee.techcoffeecustomservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {
}
