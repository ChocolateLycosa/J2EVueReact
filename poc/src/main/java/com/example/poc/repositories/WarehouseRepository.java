package com.example.poc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.poc.entites.Warehouses;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouses, Integer>{
}
