package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Product;
import com.examly.springapp.service.ProductService;

@RestController
@RequestMapping(path="/api/products")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products= productService.getAllProducts();
        
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product p= productService.getProductById(id);
        if(p!=null){
            return ResponseEntity.ok(p);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product p= productService.addProduct(product);
        if(p!=null){
            return new ResponseEntity<Product>(p,HttpStatus.CREATED);
        }
        return null;
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,@RequestBody Product product){
         Product p= productService.updateProduct(id, product);
         if(p!=null){
            return new ResponseEntity<Product>(p,HttpStatus.OK);
         }
         return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
         productService.deleteById(id);
    }
    
   
}
