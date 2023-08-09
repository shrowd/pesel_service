package com.shrowd.pesel_service.service;

import com.shrowd.pesel_service.exception.PeselException;
import org.springframework.stereotype.Service;

@Service
public class PeselValidator {
    private void validatePeselNotEmptyOrNull(String pesel) {
        if (pesel == null || pesel.isBlank()) {
            throw new IllegalArgumentException("Pesel cannot be null or empty");
        }
    }

    private void validatePeselLength(String pesel) {
        if (!(pesel.length() == 11)) {
            throw new PeselException("Pesel should have 11 digits");
        }
    }

    private void validatePeselType(String pesel) {
        if (!(pesel.matches("^[0-9]+$"))) {
            throw new PeselException("Pesel should contains only digits");
        }
    }
    private void validatePeselChecksum(String pesel) {

        int[] tab = new int[10];
        int[] weights = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};
        int sum = 0;
        int trueSum = 10;

        for (int i = 0; i < 10; i++) {
            int temp = Integer.parseInt(pesel.substring(i, i + 1));
            tab[i] = (temp * weights[i]) % 10;
            sum += tab[i];
        }

        sum = sum % 10;
        trueSum -= sum;
        int controlDigitFromPesel = Integer.parseInt(pesel.substring(10, 11));

        if (!(trueSum == controlDigitFromPesel)) {
            throw new PeselException("Pesel has incorrect control digit");
        }
    }
    public final void isValid(String pesel) {
        validatePeselNotEmptyOrNull(pesel);
        validatePeselLength(pesel);
        validatePeselType(pesel);
        validatePeselChecksum(pesel);
    }
}
