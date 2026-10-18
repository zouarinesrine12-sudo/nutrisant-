package com.acme.shop.user.dto;

import jakarta.validation.constraints.*;
import java.util.Objects;

public record CreateUserRequest(
        @NotBlank String firstName,
        @NotBlank String lastName,
        @NotBlank @Email String email,
        @NotBlank String phoneNumber,
        @NotBlank
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*&]).{8,}$",
                message = "8 caractères minimum, avec majuscule, minuscule, chiffre et un des signes @$!%*&")
        String password,
        @NotBlank String confirmPassword,
        String address
) {
    @AssertTrue(message = "Les mots de passe ne correspondent pas")
    public boolean isPasswordConfirmed() {
        return Objects.equals(password, confirmPassword);
    }

}