package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.KeywordDTO;
import com.example.demo.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@CrossOrigin("*")
public class BoardController {
	private final BoardService boardService;
	
	//로그인 화면 출력
	@GetMapping("/login_signin")
	public String goLogin() {
		return "login_signin";
	}
		
	//로그인
	@PostMapping("/login")
	public String login(BoardDTO boardDTO) {
		int check =	boardService.goLogin(boardDTO);
		if(check == 1)
			return "index";
		else
			return "loginFail";
	}
		
	//회원가입 정보 저장
	@PostMapping("/sign_up")
	public String signUp(BoardDTO boardDTO) {
		if(boardService.emailCheck(boardDTO.getEmail()) == 0) {
			boardService.goSignUp(boardDTO);
			return "signUpSuccess";
		}
		else
			return "signUpFail";
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	
	//마이페이지 화면 출력
	@PostMapping("/myPage")
	public String myPage(@RequestParam("email") String email, Model model) {
		BoardDTO boardDTO = boardService.custSearch(email);
		List<String> keywords = boardService.keyword(email);
		model.addAttribute("cust", boardDTO);
		model.addAttribute("keyword", keywords);
		return "myPage";
	}
	
	//키워드 추가
	@PostMapping("/addKeyword")
	public String addKeyword(KeywordDTO keywordDTO) {
		boardService.addKeyword(keywordDTO);
		return "reloadMyPage";
	}
	
	//키워드 삭제
	@PostMapping("/deleteKeyword")
	public String deleteKeyword(KeywordDTO keywordDTO) {
		boardService.deleteKeyword(keywordDTO);
		return "reloadMyPage";
	}
	
	//회원 정보 수정
	@PostMapping("/custUpdate")
	public String custUpdate(BoardDTO boardDTO) {
		boardService.custUpdate(boardDTO);
		return "reloadMyPage";
	}
}
