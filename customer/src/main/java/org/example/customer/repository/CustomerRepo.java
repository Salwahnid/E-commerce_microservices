package org.example.customer.repository;

import org.example.customer.model.CustomerModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerModel, Long> {
    // Repository Spring Data JPA pour CRUD
}
