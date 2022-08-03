package com.blogweb.service;

import java.util.List;

import com.blogweb.dto.Board;

public interface BoardService {

	void writeboard(Board board);

	List<Board> findAllBoard();

	Board findDetailByBoardNo(int boardNo);

	void editboard(Board board);

	void deleteBoard(int boardNo);

}