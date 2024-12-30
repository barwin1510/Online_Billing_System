package com.project.OnlineBillingSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.OnlineBillingSystem.model.Product;

public interface ProductRepository extends JpaRepository < Product , Long > {

}
