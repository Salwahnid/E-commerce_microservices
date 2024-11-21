package com.projet.inventoryservice.services;

import com.projet.inventoryservice.entities.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    Inventory createInventoryItem(Inventory inventory);
    Inventory updateInventory(String productCode, Integer quantity);
    boolean decreaseInventory(String productCode, int quantity);
    Optional<Inventory> getInventoryByProductCode(String productCode);
    List<Inventory> getAllInventory();
    void deleteInventoryItem(Long id);
}

