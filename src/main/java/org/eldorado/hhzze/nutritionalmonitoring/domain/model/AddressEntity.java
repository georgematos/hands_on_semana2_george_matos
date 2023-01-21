package org.eldorado.hhzze.nutritionalmonitoring.domain.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
@Document("nutritional-monitoring")
public class AddressEntity {
    private String street;
    private Short number;
    private String city;
    private String province;
    private String country;
    private String countryAcronym;
}
