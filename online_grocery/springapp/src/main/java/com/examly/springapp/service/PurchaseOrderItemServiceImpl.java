package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.repository.ProductRepo;
import com.examly.springapp.repository.PurchaseOrderItemRepo;

@Service
public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService{
    @Autowired
    PurchaseOrderItemRepo purchaseOrderItemRepo;

    @Autowired
    ProductRepo productRepo;
    @Override
    public PurchaseOrderItem addPurchaseOrderItem(PurchaseOrderItem purchaseOrderItem) {
        Long pid=purchaseOrderItem.getProduct().getProductId();
        Product p=productRepo.findById(pid).orElse(null);
        purchaseOrderItem.setProduct(p);
        return purchaseOrderItemRepo.save(purchaseOrderItem);
        
    }

    public List<PurchaseOrderItem> getByOrderId(Long orderId){
    return purchaseOrderItemRepo
           .findByPurchaseOrder_PurchaseOrderId(orderId);
}


  
    
}
