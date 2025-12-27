package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.PurchaseOrderItem;
import com.examly.springapp.service.PurchaseOrderItemService;

@RestController
@RequestMapping("/api/purchase-order-items")
public class PurchaseOrderItemController {
    @Autowired
    PurchaseOrderItemService purchaseOrderItemService;

    @PostMapping
    public ResponseEntity<PurchaseOrderItem> addPurchaseOrderItem(@RequestBody PurchaseOrderItem purchaseOrderItem){
        PurchaseOrderItem p=purchaseOrderItemService.addPurchaseOrderItem(purchaseOrderItem);
       
        return new ResponseEntity<PurchaseOrderItem>(p,HttpStatus.CREATED);
       
    }
    
    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<PurchaseOrderItem>> getByOrderId(@PathVariable Long orderId){
        List<PurchaseOrderItem> p=purchaseOrderItemService.getByOrderId(orderId);
        
            return new ResponseEntity<List<PurchaseOrderItem>>(p,HttpStatus.OK);
       
    }

    
}

