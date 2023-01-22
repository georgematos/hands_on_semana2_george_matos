package org.eldorado.hhzze.nutritionalmonitoring.domain.repository;

import org.eldorado.hhzze.nutritionalmonitoring.domain.model.MeasurementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface MeasurementRepository extends MongoRepository<MeasurementEntity, UUID> {
    public List<MeasurementEntity> findMeasurementEntitiesByCustomerId(UUID customerId);
}
