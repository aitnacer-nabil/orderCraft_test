package com.artjpa.service;

import com.artjpa.entities.Inventory;

import java.util.List;

public interface IInventoryService {
    Inventory saveInventory(Inventory inventory);

    Inventory getInventoryById(long inventoryId);

    List<Inventory> getAllInventories();

    void deleteInventory(long inventoryId);

}
