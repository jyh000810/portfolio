package com.blogweb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blogweb.common.Util;
import com.blogweb.dto.User;
import com.blogweb.mapper.AccountMapper;

public class AccountServiceImpl implements AccountService {

	private AccountMapper accountMapper;

	public AccountServiceImpl(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}

	@Override
	public User findByUserIdAndPasswd(User user) {
		String passwd = user.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256");
		user.setPasswd(passwd);
		User user2 = accountMapper.findByUserIdAndPasswd(user);
		return user2;
	}

	@Override
	public void register(User user) {
		String passwd = user.getPasswd();
		passwd = Util.getHashedString(passwd, "SHA-256");
		user.setPasswd(passwd);
		accountMapper.register(user);
	}

	@Override
	public int checkId(String checkId) {
		int check = accountMapper.checkId(checkId);
		return check;
	}

}
