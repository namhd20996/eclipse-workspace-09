package com.assign.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.assign.dto.UserDTO;
import com.assign.service.IUserService;

@Controller
public class HomeController {

	@Autowired
	private IUserService userService;

	@RequestMapping(value = { "/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView homePage() {
		return new ModelAndView("/web/home");
	}

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView loginPage() {
		return new ModelAndView("/web/login");
	}

	@RequestMapping(value = "/login/register", method = RequestMethod.GET)
	public ModelAndView registerPage() {

		return new ModelAndView("/web/register");
	}

	@RequestMapping(value = "/login/forgot", method = RequestMethod.GET)
	public ModelAndView forgotPage() {
		return new ModelAndView("/web/forgot");
	}

	@RequestMapping(value = "/change-profile", method = RequestMethod.GET)
	public ModelAndView changeProfile() {
		return new ModelAndView("/web/change-profile");
	}

	@GetMapping("/login/verify")
	public ModelAndView verifyPage() {
		return new ModelAndView("/web/verify");
	}

	@PostMapping("/login/verify")
	public void verifyPage(HttpServletResponse resp, @RequestParam("password") String password,
			@RequestParam("username") String username, @RequestParam("verify") String verify) {
		if (userService.updatePassword(password, username, verify) > 0) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

	@PostMapping("/login/forgot")
	public void forgotPageP(HttpServletResponse resp, @RequestParam("username") String username,
			@RequestParam("email") String email) {
		UserDTO user = userService.findOneByUsernameAndEmail(username, email);
		if (user != null) {
			resp.setStatus(204);
		} else {
			resp.setStatus(400);
		}
	}

	@RequestMapping(value = "/logoff", method = RequestMethod.GET)
	public ModelAndView logOut(HttpServletRequest req, HttpServletResponse resp) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(req, resp, auth);
		}
		return new ModelAndView("redirect:/trang-chu");
	}

}
