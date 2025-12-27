package com.examly.springapp.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.PurchaseOrderRepo;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService{
      
    @Autowired
    PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    SupplierRepo supplierRepo;


    @Override
    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {
         
         Long sId=purchaseOrder.getSupplier().getSupplierId();
         Supplier s=supplierRepo.findById(sId).orElse(null);
         purchaseOrder.setSupplier(s);
         return purchaseOrderRepo.save(purchaseOrder);
        
    }

    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
       return purchaseOrderRepo.findAll();
    }

    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
       return purchaseOrderRepo.findById(id).orElse(null);
    }

    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder newPurchaseOrder) {
      
       PurchaseOrder existing=purchaseOrderRepo.findById(id).orElse(null);
       
       if(existing==null){
         return null;
       }
         
        existing.setOrderNumber(newPurchaseOrder.getOrderNumber());
        existing.setOrderDate(newPurchaseOrder.getOrderDate());
        existing.setStatus(newPurchaseOrder.getStatus());
        Long sId=newPurchaseOrder.getSupplier().getSupplierId();
        Supplier s=supplierRepo.findById(sId).orElse(null);
         if(s!=null){
            existing.setSupplier(s);
         }
        return purchaseOrderRepo.save(existing);
       
      }
}
