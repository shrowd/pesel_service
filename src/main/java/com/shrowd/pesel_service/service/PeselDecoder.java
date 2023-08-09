package com.shrowd.pesel_service.service;

import com.shrowd.pesel_service.core.Gender;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PeselDecoder {
    public LocalDate extractBirthDate(String pesel) {
        int year = Integer.parseInt(pesel.substring(0, 2));
        int month = Integer.parseInt(pesel.substring(2, 4));
        int day = Integer.parseInt(pesel.substring(4, 6));

        int century = Integer.parseInt(pesel.substring(2, 3));

        switch (century) {
            case 8, 9 -> {
                month -= 80;
                year += 1800;
            }
            case 0, 1 -> year += 1900;
            case 2, 3 -> {
                month -= 20;
                year += 2000;
            }
            case 4, 5 -> {
                month -= 40;
                year += 2100;
            }
            case 6, 7 -> {
                month -= 60;
                year += 2200;
            }
        }
        return LocalDate.of(year, month, day);
    }

    public Gender extractGender(String pesel) {
        int temp = Integer.parseInt(pesel.substring(10, 11));
        return (temp % 2) == 0 ? Gender.FEMALE : Gender.MALE;
    }
}
