package com.examly.springapp.service;

import java.util.List;
import com.examly.springapp.model.Inventory;

public interface InventoryService {
    List<Inventory> getAllInventory();
    Inventory getInventoryById(Long inventoryId);
    Inventory updateInventory(Long inventoryId, Inventory inventory);
}
