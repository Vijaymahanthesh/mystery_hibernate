package com.mystery.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.mystery.model.User;
import com.mystery.service.UserService;
@Controller
public class UserController {
	
	@Autowired
	private  UserService userService;
	
	/* User Management Module Starts */
	
	@RequestMapping("/createUser")
	public ModelAndView createUser() {
		ModelAndView mv = new ModelAndView("create-user");
		return mv;
	}
	/* save and update the user starts */

	@RequestMapping(value = "/createUser", method = RequestMethod.POST)
	public ModelAndView createUser( User user) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/viewUser");
		userService.createUser(user);
		return model;
	}
	/* save and update the user ends */
	
	/* View User starts  */
	@RequestMapping("/viewUser")
	public ModelAndView viewUser() {
		ModelAndView mv = new ModelAndView("view-user");
		List<User>userList = userService.getUserList();
		mv.addObject("userList", userList);
		List<User>inactiveuserList = userService.getInactiveUserList();
		mv.addObject("inactiveuserList", inactiveuserList);
		return mv;
	}
	/* View User Ends */
	
	/* view Users By Id Starts */
	@RequestMapping("/editUser/{userId}")
	public ModelAndView get(@PathVariable int userId) {
		ModelAndView model = new ModelAndView("edit-user");
		User userDetails = userService.getUserDetailsById(userId);
	    if(userDetails == null) {
		throw new RuntimeException("User not found"+userId);
	   }
	    model.addObject("userDetails", userDetails);
		return model;
	}
	
	/* view Users By Id  Ends*/
	
	/* Delete User By Id Starts */
	@RequestMapping("/deleteUser/{userId}")
	public ModelAndView deleteUser(@PathVariable  int userId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/viewUser");
	    userService.deleteUserById(userId);
		return model;
	}
	/* Delete User By Id Ends */
	
	/* Restore By User Id Starts */
	@RequestMapping("/restoreUser/{userId}")
	public ModelAndView restoreUser(@PathVariable  int userId) {
		ModelAndView model = null;
		model = new ModelAndView("redirect:/viewUser");
	    userService.restoreUserById(userId);
		return model;
	}
	/* Restore By User Id Ends */
	
	
	/* Check email already exist or not  starts*/
	
	@RequestMapping(value = "/checkEmailExistOrNot")
	public @ResponseBody Object checkEmailExistOrNot(HttpServletRequest request, HttpServletResponse response,User user) 
	{
        String email = request.getParameter("email");
		User emailExistOrNot = userService.checkEmailExistOrNot(user, email);
		return emailExistOrNot;
	}
	
	/* Check email already exist or not  ends*/
	
	/* User Management Module Ends */
}
