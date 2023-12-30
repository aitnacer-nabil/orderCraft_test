package com.artjpa.repository;

import com.artjpa.entities.Costumer;
import org.springframework.data.repository.CrudRepository;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {
}
