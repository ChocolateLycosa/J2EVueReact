package com.example.poc.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.poc.entites.Racks;

@Repository
public interface RackRepository extends JpaRepository<Racks, Integer> {
    List<Racks> findByWarehouseId(int warehouseId);
}
