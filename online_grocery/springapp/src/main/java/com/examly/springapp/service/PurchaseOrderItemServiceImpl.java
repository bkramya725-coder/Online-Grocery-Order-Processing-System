package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.BadRequestException;
import com.examly.springapp.exception.ResourceNotFoundException;
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

    
    if  (purchaseOrderItem == null ||
    purchaseOrderItem.getProduct() == null ||
    purchaseOrderItem.getProduct().getProductId() == null) {
        throw new BadRequestException("Product ID must be provided");
    }

    Long pid = purchaseOrderItem.getProduct().getProductId();

   
    Product product = productRepo.findById(pid)
        .orElseThrow(() ->
            new ResourceNotFoundException(
                "Product not found with id: " + pid
            )
        );

    purchaseOrderItem.setProduct(product);

    return purchaseOrderItemRepo.save(purchaseOrderItem);
}


    public List<PurchaseOrderItem> getByOrderId(Long orderId){
    return purchaseOrderItemRepo
           .findByPurchaseOrder_PurchaseOrderId(orderId);
}


  
    
}

