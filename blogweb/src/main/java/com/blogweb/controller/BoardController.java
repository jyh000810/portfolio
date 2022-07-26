package com.blogweb.controller;

import java.io.File;
import java.net.http.HttpRequest;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
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
				try {
					File path = new File(uploadDir, savedFileName);
					file.transferTo(path); // 파일 저장
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
}
