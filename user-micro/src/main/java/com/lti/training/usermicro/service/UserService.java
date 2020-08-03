package com.lti.training.usermicro.service;

import com.lti.training.usermicro.dto.RegisterDto;
import com.lti.training.usermicro.dto.UserDetailDto;

public interface UserService {
	public UserDetailDto register(RegisterDto registerDto);
}
