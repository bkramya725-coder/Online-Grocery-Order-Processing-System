package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.BadRequestException;
import com.examly.springapp.exception.ResourceNotFoundException;
import com.examly.springapp.model.Supplier;
import com.examly.springapp.repository.SupplierRepo;

@Service
public class SupplierServiceImpl implements SupplierService {

    @Autowired
    private SupplierRepo supplierRepo;

    
    @Override
    public Supplier addSupplier(Supplier supplier) {
        if (supplier == null) {
            throw new BadRequestException("Supplier details must be provided");
        }
        return supplierRepo.save(supplier);
    }

 
    @Override
    public List<Supplier> getAllSuppliers() {
        return supplierRepo.findAll();
    }

   
    @Override
    public Supplier getSupplierById(Long id) {
        return supplierRepo.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Supplier not found with id: " + id)
            );
    }

    
    @Override
    public Supplier updateSupplier(Long id, Supplier supplier) {

        Supplier existing = supplierRepo.findById(id)
            .orElseThrow(() ->
                new ResourceNotFoundException("Supplier not found with id: " + id)
            );

        if (supplier == null) {
            throw new BadRequestException("Supplier details must be provided");
        }

        existing.setSupplierName(supplier.getSupplierName());
        existing.setContactNumber(supplier.getContactNumber());
        existing.setEmail(supplier.getEmail());
        existing.setAddress(supplier.getAddress());

        return supplierRepo.save(existing);
    }
}

