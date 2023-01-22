package org.eldorado.hhzze.nutritionalmonitoring.utils;

import org.eldorado.hhzze.nutritionalmonitoring.dto.MeasurementDto;

public class ImcCalculator {

    public String getClassification(double imc) {

        if (imc < 18.5) {
            return "Magresa";
        } else if (imc < 25) {
            return "Normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else if (imc < 40) {
            return "Obesidade";
        } else {
            return "Obesidade";
        }
    }

    public String getObesityLevel(String classification) {

        String nivelObsidade;

        switch (classification) {
            case "Magresa":
                nivelObsidade = "0";
                break;
            case "Normal":
                nivelObsidade = "0";
                break;
            case "Sobrepeso":
                nivelObsidade = "I";
                break;
            case "Obesidade":
                nivelObsidade = "II";
                break;

            default:
                nivelObsidade = "III";
        }

        return nivelObsidade;

    }

    public float calculateImc(MeasurementDto measurementDto) {
        return measurementDto.getWeight() / (measurementDto.getHeight() * 2);
    }

}
