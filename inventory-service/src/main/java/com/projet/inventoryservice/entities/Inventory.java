package com.projet.inventoryservice.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.projet.inventoryservice.dtos.Product;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_code", unique = true)
    private String productCode;

    private Integer quantity;

    @Transient
    @JsonIgnore
    private Product product;

    private String location;
}