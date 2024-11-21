package com.projet.inventoryservice.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class InventoryDto {
    private int id;
    private String productCode;
    private int quantity;
    private String location;
}