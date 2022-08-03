package com.blogweb.service;

import java.util.List;

import com.blogweb.dto.Board;
import com.blogweb.dto.User;
import com.blogweb.mapper.MypageMapper;

public class MypageServiceImpl implements MypageService {

private MypageMapper mypageMapper;
	
	public MypageServiceImpl(MypageMapper mypageMapper) {
		this.mypageMapper = mypageMapper;
	}

	@Override
	public void editInfo(User user) {

		mypageMapper.editInfo(user);
	}

	@Override
	public User findUserInfo(int userNo) {

		User user = mypageMapper.findUserInfo(userNo);
		return user;
	}

	@Override
	public void userDelete(int userNo) {

		mypageMapper.userDelete(userNo);
	}


	@Override
	public List<Board> boardInfo(int userNo) {
		
		List<Board> boardList = mypageMapper.boardInfo(userNo);
		
		return boardList;
	}
}
