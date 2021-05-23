package com.kunj.kunjapp.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kunj.kunjapp.dto.RegistrationDTO;
import com.kunj.kunjapp.entity.Endgame21v02Entity;
import com.kunj.kunjapp.repository.Endgame21v02Repo;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	private Logger logger;

	@Autowired
	private Endgame21v02Repo repo;

	public RegistrationServiceImpl() {
		logger = Logger.getLogger(getClass());
	}

	public String validateAndSave(RegistrationDTO dto) {
		logger.info("inside {} ");
		Endgame21v02Entity entity = new Endgame21v02Entity();
		try {
			
			Endgame21v02Entity edEntity = repo.getByEmailId(dto.getEmailId());
			if (edEntity == null) {
				
				BeanUtils.copyProperties(dto, entity);
				
				entity.setRegisteredBy("nikunj");

				LocalDateTime ldate = LocalDateTime.now();
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");
				
				String date = formatter.format(ldate);
				
				entity.setRegisteredDate(date);

				int affectedRows=repo.save(entity);
				if (affectedRows > 0 ) {
					logger.info("user successfully registered");
					return "user successfully registered";
				}else {
					logger.info("user not registered");
					return "user not registered";
				}
				
			}
			else {
				logger.info("user already exist");
				return "user already exist";
			}
		} catch (Exception e) {
			logger.error("you have an Exception in {} "+ e.getMessage(),e);
		}
		return "";
	}

}
