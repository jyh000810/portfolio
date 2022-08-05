package com.blogweb.controller;

import java.io.File;
import java.net.http.HttpRequest;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.blogweb.common.Util;
import com.blogweb.dto.Board;
import com.blogweb.dto.BoardAttach;
import com.blogweb.dto.User;
import com.blogweb.service.BoardService;

@Controller
@RequestMapping(path = { "/board" })
public class BoardController {

	BoardService boardService;
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping(path = { "/write" } )
	public String showWrite() {
		return "board/write";
	}
	
	@PostMapping(path = { "/write" })
	public String write(Board board, HttpSession session, MultipartFile[] attach, HttpServletRequest req) {
		User user = (User) session.getAttribute("loginuser");
		board.setWriter(user.getUserNo());
		
		String uploadDir = req.getServletContext().getRealPath("/resources/upload-files");
		ArrayList<BoardAttach> files = new ArrayList<>();
		for (MultipartFile file : attach) {			
			String userFileName = file.getOriginalFilename();
			if (userFileName != null && userFileName.length() > 0) {
				BoardAttach f = new BoardAttach();			
				String savedFileName = Util.makeUniqueFileName(userFileName); 
				f.setUserFileName(userFileName);
				f.setSavedFileName(savedFileName);
				board.setThumbnail(savedFileName);	

				try {
					File path = new File(uploadDir, savedFileName);
					file.transferTo(path);
					files.add(f);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		board.setFiles(files);
		boardService.writeboard(board);
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/detail" })
	public String showDetail(int boardNo, Model model) {
		
		Board board = boardService.findDetailByBoardNo(boardNo);
		List<BoardAttach> attachList = board.getFiles();
		model.addAttribute("board", board);
		model.addAttribute("attachList", attachList);
		return "board/detail";
	}
	
	@GetMapping(path = { "/edit" })
	public String showEdit(int boardNo, Model model) {
		Board board = boardService.findDetailByBoardNo(boardNo);
		List<BoardAttach> attachList = board.getFiles();
		model.addAttribute("board", board);
		model.addAttribute("attachList", attachList);
		return "board/edit";
	}

	
	@PostMapping(path = { "/edit" })
	public String edit(Board board, HttpSession session, MultipartFile[] attach, HttpServletRequest req) {
		User user = (User) session.getAttribute("loginuser");
		board.setWriter(user.getUserNo());
		
		String uploadDir = req.getServletContext().getRealPath("/resources/upload-files");
		ArrayList<BoardAttach> files = new ArrayList<>();
		for (MultipartFile file : attach) {			
			String userFileName = file.getOriginalFilename();
			if (userFileName != null && userFileName.length() > 0) {
				BoardAttach f = new BoardAttach();			
				String savedFileName = Util.makeUniqueFileName(userFileName); 
				f.setUserFileName(userFileName);
				f.setSavedFileName(savedFileName);
				board.setThumbnail(savedFileName);	

				try {
					File path = new File(uploadDir, savedFileName);
					file.transferTo(path);
					files.add(f);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}

		board.setFiles(files);
		boardService.editboard(board);
		return "redirect:/home";
	}
	
	@GetMapping(path = { "/delete" })
	public String delete(int boardNo) {
		boardService.deleteBoard(boardNo);
		return "redirect:/home";
	}
}
