package com.artjpa.service.impl;

import com.artjpa.entities.Costumer;
import com.artjpa.entities.User;
import com.artjpa.repository.CostumerRepository;
import com.artjpa.service.ICostumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CostumerServiceImpl implements ICostumerService {
    private CostumerRepository costumerRepository;

    @Autowired
    public CostumerServiceImpl(CostumerRepository costumerRepository) {
        this.costumerRepository = costumerRepository;
    }

    @Override
    public Costumer addCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }

    @Override
    public Costumer updateCostumer(Costumer costumer) throws Throwable {
        isExitsOrThrowExcp(costumer.getId());
        return costumerRepository.save(costumer);
    }

    @Override
    public void deleteCostumerById(Long id) throws Throwable {
        isExitsOrThrowExcp(id);
        costumerRepository.deleteById(id);
    }

    @Override
    public List<Costumer> getAllCostumers() {
        return (List<Costumer>) costumerRepository.findAll();
    }

    @Override
    public Optional<Costumer> getCostumerById(Long id) {
        return costumerRepository.findById(id);
    }

    private void isExitsOrThrowExcp(Long id) throws Throwable {
        if (!costumerRepository.existsById(id)) throw new Throwable("Not Costumer fond with this id " + id);

    }
}
