package com.rts.ccp.controller;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.rts.ccp.bean.Response;
import com.rts.ccp.bean.User;
import com.rts.ccp.bean.UserProject;
import com.rts.ccp.dto.UserDTO;
import com.rts.ccp.dto.UserProjectDTO;
import com.rts.ccp.service.UserService;
import com.rts.ccp.util.JwtUtil;

import jakarta.mail.MessagingException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
 
@RestController
@CrossOrigin("http://localhost:4200/")
public class UserController {
 
    @Autowired
    private UserService userService;
    
    @Autowired
    private JwtUtil jwtUtil;
 
    @PostMapping("/insertUsers")
    public void performInsert(@RequestBody UserDTO user) {
        userService.saveOrUpdateUser(user);
    }
 
    @PostMapping("/PerformInsert")
	public ResponseEntity<Response> userInsert(@RequestBody UserDTO invite) {		
//		System.out.println(invite.getUserFirstName()+invite.getUserLastName()+invite.getUserEmailId()+invite.getUserMobileNumber());
		boolean result = userService.saveUser(invite);
		if(result==true) {
			Response res = new Response("true");
			return ResponseEntity.ok(res);
		}else {
			Response res = new Response("false");
			return ResponseEntity.ok(res);
		}
	}
    
    @PutMapping("/updateUsers")
    public void performUpdate(@RequestBody UserDTO user) {
        userService.saveOrUpdateUser(user);
    }
 
    @DeleteMapping("/deleteUsers/{userId}")
    public void performDelete(@PathVariable Long userId) {
        userService.deleteUserById(userId);
    }
 
//    @GetMapping("/findAllUsers")
//    public List<User> viewAllUsers() {
//        return userService.getAllUsers();
//    }
//    
 
    @GetMapping("/findAllEmployees")
    public List<UserDTO> viewAllEmployees() {
        return userService.getAllEmployees();
    }
    @GetMapping("/MapAllEmployees")
    public List<UserDTO> mapEmployees() {
        return userService.getEmployeesToMap();
    }

    
    @GetMapping("/getEmployeeToGeneratePassword")
    public ResponseEntity<List<UserDTO>> getEmployeeGenerate(@RequestHeader("Authorization") String token){
   
    	String newToken = (token.substring(7)).trim();
        User user = jwtUtil.verifyToken(newToken);
        System.out.println(newToken);
     
        if (user != null) {
            List<UserDTO> employeePasswords = userService.generateEmployeePassword();   
            return ResponseEntity.ok(employeePasswords);
        }
        else {
            
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
  //new method
    
    @GetMapping("/findProject")
    public List<UserProjectDTO> finduserProject() {
    	
    	List<UserDTO> user = viewAllEmployees();
    	
    	System.out.println(user);
    	
    	List<UserProjectDTO> userProject = new ArrayList<>();
//    	userProject.clear();
    	System.out.println(user.size());
    	for(int i=0;i<user.size();i++) {
    		
    		UserProjectDTO userProjectDto=new UserProjectDTO();
    		
    		userProjectDto.setUserId(user.get(i).getUserId());
    		userProjectDto.setUserFirstName(user.get(i).getUserFirstName());
    		userProjectDto.setUserLastName(user.get(i).getUserLastName());
    		userProjectDto.setUserEmailId(user.get(i).getUserEmailId());
    		userProjectDto.setUserMobileNumber(user.get(i).getUserMobileNumber());
    		userProjectDto.setRegionName(user.get(i).getRegionName());
    		userProjectDto.setDepartmentName(user.get(i).getDepartmentName());
    		userProjectDto.setProjects(userService.findUserProject(user.get(i).getUserId()));
    		userProject.add(i,userProjectDto);
//    		System.out.println(userService.findUserProject(i));
             }
    	return userProject;
    }
}