package com.artjpa.service;

import com.artjpa.entities.Costumer;

import java.util.List;
import java.util.Optional;

public interface ICostumerService {

     Costumer addCostumer(Costumer costumer) ;

    Costumer updateCostumer(Costumer costumer) throws Throwable;
    void deleteCostumerById(Long id) throws Throwable;
    List<Costumer> getAllCostumers();
    Optional<Costumer> getCostumerById(Long id);

}
