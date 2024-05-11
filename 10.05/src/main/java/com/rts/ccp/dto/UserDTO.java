package com.rts.ccp.dto;
 
import java.util.ArrayList;
 
import java.util.List;
 
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.rts.ccp.bean.Project;

import jakarta.persistence.CascadeType;
 
import jakarta.persistence.Column;
 
import jakarta.persistence.Entity;
 
import jakarta.persistence.GeneratedValue;
 
import jakarta.persistence.GenerationType;
 
import jakarta.persistence.Id;
 
import jakarta.persistence.JoinColumn;
 
import jakarta.persistence.ManyToMany;
 
import jakarta.persistence.ManyToOne;
 
import jakarta.persistence.OneToMany;
 
import jakarta.persistence.Table;
 
public class UserDTO {
 
	private Long userId;
 
	private String userFirstName;
 
	private String userLastName;
 
	private String userEmailId;
 
	private String userType;
 
	private Long userMobileNumber;
 
//	private long department;
//	private String departmentName;

 
//	private long region;
//	private String regionName;
 

	private List<Long> region = new ArrayList<>();
	private List<String> regionName = new ArrayList<>();
	private List<Long> department = new ArrayList<>();
	private List<String> departmentName = new ArrayList<>();
	private List<Long> project = new ArrayList<>();
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDTO(Long userId, String userFirstName, String userLastName, String userEmailId, String userType,
			Long userMobileNumber, List<Long> region, List<String> regionName, List<Long> department,
			List<String> departmentName, List<Long> project) {
		super();
		this.userId = userId;
		this.userFirstName = userFirstName;
		this.userLastName = userLastName;
		this.userEmailId = userEmailId;
		this.userType = userType;
		this.userMobileNumber = userMobileNumber;
		this.region = region;
		this.regionName = regionName;
		this.department = department;
		this.departmentName = departmentName;
		this.project = project;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserFirstName() {
		return userFirstName;
	}
	public void setUserFirstName(String userFirstName) {
		this.userFirstName = userFirstName;
	}
	public String getUserLastName() {
		return userLastName;
	}
	public void setUserLastName(String userLastName) {
		this.userLastName = userLastName;
	}
	public String getUserEmailId() {
		return userEmailId;
	}
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public Long getUserMobileNumber() {
		return userMobileNumber;
	}
	public void setUserMobileNumber(Long userMobileNumber) {
		this.userMobileNumber = userMobileNumber;
	}
	public List<Long> getRegion() {
		return region;
	}
	public void setRegion(List<Long> region) {
		this.region = region;
	}
	public List<String> getRegionName() {
		return regionName;
	}
	public void setRegionName(List<String> regionName) {
		this.regionName = regionName;
	}
	public List<Long> getDepartment() {
		return department;
	}
	public void setDepartment(List<Long> department) {
		this.department = department;
	}
	public List<String> getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(List<String> departmentName) {
		this.departmentName = departmentName;
	}
	public List<Long> getProject() {
		return project;
	}
	public void setProject(List<Long> project) {
		this.project = project;
	}
	
	
	 
}