package com.examly.springapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.examly.springapp.model.PurchaseOrderItem;

@Repository
public interface PurchaseOrderItemRepo extends JpaRepository<PurchaseOrderItem,Long>{
    List<PurchaseOrderItem>
findByPurchaseOrder_PurchaseOrderId(Long orderId);

}
