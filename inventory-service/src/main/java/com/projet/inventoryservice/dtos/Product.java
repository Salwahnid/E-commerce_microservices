package com.projet.inventoryservice.dtos;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private String Barcode;
}
