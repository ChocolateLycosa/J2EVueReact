package com.example.poc.entites;

import java.util.UUID;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
@Table("Racks")
public class Racks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "integer", nullable = false)
    private int warehouseId;

    public int getWarehouseId() {
        return warehouseId;
    }
    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    @Column(columnDefinition = "varchar(36)", nullable = false)
    private String uuid;

    @Column(columnDefinition = "char(1)", nullable = false)
    private Character type;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public Character getType() {
        return type;
    }
    public void setType(Character type) {
        this.type = type;
    }

    @PrePersist
    protected void onCreate() {
        setUuid(UUID.randomUUID().toString());
    }
}
