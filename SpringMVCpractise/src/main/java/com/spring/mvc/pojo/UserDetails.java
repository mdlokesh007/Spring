package com.spring.mvc.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserDetails {
	@Id @GeneratedValue
	private Integer userId;
	private String name;
	private String phone;
	private String city;
	
	public UserDetails() {}
	
	public UserDetails( String userName, String phone, String city) {
		super();
		this.name = userName;
		this.phone = phone;
		this.city = city;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return "UserDetails [userId=" + userId + ", Name=" + name + ", phone=" + phone + ", city=" + city + "]";
	}
	

}
