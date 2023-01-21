package org.eldorado.hhzze.nutritionalmonitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MeasurementDto {
    private UUID id;
    private Float weight;
    private Float height;
    private LocalDateTime measurementDate;
}
