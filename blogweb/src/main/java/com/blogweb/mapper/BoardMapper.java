package com.blogweb.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.blogweb.dto.Board;
import com.blogweb.dto.BoardAttach;

@Mapper
public interface BoardMapper {

	void insertBoard(Board board);
	void insertBoardAttach(BoardAttach file);
	List<Board> findAllBoard();
	Board findDetailByBoardNo(int boardNo);
	List<BoardAttach> findAttachByBoardNo(int boardNo);
	void editBoard(Board board);
	void deleteBoard(int boardNo);


}
