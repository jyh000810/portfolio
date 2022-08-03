package com.blogweb.mapper;

import java.util.List;

import com.blogweb.dto.Board;
import com.blogweb.dto.User;

public interface MypageMapper {

	void editInfo(User user);

	User findUserInfo(int userNo);

	void userDelete(int userNo);

	List<Board> boardInfo(int userNo);

}
