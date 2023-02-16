package com.example.bumble.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bumble.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
