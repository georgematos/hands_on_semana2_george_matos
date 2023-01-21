package org.eldorado.hhzze.nutritionalmonitoring.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Document("nutritional-monitoring")
public class MeasurementEntity {
    @Id
    private UUID id;
    private UUID customerEntityId;
    private Float weight;
    private Float height;
    private LocalDateTime measurementDate;
}
