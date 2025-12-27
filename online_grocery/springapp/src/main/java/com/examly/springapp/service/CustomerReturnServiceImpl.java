package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.repository.CustomerReturnRepo;

@Service
public class CustomerReturnServiceImpl implements CustomerReturnService{
    @Autowired
    CustomerReturnRepo customerReturnRepo;
    @Override
    public CustomerReturn addCustomerReturn(CustomerReturn cust) {
       return customerReturnRepo.save(cust);
    }

    @Override
    public List<CustomerReturn> getAllCustomerReturns() {
        return customerReturnRepo.findAll();
    }

    @Override
    public CustomerReturn getCustomerReturnById(Long id) {
        return customerReturnRepo.findById(id).orElse(null);
    }
    
}
