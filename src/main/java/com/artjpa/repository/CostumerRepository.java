package com.artjpa.repository;

import com.artjpa.entities.Costumer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends CrudRepository<Costumer, Long> {
}
