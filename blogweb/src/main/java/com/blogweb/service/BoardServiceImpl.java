package com.blogweb.service;

import java.util.List;

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

	@Override
	public List<Board> findAllBoard() {
		List<Board> boardList = boardMapper.findAllBoard();
		return boardList;
	}

	@Override
	public Board findDetailByBoardNo(int boardNo) {
		Board board = boardMapper.findDetailByBoardNo(boardNo);
		List<BoardAttach> files = boardMapper.findAttachByBoardNo(boardNo);
		board.setFiles(files);
		return board;
	}

	@Override
	public void editboard(Board board) {
		boardMapper.editBoard(board);
		if (board.getFiles() != null) {
			for (BoardAttach file : board.getFiles()) {
				file.setBoardNo(board.getBoardNo());
				boardMapper.insertBoardAttach(file);
			}
		}
	}

	@Override
	public void deleteBoard(int boardNo) {
		boardMapper.deleteBoard(boardNo);
		
	}
	
}
