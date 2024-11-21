package com.projet.inventoryservice.controllers;

import com.projet.inventoryservice.entities.Inventory;
import com.projet.inventoryservice.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @PostMapping
    public ResponseEntity<Inventory> createInventory(@RequestBody Inventory inventory) {
        return ResponseEntity.ok(inventoryService.createInventoryItem(inventory));
    }

    @PutMapping("/decrease/{productCode}")
    public ResponseEntity<Boolean> decreaseInventory(
            @PathVariable String productCode,
            @RequestParam int quantity
    ) {
        return ResponseEntity.ok(inventoryService.decreaseInventory(productCode, quantity));
    }

    @GetMapping("/product/{productCode}")
    public ResponseEntity<Inventory> getInventoryByProductCode(@PathVariable String productCode) {
        return inventoryService.getInventoryByProductCode(productCode)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        List<Inventory> inventories = inventoryService.getAllInventory();
        return inventories;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInventoryItem(@PathVariable Long id) {
        inventoryService.deleteInventoryItem(id);
        return ResponseEntity.ok().build();
    }

}
