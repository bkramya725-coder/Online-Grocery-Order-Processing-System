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

import com.examly.springapp.model.CustomerReturn;
import com.examly.springapp.service.CustomerReturnService;

@RestController
@RequestMapping(path="/api/customer-returns")
public class CustomerReturnController {
    @Autowired
    CustomerReturnService customerReturnService;

    @PostMapping
    public ResponseEntity<CustomerReturn> addCustomerReturn(@RequestBody CustomerReturn cust){
      CustomerReturn c =customerReturnService.addCustomerReturn(cust);
      if(c==null){
        return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
      }
      return new ResponseEntity<CustomerReturn>(c,HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<CustomerReturn>> getAllCustomerReturns(){
        List<CustomerReturn> c=customerReturnService.getAllCustomerReturns();
        if(!c.isEmpty()){
            return new ResponseEntity<List<CustomerReturn>>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CustomerReturn> getCustomerReturnById(@PathVariable Long id){
      CustomerReturn c=customerReturnService.getCustomerReturnById(id);
      if(c!=null){
        return new ResponseEntity<CustomerReturn>(c,HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
