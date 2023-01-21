package org.eldorado.hhzze.nutritionalmonitoring.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AddressDto {
    private String street;
    private Short number;
    private String city;
    private String province;
    private String country;
    private String countryAcronym;
}
