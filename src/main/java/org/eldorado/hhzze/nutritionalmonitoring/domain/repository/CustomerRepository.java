package org.eldorado.hhzze.nutritionalmonitoring.domain.repository;

import org.eldorado.hhzze.nutritionalmonitoring.domain.model.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface CustomerRepository extends MongoRepository<CustomerEntity, UUID> {
}
