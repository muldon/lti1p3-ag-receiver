package cl.services.lti1p3.ag.receiver.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import cl.services.lti1p3.ag.receiver.dto.Score;

@Service
public class AGService {
	private final static Logger log =  Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);   
    
	
	public void postScores(Score scoreDTO) {
		log.info("Receiving scores :"+scoreDTO);
		
	}
     
}
