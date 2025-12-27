package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.BadRequestException;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.PurchaseOrder;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.PurchaseOrderRepo;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private PurchaseOrderRepo purchaseOrderRepo;

    @Autowired
    private SupplierRepo supplierRepo;

    // Add PurchaseOrder
    @Override
    public PurchaseOrder addPurchaseOrder(PurchaseOrder purchaseOrder) {

        if (purchaseOrder == null || purchaseOrder.getSupplier() == null ||
            purchaseOrder.getSupplier().getSupplierId() == null) {
            throw new BadRequestException("Supplier ID must be provided");
        }

        Long sId = purchaseOrder.getSupplier().getSupplierId();

        Supplier supplier = supplierRepo.findById(sId)
            .orElseThrow(() ->
                new ResourceNotFoundException("Supplier not found with id: " + sId)
            );

        purchaseOrder.setSupplier(supplier);

        return purchaseOrderRepo.save(purchaseOrder);
    }

    // Get all PurchaseOrders
    @Override
    public List<PurchaseOrder> getAllPurchaseOrders() {
        return purchaseOrderRepo.findAll();
    }

    // Get PurchaseOrder by ID
    @Override
    public PurchaseOrder getPurchaseOrderById(Long id) {
        return purchaseOrderRepo.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("PurchaseOrder not found with id: " + id)
            );
    }

    // Update PurchaseOrder
    @Override
    public PurchaseOrder updatePurchaseOrder(Long id, PurchaseOrder newPurchaseOrder) {

        PurchaseOrder existing = purchaseOrderRepo.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("PurchaseOrder not found with id: " + id)
            );

        existing.setOrderNumber(newPurchaseOrder.getOrderNumber());
        existing.setOrderDate(newPurchaseOrder.getOrderDate());
        existing.setStatus(newPurchaseOrder.getStatus());

        if (newPurchaseOrder.getSupplier() != null &&
            newPurchaseOrder.getSupplier().getSupplierId() != null) {

            Long sId = newPurchaseOrder.getSupplier().getSupplierId();

            Supplier supplier = supplierRepo.findById(sId)
                .orElseThrow(() ->
                    new ResourceNotFoundException("Supplier not found with id: " + sId)
                );

            existing.setSupplier(supplier);
        }

        return purchaseOrderRepo.save(existing);
    }
}

