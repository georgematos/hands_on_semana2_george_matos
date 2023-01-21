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
public class CustomerEntity {
    @Id
    private UUID id;
    private String name;
    private Character gender;
    private String identity;
    private LocalDateTime birthDate;
    private Short frequencyByMonth;
    private String phone;
    private AddressEntity addressEntity;
}
