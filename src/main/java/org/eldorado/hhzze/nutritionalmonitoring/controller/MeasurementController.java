package org.eldorado.hhzze.nutritionalmonitoring.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eldorado.hhzze.nutritionalmonitoring.dto.MeasurementDto;
import org.eldorado.hhzze.nutritionalmonitoring.service.MeasurementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/nutritional-monitoring/measurement")
public class MeasurementController {
    private final MeasurementService measurementService;

    @PostMapping
    public ResponseEntity<MeasurementDto> saveMeasurement(@RequestBody MeasurementDto measurementDto) {
        measurementDto.setId(UUID.randomUUID());

        log.info("The measurement info: {}", measurementDto);
        return ResponseEntity.ok(measurementService.saveMeasurement(measurementDto));
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDto>> getMeasurementList() {
        log.info("GET MEASUREMENT LIST");
        return ResponseEntity.ok(measurementService.getMeasurements());
    }

    @GetMapping("/{measurementID}")
    public ResponseEntity<MeasurementDto> getMeasurementByID(@PathVariable UUID measurementID) {
        log.warn("GET MEASUREMENT BY ID {}", measurementID);
        return ResponseEntity.ok(measurementService.getMeasurementById(measurementID));
    }

    @GetMapping("/customer/{customerID}")
    public ResponseEntity<List<MeasurementDto>> getMeasurementByCustomerID(@PathVariable UUID customerID) {
        log.warn("GET MEASUREMENT BY CUSTOMER ID {}", customerID);
        return ResponseEntity.ok(measurementService.getMeasurementsByCustomerId(customerID));
    }

    @PutMapping("/{measurementID}")
    public ResponseEntity<MeasurementDto> updateMeasurement(@PathVariable UUID measurementID,
                                                            @RequestBody MeasurementDto measurementDto) {
        log.info("UPDATE MEASUREMENT {}", measurementID);
        var savedmeasurementDto = measurementService.updateMeasurement(measurementID, measurementDto);
        return ResponseEntity.ok(savedmeasurementDto);
    }

    @DeleteMapping("/{measurementID}")
    public void deleteMeasurement(@PathVariable UUID measurementID) {
        log.info("DELETE MEASUREMENT BY ID {} ", measurementID);
        measurementService.deleteMeasurement(measurementID);
    }
}
