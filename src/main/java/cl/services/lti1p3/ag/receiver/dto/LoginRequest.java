package cl.services.lti1p3.ag.receiver.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public record LoginRequest(
        @Email
        String email,
        @NotBlank
        String password) {
}


 