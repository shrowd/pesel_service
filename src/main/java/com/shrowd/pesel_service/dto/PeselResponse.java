package com.shrowd.pesel_service.dto;

import com.shrowd.pesel_service.core.Gender;

import java.time.LocalDate;

public record PeselResponse(LocalDate birthDate, Gender gender) {
}
