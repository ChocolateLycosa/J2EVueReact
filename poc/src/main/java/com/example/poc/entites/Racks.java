package com.example.poc.entites;

import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@Table("Racks")
public class Racks {
    @Id
    private Long id;
    private Long warehouse_id;
    private String uuid;
    private Character type;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getWarehouse_id() {
        return warehouse_id;
    }
    public void setWarehouse_id(Long warehouse_id) {
        this.warehouse_id = warehouse_id;
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
}
