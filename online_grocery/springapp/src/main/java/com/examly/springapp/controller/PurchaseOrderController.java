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
       if(p!=null){
        return new ResponseEntity<PurchaseOrder>(p,HttpStatus.CREATED);
       }
       return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping
    public ResponseEntity<List<PurchaseOrder>> getAllPurchaseOrders(){
        List<PurchaseOrder> p=purchaseOrderService.getAllPurchaseOrders();
        if(p!=null){
            return new ResponseEntity<List<PurchaseOrder>>(p,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PurchaseOrder> getPurchaseOrderById(@PathVariable long id){
        PurchaseOrder p=purchaseOrderService.getPurchaseOrderById(id);
        if(p!=null){
            return new ResponseEntity<PurchaseOrder>(p,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<PurchaseOrder> updatePurchaseOrder(@PathVariable long id,@RequestBody PurchaseOrder purchaseOrder ){
        PurchaseOrder p=purchaseOrderService.updatePurchaseOrder(id, purchaseOrder);
        if(p!=null){
            return new ResponseEntity<PurchaseOrder>(p,HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

}
