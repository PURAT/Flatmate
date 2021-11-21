package com.company.flatmate.security.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * Преполагается что форма регистрации будет иметь больше полей
 * чем форма авторизации.
 */

@Data
public class RegistrationRequest {

    @NotBlank
    @Size(min = 3, max = 20)
    private String login;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;
}
