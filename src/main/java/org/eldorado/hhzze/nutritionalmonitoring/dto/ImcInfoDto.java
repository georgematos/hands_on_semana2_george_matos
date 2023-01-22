package org.eldorado.hhzze.nutritionalmonitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ImcInfoDto {
    private UUID id;
    private UUID customerId;
    private Float bodyMass;
    private String classification;
    private String obesityLevel;
}
