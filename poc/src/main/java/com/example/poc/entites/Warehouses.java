package com.example.poc.entites;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
@Table("Warehouses")
public class Warehouses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(columnDefinition = "varchar(36)", nullable = false)
    private String uuid;

    @Column(columnDefinition = "varchar(3)", nullable = false)
    private String family;

    @Column(columnDefinition = "integer", nullable = false)
    private int size;

    @Column(columnDefinition = "varchar(50)", nullable = false)
    private String client;

    public String getClient() {
        return client;
    }
    public void setClient(String client) {
        this.client = client;
    }
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
    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    @PrePersist
    protected void onCreate() {
        setUuid(UUID.randomUUID().toString());
    }


    public static final List<String> getCombinations(Warehouses warehouse) {
        List<String> possibleChars = Warehouses.possibleTypes(warehouse.family);
        List<String> res = new ArrayList<String>();
        for(String first : possibleChars){
            List<String> aux = Warehouses.incrementCombinations(first, warehouse.size, warehouse.family);
            for(String item : aux){
                if (!res.contains(item)){
                    res.add(item);
                }
            }
        }
        return res;
    }

    private static List<String> incrementCombinations(String in, int length, String family) {
        List<String> possibleChars = Warehouses.possibleTypes(family);
        List<String> res = new ArrayList<String>();
        List<String> aux = new ArrayList<String>();
        for(String c : possibleChars){
            aux.add(in + c);
        }
        if (in.length() + 1 == length){
            return aux;
        }
        else {
            for(String s : aux){
                res.addAll(Warehouses.incrementCombinations(s, length, family));
            }
            return res;
        }
    }

    private final static List<String> possibleTypes(String family) {
        List<String> res = new ArrayList<String>();
        res.add("A");
        res.add("C");
        res.add(family == "EST" ? "B" : "D");
        return res;
    }


}
