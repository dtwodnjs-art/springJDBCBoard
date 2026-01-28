package com.board.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Board2 {
	private int no;                 // 게시글 번호
    private String userId;          // 작성자 아이디
    private String userpassword;    // 비밀번호
    private String title;           // 제목
    private String content;         // 내용
    private Date regdate;           // 작성일
    private int readcount;          // 조회수
    
    private String searchType;
	private String keyword;
}
