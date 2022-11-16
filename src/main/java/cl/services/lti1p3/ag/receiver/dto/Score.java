package cl.services.lti1p3.ag.receiver.dto;

import javax.validation.constraints.NotBlank;

//IMS definition here: TODO check 
public record Score(
        @NotBlank
        String userId,   //MUST be the same as the resource link LTI parameter 'user_id'.
         
        @NotBlank
        String activityProgress,
         
        @NotBlank
        String gradingProgress,
       
        @NotBlank
        Float scoreGiven,
        
        @NotBlank
        Float scoreMaximum,
        
        @NotBlank
        String comment      
         ) {
}
