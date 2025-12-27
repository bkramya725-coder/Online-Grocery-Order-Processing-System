package com.examly.springapp.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
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
       return inventoryRepo.findById(inventoryId).orElseThrow(()->new ResourceNotFoundException("Inventory is not found with respective id.."));
       
    }

   @Override
public Inventory updateInventory(Long inventoryId, Inventory inventoryDetails) {

    Inventory existing = inventoryRepo.findById(inventoryId)
        .orElseThrow(() ->
            new ResourceNotFoundException(
                "Inventory not found with id: " + inventoryId
            )
        );

    
    existing.setQuantity(inventoryDetails.getQuantity());
    if (inventoryDetails.getProduct() != null) {
        Long pid = inventoryDetails.getProduct().getProductId();

        Product product = productRepo.findById(pid)
            .orElseThrow(() ->
                new ResourceNotFoundException(
                    "Product not found with id: " + pid
                )
            );

        existing.setProduct(product);
    }

    return inventoryRepo.save(existing);
}

}

