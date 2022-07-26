package com.blogweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blogweb.dto.User;
import com.blogweb.service.AccountService;

@Controller
@RequestMapping(path = { "/account" })
public class AccountController {

	private AccountService accountService;

	public AccountController(AccountService accountService) {
		this.accountService = accountService;
	}

	@GetMapping(path = { "/login" })
	public String showLogin() {
		return "account/login";
	}

	@PostMapping(path = { "/login" })
	public String login(User user, HttpSession session, Model model) {
		User user2 = accountService.findByUserIdAndPasswd(user);
		if (user2 != null) {
			session.setAttribute("loginuser", user2);
			System.out.println("LOGIN SUCCESS");
		} else {
			System.out.println("LOGIN FAIL");
			model.addAttribute("login_fail", "아이디 또는 비밀번호를 확인해주세요.");
		}
		return "account/login";
	}

	@GetMapping(path = { "/logout" })
	public String logout(HttpSession session) {
		session.removeAttribute("loginuser");
		return "redirect:/home";
	}

	@GetMapping(path = { "/register" })
	public String showRegister() {
		return "account/register";
	}

	@PostMapping(path = { "/register" })
	public String register(User user) {
		accountService.register(user);
		return "redirect:/home";
	}

	@PostMapping(path = { "checkId" })
	@ResponseBody
	public String checkId(String checkId) {
		int check = accountService.checkId(checkId);
		if (check == 0) {
			return "success";
		} else {
			return "fail";
		}
	}
}
