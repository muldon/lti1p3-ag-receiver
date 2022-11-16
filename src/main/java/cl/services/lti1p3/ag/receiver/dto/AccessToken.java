package cl.services.lti1p3.ag.receiver.dto;

import javax.validation.constraints.NotBlank;


//IMS definition here: https://www.imsglobal.org/spec/security/v1p1#using-json-web-tokens-with-oauth-2-0-client-credentials-grant
public record AccessToken(
		@NotBlank
        String access_token,
        @NotBlank
        String token_type,
        @NotBlank
        Long expires_in,
        @NotBlank
        String scope        
		) {
}

 