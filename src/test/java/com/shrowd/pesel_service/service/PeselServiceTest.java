package com.shrowd.pesel_service.service;

import com.shrowd.pesel_service.core.Pesel;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static com.shrowd.pesel_service.core.Gender.FEMALE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RequiredArgsConstructor
class PeselServiceTest {

    private PeselService peselService;

    @Mock
    private PeselDecoder peselDecoder;

    @Mock
    private PeselValidator peselValidator;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        peselService = new PeselService(peselDecoder, peselValidator);
    }

    @Test
    @DisplayName("Should set correct birth date and gender for valid pesel")
    void shouldSetCorrectData() {
        //given
        Pesel pesel = new Pesel("06270131521");
        doNothing().when(peselValidator).isValid(anyString());
        when(peselDecoder.extractBirthDate(anyString())).thenReturn(LocalDate.of(2006, 7, 1));
        when(peselDecoder.extractGender(anyString())).thenReturn(FEMALE);

        //when
        Pesel result = peselService.getDataFromPesel(pesel);

        //then
        assertEquals(LocalDate.of(2006, 7, 1), result.getBirthDate());
        assertEquals(FEMALE, result.getGender());
    }
}