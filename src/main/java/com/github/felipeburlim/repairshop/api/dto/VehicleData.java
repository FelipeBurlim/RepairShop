package com.github.felipeburlim.repairshop.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record VehicleData(
        @NotBlank
        String make,

        @NotBlank
        String model,

        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String year,

        String color
) {}