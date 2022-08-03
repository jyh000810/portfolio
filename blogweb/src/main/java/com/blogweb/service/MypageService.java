package com.blogweb.service;

import java.util.List;

import com.blogweb.dto.Board;
import com.blogweb.dto.User;

public interface MypageService {

	User findUserInfo(int userNo);

	List<Board> boardInfo(int userNo);

	void editInfo(User user);

	void userDelete(int userNo);

}