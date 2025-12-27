package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.model.Product;
import com.examly.springapp.repository.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{
     @Autowired
     ProductRepo productRepo;
    @Override
    public Product addProduct(Product product) {
        return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
      return productRepo.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepo.findById(id).orElse(null);

    }

    @Override
    public Product updateProduct(Long id, Product newProduct) {
       if(!productRepo.existsById(id)){
        return null;
       }
       Product existingProduct=productRepo.findById(id).orElse(null);
       if(existingProduct!=null){
        existingProduct.setProductName(newProduct.getProductName());
                existingProduct.setDescription(newProduct.getDescription());
                existingProduct.setPrice(newProduct.getPrice());
                existingProduct.setStockQuantity(newProduct.getStockQuantity());
        
                return productRepo.save(existingProduct);
       }
       return null;
    }

    @Override
    public void deleteById(Long id){
        if(productRepo.existsById(id)){
            
        
        productRepo.deleteById(id);
        }
    }
    
}
