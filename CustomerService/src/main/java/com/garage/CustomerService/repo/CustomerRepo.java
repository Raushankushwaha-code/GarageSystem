package com.garage.CustomerService.repo;

import com.garage.CustomerService.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepo extends JpaRepository<Customer,Long> {
}
