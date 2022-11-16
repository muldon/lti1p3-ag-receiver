package cl.services.lti1p3.ag.receiver.dto;

import javax.validation.constraints.NotBlank;

//IMS definition here: https://www.imsglobal.org/spec/security/v1p1#using-json-web-tokens-with-oauth-2-0-client-credentials-grant
public record AuthRequest(
		@NotBlank
        String grant_type,
        @NotBlank
        String client_assertion_type,
        @NotBlank
        String client_assertion,   //the Consumer's generated JWT (tool)
        @NotBlank
        String scope        
		) {
}

 