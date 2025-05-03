package com.example.demo.repository;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.BoardDTO;
import com.example.demo.dto.KeywordDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
	
	private final SqlSessionTemplate sql;
	
	//로그인
	public int goLogin(BoardDTO boardDTO) {
		return sql.selectOne("Board.goLogin", boardDTO);
	}
		
	//회원가입 정보 저장
	public void goSignUp(BoardDTO boardDTO) {
		sql.insert("Board.goSignUp", boardDTO);
	}

	//회원가입 아이디 중복 확인
	public int emailCheck(String email) {
		return sql.selectOne("Board.emailCheck", email);
	}

	//회원 정보 조회
	public BoardDTO custSearch(String email) {
		return sql.selectOne("Board.custSearch", email);
	}

	//키워드 조회
	public List<String> keyword(String email) {
		return sql.selectList("Board.keyword", email);
	}

	//키워드 추가
	public void addKeyword(KeywordDTO keywordDTO) {
		sql.insert("Board.addKeyword", keywordDTO);
	}

	//키워드 삭제
	public void deleteKeyword(KeywordDTO keywordDTO) {
		sql.delete("Board.deleteKeyword", keywordDTO);
	}

	//회원 정보 수정
	public void custUpdate(BoardDTO boardDTO) {
		sql.update("Board.custUpdate", boardDTO);
	}

}
