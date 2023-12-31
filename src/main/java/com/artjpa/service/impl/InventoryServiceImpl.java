package com.artjpa.service.impl;

import com.artjpa.entities.Inventory;
import com.artjpa.repository.InventoryRepository;
import com.artjpa.service.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements IInventoryService {
    InventoryRepository inventoryRepository;
    @Autowired
    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public Inventory saveInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    @Override
    public Inventory getInventoryById(long inventoryId) {
        return inventoryRepository.findById(inventoryId).orElse(null);
    }

    @Override
    public List<Inventory> getAllInventories() {
        return (List<Inventory>) inventoryRepository.findAll();
    }

    @Override
    public void deleteInventory(long inventoryId) {
        inventoryRepository.deleteById(inventoryId);

    }

}
