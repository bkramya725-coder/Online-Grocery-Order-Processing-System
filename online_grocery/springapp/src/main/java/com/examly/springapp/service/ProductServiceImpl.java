package com.examly.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.examly.springapp.exception.ResourceNotFoundException;
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
        return productRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Product is not found with respective id.."));

    }

    @Override
public Product updateProduct(Long id, Product newProduct) {

    Product existingProduct = productRepo.findById(id)
        .orElseThrow(() ->
            new ResourceNotFoundException(
                "Product not found with id: " + id
            )
        );

    existingProduct.setProductName(newProduct.getProductName());
    existingProduct.setDescription(newProduct.getDescription());
    existingProduct.setPrice(newProduct.getPrice());
    existingProduct.setStockQuantity(newProduct.getStockQuantity());

    return productRepo.save(existingProduct);
}


   @Override
public void deleteById(Long id) {

    Product product = productRepo.findById(id)
        .orElseThrow(() ->
            new ResourceNotFoundException(
                "Product not found with id: " + id
            )
        );

    productRepo.delete(product);
}

    
}

