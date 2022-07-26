package com.blogweb.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.blogweb.dto.Board;
import com.blogweb.dto.BoardAttach;

@Mapper
public interface BoardMapper {

	void insertBoard(Board board);
	void insertBoardAttach(BoardAttach file);


}
