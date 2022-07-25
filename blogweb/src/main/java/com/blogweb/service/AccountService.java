package com.blogweb.service;

import org.springframework.stereotype.Service;

import com.blogweb.dto.User;


public interface AccountService {

	User findByUserIdAndPasswd(User user);
	void register(User user);
	int checkId(String checkId);

}