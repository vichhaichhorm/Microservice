package com.microservice.inventory_service.repository;

import com.microservice.inventory_service.modal.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory ,Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
