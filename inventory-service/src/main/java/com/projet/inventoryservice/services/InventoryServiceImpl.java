package com.projet.inventoryservice.services;


import com.projet.inventoryservice.entities.Inventory;
import com.projet.inventoryservice.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public Inventory createInventoryItem(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory updateInventory(String productCode, Integer quantity) {
        return inventoryRepository.findByProductCode(productCode)
                .map(inventory -> {
                    inventory.setQuantity(quantity);
                    return inventoryRepository.save(inventory);
                })
                .orElse(null);
    }

    @Override
    public boolean decreaseInventory(String productCode, int quantity) {
        return inventoryRepository.findByProductCode(productCode)
                .map(inventory -> {
                    if (inventory.getQuantity() >= quantity) {
                        inventory.setQuantity(inventory.getQuantity() - quantity);
                        inventoryRepository.save(inventory);
                        return true;
                    }
                    return false;
                })
                .orElse(false);
    }

    @Override
    public Optional<Inventory> getInventoryByProductCode(String productCode) {
        return inventoryRepository.findByProductCode(productCode);
    }

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public void deleteInventoryItem(Long id) {
        inventoryRepository.deleteById(id);
    }
}