package com.spring.mvc.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.dto.IUserDetailsDTO;
import com.spring.mvc.pojo.UserDetails;

@Controller
@RequestMapping(value="/")
public class HomeController {
	
	@Autowired @Qualifier("userDTO1")
	private IUserDetailsDTO userDto;
	
	@RequestMapping("/adduser")  
    public ModelAndView showform(){  
         //command is a reserved request attribute name, now use <form> tag to show object data  
        return new ModelAndView("addUser","command",new UserDetails());  
    }  
	
	@RequestMapping(value="/save",method = RequestMethod.POST)  	
    public ModelAndView test(@ModelAttribute("user") UserDetails user) {
		userDto.saveUser(user);
		List<UserDetails> list=userDto.getAllUsers();
        System.out.println("No of users returned "+list.size());
        return new ModelAndView("viewUsers","list",list);
	}
	
	 @RequestMapping("/viewusers")  
     public ModelAndView viewemp(){  
         //write the code to get all employees from DAO  
         //here, we are writing manual code of list for easy understanding  
         List<UserDetails> list=userDto.getAllUsers();
         System.out.println("No of users returned "+list.size());
         return new ModelAndView("viewUsers","list",list);  
     }  

	 @RequestMapping(value="/deleteuser/{id}",method = RequestMethod.GET)  
	 public ModelAndView delete(@PathVariable int id){  
	       userDto.deleteUser(id);  
	        return new ModelAndView("redirect:/viewusers");  
	    }  
		
		@RequestMapping(value="/edituser/{id}",method = RequestMethod.GET)  
	    public ModelAndView edit(@PathVariable int id){  
			UserDetails user=userDto.getUser(id);
//			user.setUserId(id);
			return new ModelAndView("editUser","command",user);  
	    } 
		@RequestMapping(value="/edituser/editsave",method = RequestMethod.POST)  
	    public ModelAndView editsave(@ModelAttribute("user") UserDetails user){  
	        System.out.println("before updating "+user);
			userDto.updateUser(user);  
	        return new ModelAndView("redirect:/viewusers");  
	    }  
	 
}
