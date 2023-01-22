package org.eldorado.hhzze.nutritionalmonitoring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eldorado.hhzze.nutritionalmonitoring.domain.model.ImcInfoEntity;
import org.eldorado.hhzze.nutritionalmonitoring.domain.model.MeasurementEntity;
import org.eldorado.hhzze.nutritionalmonitoring.domain.repository.MeasurementRepository;
import org.eldorado.hhzze.nutritionalmonitoring.dto.MeasurementDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public MeasurementDto saveMeasurement(MeasurementDto measurementDto) {
        var measurementEntity = modelMapper.map(measurementDto, MeasurementEntity.class);
        measurementEntity.setMeasurementDate(LocalDateTime.now());
        var entitySaved = measurementRepository.save(measurementEntity);
        measurementDto.setId(entitySaved.getId());
        return measurementDto;
    }

    public List<MeasurementDto> getMeasurements() {
        var measurementEntities = measurementRepository.findAll();

        return measurementEntities.stream().map(measurements -> modelMapper.map(measurements, MeasurementDto.class))
                .toList();
    }

    public List<MeasurementDto> getMeasurementsByCustomerId(UUID customerId) {
        var measurementEntities = measurementRepository.findMeasurementEntitiesByCustomerId(customerId);

        return measurementEntities.stream().map(measurements -> modelMapper.map(measurements, MeasurementDto.class))
                .toList();
    }

    public MeasurementDto getMeasurementById(UUID measurementID) {
        var measurementEntity = measurementRepository.findById(measurementID).orElseThrow();
        return modelMapper.map(measurementEntity, MeasurementDto.class);
    }

    public MeasurementDto updateMeasurement(UUID measurementID, MeasurementDto measurementDto) {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        var measurementEntity = measurementRepository.findById(measurementID).orElseThrow();
        modelMapper.map(measurementDto, measurementEntity);
        var measurementSaved = measurementRepository.save(measurementEntity);

        return modelMapper.map(measurementSaved, MeasurementDto.class);
    }

    public void deleteMeasurement(UUID measurementID) {
        measurementRepository.deleteById(measurementID);
    }
}
