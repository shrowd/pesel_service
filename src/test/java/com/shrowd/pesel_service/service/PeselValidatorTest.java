package com.shrowd.pesel_service.service;

import com.shrowd.pesel_service.exception.PeselException;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

@RequiredArgsConstructor
class PeselValidatorTest {
    private PeselValidator peselValidator;

    @BeforeEach
    void setUp() {
        peselValidator = new PeselValidator();
    }

    @Test
    @DisplayName("Should throw illegal argument exception when pesel is null")
    void shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> peselValidator.isValid(null));
        assertThrows(IllegalArgumentException.class, () -> peselValidator.isValid(""));
    }

    @Test
    @DisplayName("Should return pesel exception when pesel has invalid length, type or checksum")
    void shouldReturnPeselException(){
        assertThrows(PeselException.class, () -> peselValidator.isValid("062701315213232"));
        assertThrows(PeselException.class, () -> peselValidator.isValid("0627dd31521"));
        assertThrows(PeselException.class, () -> peselValidator.isValid("06270131529"));
    }

}