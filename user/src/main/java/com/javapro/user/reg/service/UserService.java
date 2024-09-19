package com.javapro.user.reg.service;

import java.util.List;

import com.javapro.user.reg.dto.UserDTO;


public interface UserService {

	public UserDTO addUser(UserDTO user);
	public List<UserDTO> getUsers();
	public String getToken();
	public void validateUser(UserDTO user);
	public UserDTO getUser(Integer userId);

}
