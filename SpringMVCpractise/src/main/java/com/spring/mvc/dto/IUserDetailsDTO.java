package com.spring.mvc.dto;

import java.util.List;

import com.spring.mvc.pojo.UserDetails;

public interface IUserDetailsDTO {
	
	void saveUser(UserDetails user);
	List<UserDetails> getAllUsers();
	void deleteUser(int id);
	void updateUser(UserDetails user);
	UserDetails getUser(int id);

}
