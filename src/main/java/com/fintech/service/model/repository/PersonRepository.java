package com.fintech.service.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fintech.service.model.entity.PersonEntity;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long>{

    public List<PersonEntity> findByActiveIsTrue();

    public Optional<PersonEntity> findById(Long id);
}
