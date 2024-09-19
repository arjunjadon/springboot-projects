package com.javapro.user.reg.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javapro.user.reg.dto.UserDTO;
import com.javapro.user.reg.entity.User;
import com.javapro.user.reg.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired(required = true)
	private ModelMapper modelMapper;

	public UserDTO addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
//		user.setUserId(userDTO.getUserId());
//		user.setUserName(userDTO.getUserName());
//		user.setEmail(userDTO.getEmail());
//		user.setPassword(userDTO.getPassword());

		ModelMapper mapper = new ModelMapper();
		mapper.map(userDTO, user);

		user = userRepository.save(user);
		mapper.map(user, userDTO);

		return userDTO;
	}

	public List<UserDTO> getUsers() {
		// TODO Auto-generated method stub
		List<UserDTO> userDTOs = new ArrayList<>();
		List<User> users = userRepository.findAll();

		userDTOs = users.stream().map(user -> modelMapper.map(user, UserDTO.class))
				.collect(Collectors.toList());
		return userDTOs;
	}

	public String getToken() {
		// TODO Auto-generated method stub
		return null;
		
	}

	public void validateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		
	}

	public UserDTO getUser(Integer userId) {
		UserDTO userDTO = new UserDTO();
		Optional<User> user = userRepository.findById(userId);
		
		modelMapper.map(user.get(), userDTO);
		return userDTO;
	}

}
