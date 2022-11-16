package cl.services.lti1p3.ag.receiver.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.text.ParseException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.JWT;

import cl.services.lti1p3.ag.receiver.dto.AccessToken;
import cl.services.lti1p3.ag.receiver.dto.AuthRequest;
import cl.services.lti1p3.ag.receiver.exception.LTI1p3Exception;
import cl.services.lti1p3.ag.receiver.utils.Lti13Utils;
import cl.services.lti1p3.ag.receiver.utils.LtiStrings;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;

@Service
public class AuthService {
	private final static Logger log =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);   
    
	private final JwtEncoder encoder;
    
    @Value("${authorizationserver.auth.token.url}")
    private String authorizationtTokenURL; //the aud
    
    private @Autowired 
    Environment environment;

    public String getPropertyValue(String runTimeFlower) {
        return environment.resolvePlaceholders("${" + runTimeFlower + "}");
    }
   
    public AuthService(JwtEncoder encoder) {
       this.encoder = encoder;
    }
 
    public AccessToken getToken(AuthRequest authRequest, String target) throws GeneralSecurityException, IOException, ParseException, JOSEException, LTI1p3Exception {
       
    	//get the tool JWKs URL. 
    	String JWKsUrl = getPropertyValue(target+".tool.jwks.url");
    	
    	//TODO reuse Lti13Utils of the launcher project instead of having a copy of this method
    	//The tool signs the JWT with the private key.
    	//The tool’s JWKS URL exposes all the public keys, including the one pairing the private key it just used.
    	//Our platform, when receiving the JWT, checks its kid, extracts the public key from the tool’s JWKS URL, and verifies the signature.
    	Jws<Claims> jwtClaims = Lti13Utils.parseJWT(JWKsUrl, authRequest.client_assertion());
    	
    	//validation rules
    	validateRequest(jwtClaims,target);
    	
    	
    	return createToken(authRequest);

     }
    
   
    //IMS specification: https://www.imsglobal.org/spec/security/v1p1#using-json-web-tokens-with-oauth-2-0-client-credentials-grant
    //The IMS is not clear on which side (consumer or platform) must follow these validation rules. Thus, we are guaranteeing they are followed on our side.
	private void validateRequest(Jws<Claims> jwtClaims, String target) throws LTI1p3Exception {
    	Claims claims = jwtClaims.getBody();
    	  
    	//1-The JWT payload MUST contain at least the following Claims: iss, sub, aud, iat, exp and jti
    	List<String> mustContainClaims = List.of(LtiStrings.LTI_ISS, LtiStrings.LTI_SUB, LtiStrings.LTI_AUD,LtiStrings.LTI_IAT,LtiStrings.LTI_EXP,LtiStrings.LTI_JTI);
    	checkMandatoryClaims(mustContainClaims,claims);
    	
    	/* 
    	 * 2-Aud
    	 * The aud Claim MUST contain a value that identifies the authorization server as an intended audience. 
    	 * The Consumer MAY use the token endpoint URL of the authorization server as a value for an aud element to identify the authorization server as an intended audience of the JWT. 
    	 * The authorization server MUST reject any JWT that does not contain its own identity as the intended audience. 
    	 * This information MUST be sent as an array even when there is only one value.
    	 */    	
    	var<?> audList = (ArrayList<?>)claims.get(LtiStrings.LTI_AUD);  //TODO reuse LtiStrings.java
    	boolean validAud = audList.stream().anyMatch(authorizationtTokenURL::equals);
    	if(!validAud) {
    		//TODO - reuse or maintain a copy ? 
    		throw new LTI1p3Exception("aud ("+audList+") does not contain the token endpoint: "+authorizationtTokenURL).log(2);
    	}
    	
    	 
    	
    	//3- let´s guarantee that we are not granting an access token for an expired message  
    	String expStr = String.format("%.0f", claims.get(LtiStrings.LTI_EXP));
    	//Instant expInstant = Instant.ofEpochSecond(Long.parseLong(expStr));
    	
//    	Date expDate = new Date( Double.parseDouble(expStr));
//    	Date now = new Date();
//		if(!now.before(expDate)) {
//			throw new LTI1p3Exception("The current time: "+now+" MUST be before the time represented by the exp Claim: "+expDate);
//		}
    	
    	log.info("");
		
	}

	private void checkMandatoryClaims(List<String> mandatoryClaims, Claims jwtClaims) throws LTI1p3Exception {
		for(String mandatoryClaim: mandatoryClaims) {
			if(!jwtClaims.containsKey(mandatoryClaim)) {
				throw new LTI1p3Exception("Claim "+mandatoryClaim+ " is mandatory").log(2);
			}
    	}		
	}
	 

	private AccessToken createToken(AuthRequest authRequest) throws GeneralSecurityException, IOException {
        Instant now = Instant.now();
        long expiryInSeconds = 1L; 
        String scope = "https://purl.imsglobal.org/spec/lti-ags/scope/score";
        JwtClaimsSet claims = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiryInSeconds))
                .subject("AAAA")
                .claim("scope", scope) //TODO only this scope ? 
                .build();
        String accessToken = encoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
        String tokenType = "bearer";
        AccessToken at = new AccessToken(accessToken, tokenType,expiryInSeconds, scope);
        log.info("access token granted: "+accessToken);
        return at;
    }
    
    
      
}
