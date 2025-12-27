package com.examly.springapp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.Inventory;
import com.examly.springapp.service.InventoryService;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<Inventory> getAll() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/{inventoryId}")
    public ResponseEntity<Inventory> getById(@PathVariable Long inventoryId) {
        Inventory inventory = inventoryService.getInventoryById(inventoryId);
       
            return ResponseEntity.ok(inventory);
        
    }

    @PutMapping("/{inventoryId}")
    public ResponseEntity<Inventory> update(@PathVariable Long inventoryId, @RequestBody Inventory inventory) {
        Inventory updated = inventoryService.updateInventory(inventoryId, inventory);
       
            return ResponseEntity.ok(updated);
      
    }
}

