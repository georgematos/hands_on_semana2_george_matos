package org.eldorado.hhzze.nutritionalmonitoring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eldorado.hhzze.nutritionalmonitoring.domain.model.ImcInfoEntity;
import org.eldorado.hhzze.nutritionalmonitoring.dto.ImcInfoDto;
import org.eldorado.hhzze.nutritionalmonitoring.dto.MeasurementDto;
import org.eldorado.hhzze.nutritionalmonitoring.service.ImcInfoService;
import org.eldorado.hhzze.nutritionalmonitoring.service.MeasurementService;
import org.eldorado.hhzze.nutritionalmonitoring.utils.ImcCalculator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nutritional-monitoring/imc")
public class ImcController {

    public final ImcInfoService imcInfoService;
    public final MeasurementService measurementService;

    @PutMapping
    public ResponseEntity<ImcInfoDto> updateImc(@PathVariable UUID customerId, @RequestBody ImcInfoDto imcInfoDto) {
        var savedImcInfoDto = imcInfoService.updateImcInfo(customerId, imcInfoDto);
        return ResponseEntity.ok(savedImcInfoDto);
    }

    @GetMapping("/{customerID}")
    public ResponseEntity<ImcInfoDto> calculateImc(@PathVariable UUID customerID) {
        var imcCalculator = new ImcCalculator();
        var measure = measurementService.getMeasurementsByCustomerId(customerID);
        var lastMeasure = measure.stream().filter(x -> x.getMeasurementDate() != null)
                .max(Comparator.comparing(MeasurementDto::getMeasurementDate))
                .orElseThrow();

        float bodyMass = imcCalculator.calculateImc(lastMeasure);
        String classification = imcCalculator.getClassification(bodyMass);
        String obesityLevel = imcCalculator.getObesityLevel(classification);

        var imcInfoDto = ImcInfoDto.builder()
                .id(UUID.randomUUID())
                .bodyMass(bodyMass)
                .customerId(customerID)
                .classification(classification)
                .obesityLevel(obesityLevel)
                .build();

        var savedImcInfoDto =imcInfoService.saveImcInfo(imcInfoDto);

        return ResponseEntity.ok(savedImcInfoDto);
    }

}
