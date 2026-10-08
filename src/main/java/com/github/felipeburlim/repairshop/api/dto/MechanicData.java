package com.github.felipeburlim.repairshop.api.dto;

import jakarta.validation.constraints.NotBlank;

public record MechanicData(
        @NotBlank
        String name,

        Integer yearsOfExperience
) {}