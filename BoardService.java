package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.KeywordDTO;
import com.example.demo.repository.BoardRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardRepository boardRepository;
	
	//로그인
	public int goLogin(BoardDTO boardDTO) {
		return boardRepository.goLogin(boardDTO);
	}
	
	//회원가입 정보 저장
	public void goSignUp(BoardDTO boardDTO) {
		boardRepository.goSignUp(boardDTO);
	}

	//회원가입 아이디 중복 확인
	public int emailCheck(String email) {
		return boardRepository.emailCheck(email);
	}

	//회원 정보 조회
	public BoardDTO custSearch(String email) {
		return boardRepository.custSearch(email);
	}

	//키워드 조회
	public List<String> keyword(String email) {
		return boardRepository.keyword(email);
	}

	//키워드 추가
	public void addKeyword(KeywordDTO keywordDTO) {
		boardRepository.addKeyword(keywordDTO);
	}

	//키워드 삭제
	public void deleteKeyword(KeywordDTO keywordDTO) {
		boardRepository.deleteKeyword(keywordDTO);
	}

	//회원 정보 수정
	public void custUpdate(BoardDTO boardDTO) {
		boardRepository.custUpdate(boardDTO);
	}
}
