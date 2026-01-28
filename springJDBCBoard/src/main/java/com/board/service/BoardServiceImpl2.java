package com.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.dao.BoardDAO2;
import com.board.domain.Board2;

@Service
public class BoardServiceImpl2 implements BoardService2 {

   @Autowired
   private BoardDAO2 boardDAO2;
   
   @Override
   public int insertBoard(Board2 board) throws Exception {
      // 결과를 count 변수에 담아서 리턴
      int count = boardDAO2.insertBoard(board);
      return count;
   }

   @Override
   public Board2 selectByNo(Board2 b) throws Exception {
      // 결과를 board 변수에 담아서 리턴
      Board2 board = boardDAO2.selectByNo(b);
      return board;
   }

   @Override
   public int updateBoard(Board2 board) throws Exception {
      // 참고 자료와 동일하게 count를 구한 뒤 0을 리턴
      int count = boardDAO2.updateBoard(board);
      return 0;
   }

   @Override
   public int deleteBoard(Board2 board) throws Exception {
      // 결과를 count 변수에 담아서 리턴
      int count = boardDAO2.deleteBoard(board);
      return count;
   }

   @Override
   public List<Board2> boardList() throws Exception {
      // 결과를 boardList 변수에 담아서 리턴
      List<Board2> boardList = boardDAO2.boardList();
      return boardList;
   }

   @Override
   public List<Board2> boardSearch(Board2 board) throws Exception {
      // 결과를 boardList 변수에 담아서 리턴
      List<Board2> boardList = boardDAO2.boardSearch(board);
      return boardList;
   }

}