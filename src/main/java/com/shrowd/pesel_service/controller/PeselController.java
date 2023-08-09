package com.shrowd.pesel_service.controller;

import com.shrowd.pesel_service.dto.PeselRequest;
import com.shrowd.pesel_service.dto.PeselResponse;
import com.shrowd.pesel_service.mapper.PeselMapper;
import com.shrowd.pesel_service.service.PeselService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class PeselController {
    private final PeselMapper peselMapper;
    private final PeselService peselService;

    @PostMapping("pesel")
    public PeselResponse dataFromPesel(@RequestBody PeselRequest peselRequest) {
        return peselMapper.mapToPeselResponse(peselService.getDataFromPesel(peselMapper.mapToPesel(peselRequest)));
    }
}
