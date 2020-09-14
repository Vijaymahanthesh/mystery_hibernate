package com.mystery.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.mystery.model.User;
import com.mystery.service.AuthenticService;
@Controller
public class AuthenticController {

	@Autowired
	private  AuthenticService authenticservice;
	
	/* Sign in Starts */
	@RequestMapping("/")
	public ModelAndView signin() {
		ModelAndView mv = new ModelAndView("signin");
		return mv;
	}
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public ModelAndView signin( User user,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
		ModelAndView model = null;
		User  userDetails=	authenticservice.signin(user);
		if(userDetails.getStatusCode().equals("1"))
		{
			
			model = new ModelAndView("redirect:/createUser");
			request.getSession().setAttribute("userId", userDetails.getSk_user_id());
			request.getSession().setAttribute("first_name", userDetails.getFirst_name());
			redirectAttributes.addFlashAttribute("statusMessage", userDetails.getStatusmessage());
			redirectAttributes.addFlashAttribute("statusCode", userDetails.getStatusCode());
		}
		else 
		{
			model = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("statusMessage", userDetails.getStatusmessage());
			redirectAttributes.addFlashAttribute("statusCode", userDetails.getStatusCode());
			
		}
		return model;
	}
	
	/* Sign in Ends */
	
	/* Forgot Password link Starts */
	
	@RequestMapping("/forgotPassword")
	public ModelAndView forgotPassword() {
		ModelAndView mv = new ModelAndView("forgot-password");
		return mv;
	}
	
	@RequestMapping(value = "/forgotPassword", method = RequestMethod.POST)
	public ModelAndView forgotPassword( User user,HttpServletRequest request,HttpServletResponse response,RedirectAttributes redirectAttributes) {
		ModelAndView model = null;
		User  userDetails=	authenticservice.forgotPassword(user);
		if(userDetails.getStatusCode().equals("1"))
		{
			
			model = new ModelAndView("redirect:/");
			request.getSession().setAttribute("Id", userDetails.getSk_user_id());
			request.getSession().setAttribute("first_name", userDetails.getFirst_name());
			redirectAttributes.addFlashAttribute("statusMessage", userDetails.getStatusmessage());
			redirectAttributes.addFlashAttribute("statusCode", userDetails.getStatusCode());
		}
		else 
		{
			model = new ModelAndView("redirect:/forgotPassword");
			redirectAttributes.addFlashAttribute("statusMessage", userDetails.getStatusmessage());
			redirectAttributes.addFlashAttribute("statusCode", userDetails.getStatusCode());
			
		}
		return model;
	}
	
	/* Forgot Password link Starts */
	
	
	
	/* Reset Password Starts */
	
	@RequestMapping("/resetPassword//{userId}")
	public ModelAndView resetPassword(@PathVariable int userId,HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("reset-password");
		request.setAttribute("userId", userId);
		return mv;
	}
	
	
	@RequestMapping(value = "resetPassword", method = RequestMethod.POST)
	public ModelAndView resetPassword(User user,RedirectAttributes redirectAttributes) {
		ModelAndView model =null;
		User userDetails = authenticservice.resetPassword(user);
		if(userDetails.getStatusCode().equals("1"))
		{
			model = new ModelAndView("redirect:/");
			redirectAttributes.addFlashAttribute("statusMessage", userDetails.getStatusmessage());
			redirectAttributes.addFlashAttribute("statusCode", userDetails.getStatusCode());
		}
		return model;
	}
	
	
	/*Reset Password Ends */
	
	@RequestMapping("/logout")
	  public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) {
	    ModelAndView model = null;
	    model = new ModelAndView("redirect:/");
	    HttpSession session = request.getSession();
	    session.invalidate();
	    session = request.getSession(false);
	    return model;
	  }
}
