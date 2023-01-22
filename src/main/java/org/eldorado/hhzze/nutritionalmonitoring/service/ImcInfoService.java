package org.eldorado.hhzze.nutritionalmonitoring.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eldorado.hhzze.nutritionalmonitoring.domain.model.ImcInfoEntity;
import org.eldorado.hhzze.nutritionalmonitoring.domain.repository.ImcInfoRepository;
import org.eldorado.hhzze.nutritionalmonitoring.dto.ImcInfoDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class ImcInfoService {
    private final ImcInfoRepository imcInfoRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    public ImcInfoDto updateImcInfo(UUID customerId, ImcInfoDto imcInfoDto) {
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        var imcInfoEntity = imcInfoRepository.findById(customerId).orElseThrow();
        modelMapper.map(imcInfoDto, imcInfoEntity);

        var imcInfoSaved = imcInfoRepository.save(imcInfoEntity);

        return modelMapper.map(imcInfoSaved, ImcInfoDto.class);
    }

    public ImcInfoDto saveImcInfo(ImcInfoDto imcInfoDto) {
        var imcInfoEntity = modelMapper.map(imcInfoDto, ImcInfoEntity.class);

        var imcInfoSaved = imcInfoRepository.save(imcInfoEntity);

        return modelMapper.map(imcInfoSaved, ImcInfoDto.class);
    }

    public ImcInfoDto getCustomerImc(UUID customerId) {
        var imcInfoEntity = imcInfoRepository.findById(customerId);
        return modelMapper.map(imcInfoEntity, ImcInfoDto.class);
    }
}
