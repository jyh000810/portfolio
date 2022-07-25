package com.blogweb.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blogweb.dto.User;

@Mapper
public interface AccountMapper {

	User findByUserIdAndPasswd(User user);
	void register(User user);
	int checkId(String checkId);

}
