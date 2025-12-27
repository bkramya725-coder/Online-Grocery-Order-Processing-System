package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.service.PurchaseOrderService;

@RestController
@RequestMapping(path="/api/purchase-orders")
public class PurchaseOrderController {
    @Autowired
    PurchaseOrderService purchaseOrderService;

    @PostMapping
    public ResponseEntity<PurchaseOrder> addPurchaseOrder(@RequestBody PurchaseOrder purchaseOrder){
       PurchaseOrder p=purchaseOrderService.addPurchaseOrder(purchaseOrder);
      
        return new ResponseEntity<PurchaseOrder>(p,HttpStatus.CREATED);
      
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        List<PurchaseOrder> p=purchaseOrderService.getAllPurchaseOrders();
        
            return new ResponseEntity<List<PurchaseOrder>>(p,HttpStatus.OK);
     
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable long id){
        PurchaseOrder p=purchaseOrderService.getPurchaseOrderById(id);
        
            return new ResponseEntity<PurchaseOrder>(p,HttpStatus.OK);
       
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable long id,@RequestBody PurchaseOrder purchaseOrder ){
        PurchaseOrder p=purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
       
            return new ResponseEntity<PurchaseOrder>(p,HttpStatus.OK);
       
    }

}

