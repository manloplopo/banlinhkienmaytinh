package com.example.quanlybanlinhkienmaytinh.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.quanlybanlinhkienmaytinh.models.Product;

public interface ProductsRepository extends JpaRepository<Product , Integer> {
}