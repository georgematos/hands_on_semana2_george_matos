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
public class CustomerDto {
    private UUID id;
    private String name;
    private Character gender;
    private String identity;
    private LocalDateTime birthDate;
    private Short frequencyByMonth;
    private String phone;
    private AddressDto address;
}
