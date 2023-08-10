package com.shrowd.pesel_service.service;

import com.shrowd.pesel_service.core.Gender;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static com.shrowd.pesel_service.core.Gender.FEMALE;
import static com.shrowd.pesel_service.core.Gender.MALE;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RequiredArgsConstructor
class PeselDecoderTest {

    private PeselDecoder peselDecoder;

    @BeforeEach
    void setUp() {
        peselDecoder = new PeselDecoder();
    }

    @ParameterizedTest
    @MethodSource("peselAndDate")
    @DisplayName("shouldReturnCorrectDate")
    void shouldReturnCorrectDate(String pesel, LocalDate birthDate) {
        //when
        LocalDate birth = peselDecoder.extractBirthDate(pesel);

        //then
        assertEquals(birthDate, birth);
    }

    @ParameterizedTest
    @MethodSource("peselAndGender")
    @DisplayName("shouldReturnGender")
    void shouldReturnCorrectGender(String pesel, Gender gender) {
        //when
        Gender gen = peselDecoder.extractGender(pesel);

        //then
        assertEquals(gender, gen);
    }

    public static Stream<Arguments> peselAndDate() {
        return Stream.of(
                Arguments.of("06270131521", LocalDate.of(2006, 7, 1)),
                Arguments.of("92052092359", LocalDate.of(1992, 5, 20)),
                Arguments.of("60841265756", LocalDate.of(1860, 4, 12)),
                Arguments.of("52523094868", LocalDate.of(2152, 12, 30)),
                Arguments.of("69703094839", LocalDate.of(2269, 10, 30))
        );
    }

    public static Stream<Arguments> peselAndGender() {
        return Stream.of(
                Arguments.of("06270131521", FEMALE),
                Arguments.of("92052092359", MALE),
                Arguments.of("60841265756", MALE),
                Arguments.of("52523094868", FEMALE),
                Arguments.of("69703094839", MALE)
        );
    }
}