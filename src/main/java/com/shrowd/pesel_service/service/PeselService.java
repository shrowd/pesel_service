package com.shrowd.pesel_service.service;

import com.shrowd.pesel_service.core.Pesel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PeselService {
    private final PeselDecoder peselDecoder;
    private final PeselValidator peselValidator;

    public Pesel getDataFromPesel(Pesel pesel) {
        String strPesel = pesel.getPesel();
        peselValidator.isValid(strPesel);
        pesel.setBirthDate(peselDecoder.extractBirthDate(strPesel));
        pesel.setGender(peselDecoder.extractGender(strPesel));
        return pesel;
    }
}
