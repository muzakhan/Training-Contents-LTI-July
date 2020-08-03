package com.lti.training.usermicro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.training.usermicro.dto.RegisterDto;
import com.lti.training.usermicro.dto.UserDetailDto;
import com.lti.training.usermicro.entity.User;
import com.lti.training.usermicro.repository.UserRepository;
import com.lti.training.usermicro.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	// Dependency
	private UserRepository userRepository;
	
	@Autowired // optional
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public UserDetailDto register(RegisterDto registerDto) {
		// convert the DTO into entity
		// separate util package ( custom converter methods )
		// ModelMapper 
		User user = new User(null, registerDto.getName(), registerDto.getEmailId(), registerDto.getPassword());
		// to use repository layer to persist in database
		user = this.userRepository.save(user);
		// convert the entity into DTO
		UserDetailDto userDetailDto = new UserDetailDto(user.getId(), user.getName(), user.getEmailId());
		return userDetailDto;
		
	}

}
