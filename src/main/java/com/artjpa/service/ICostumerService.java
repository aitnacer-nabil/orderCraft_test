package com.artjpa.service;

import com.artjpa.entities.Costumer;

import java.util.List;
import java.util.Optional;

public interface ICostumerService {

     Costumer addCostumer(Costumer costumer) ;

    Costumer updateCostumer(long id,Costumer costumer) throws Throwable;
    void deleteCostumerById(long id) throws Throwable;
    List<Costumer> getAllCostumers();
    Optional<Costumer> getCostumerById(long id);

}
