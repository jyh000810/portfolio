package com.blogweb.service;

import com.blogweb.dto.Board;
import com.blogweb.dto.BoardAttach;
import com.blogweb.mapper.BoardMapper;

public class BoardServiceImpl implements BoardService {

	BoardMapper boardMapper;
	
	public BoardServiceImpl(BoardMapper boardMapper) {
		this.boardMapper = boardMapper;
	}

	@Override
	public void writeboard(Board board) {
		boardMapper.insertBoard(board);
		if (board.getFiles() != null) {
			for (BoardAttach file : board.getFiles()) {
				file.setBoardNo(board.getBoardNo());
				boardMapper.insertBoardAttach(file);
			}
		}
	}
	
}
