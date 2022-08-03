package com.blogweb.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.blogweb.dto.Board;
import com.blogweb.service.BoardService;

@Controller
public class HomeController {
	
	BoardService boardService;

	public HomeController(BoardService boardService) {
		this.boardService = boardService;
	}

	@GetMapping(path = { "/", "/home" })
	public String home(Model model) {
		List<Board> boardList = boardService.findAllBoard();
		model.addAttribute("boardList", boardList);
		return "home";
	}

}
