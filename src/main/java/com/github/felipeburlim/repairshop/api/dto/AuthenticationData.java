package com.github.felipeburlim.repairshop.api.dto;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationData(
        @NotBlank String login,
        @NotBlank String password
) {
}
