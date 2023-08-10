package com.shrowd.pesel_service.core;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class Pesel {
    private String pesel;
    private LocalDate birthDate;
    private Gender gender;

    public Pesel(String pesel){
        this.pesel = pesel;
    }
}
