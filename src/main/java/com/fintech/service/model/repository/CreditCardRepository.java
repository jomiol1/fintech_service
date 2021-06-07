package com.fintech.service.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fintech.service.model.entity.CreditCardEntity;

@Repository
public interface CreditCardRepository extends CrudRepository<CreditCardEntity, Long>{


}
