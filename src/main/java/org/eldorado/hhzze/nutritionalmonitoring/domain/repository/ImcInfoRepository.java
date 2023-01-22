package org.eldorado.hhzze.nutritionalmonitoring.domain.repository;

import org.eldorado.hhzze.nutritionalmonitoring.domain.model.ImcInfoEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface ImcInfoRepository extends MongoRepository<ImcInfoEntity, UUID> {
}
