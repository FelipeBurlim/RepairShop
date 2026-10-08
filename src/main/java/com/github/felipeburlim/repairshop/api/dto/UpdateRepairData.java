package com.github.felipeburlim.repairshop.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UpdateRepairData(
        @NotNull
        Long id,

        @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}")
        String exitDate,

        String mechanicName,

        Integer mechanicYearsOfExperience
) {}