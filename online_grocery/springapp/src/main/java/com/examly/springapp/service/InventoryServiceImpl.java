package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.Inventory;
import com.examly.springapp.model.Product;
import com.examly.springapp.repository.InventoryRepo;
import com.examly.springapp.repository.ProductRepo;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepo inventoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Inventory> getAllInventory() {
        return inventoryRepo.findAll();
    }

    @Override
    public Inventory getInventoryById(Long inventoryId) {
        Optional<Inventory> opt = inventoryRepo.findById(inventoryId);
        if (opt.isPresent()) {
            return opt.get();
        }
        return null;
    }

    @Override
    public Inventory updateInventory(Long inventoryId, Inventory inventoryDetails) {
        Optional<Inventory> opt = inventoryRepo.findById(inventoryId);
        if (opt.isPresent()) {
            Inventory existing = opt.get();
            existing.setQuantity(inventoryDetails.getQuantity());
            if (inventoryDetails.getProduct() != null) {
                Long pid = inventoryDetails.getProduct().getProductId();
                Product p = productRepo.findById(pid).orElse(null);
                existing.setProduct(p);
            }
            return inventoryRepo.save(existing);
        }
        return null;
    }
}
