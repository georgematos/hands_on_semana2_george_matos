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
@Document("imc-info-document")
public class ImcInfoEntity {
    @Id
    private UUID id;
    private UUID customerId;
    private Float bodyMass;
    private String classification;
    private String obesityLevel;
}
