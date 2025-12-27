package com.examly.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    @Override
    public Supplier addSupplier(Supplier supplier) {
        return supplierRepo.save(supplier);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepo.findById(id).orElse(null);
    }

    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {
        Supplier existing = supplierRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setSupplierName(supplier.getSupplierName());
        existing.setContactNumber(supplier.getContactNumber());
        existing.setEmail(supplier.getEmail());
        existing.setAddress(supplier.getAddress());

        return supplierRepo.save(existing);
    }
}
