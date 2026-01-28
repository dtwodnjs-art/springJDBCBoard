package com.board.service;

import java.util.List;


import com.board.domain.Board2;

public interface BoardService2 {
	public int insertBoard(Board2 board) throws Exception;
	public List<Board2> boardList() throws Exception;
	public Board2 selectByNo(Board2 b) throws Exception;
	public int updateBoard(Board2 board) throws Exception;
	public int deleteBoard(Board2 board) throws Exception;
	public List<Board2> boardSearch(Board2 board) throws Exception;
}
