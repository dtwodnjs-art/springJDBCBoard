package com.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.board.domain.Board2;
import com.board.service.BoardService2;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board2") 
public class BoardController2 {
   
   @Autowired
   private BoardService2 boardService2;
   
   @GetMapping("/insertForm2")
   public String boardInsertForm(Model model) {
      return "board2/insertForm2";
   }

   @PostMapping("/insert2")
   public String boardInsert(Board2 board, Model model) {
       log.info("insert board=" + board.toString());
       try {
           int count = boardService2.insertBoard(board);
           if(count > 0){
               model.addAttribute("message", "%s 님의 게시판이 등록되었습니다.".formatted(board.getUserId()));
               return "board2/success"; 
           }
       } catch (Exception e) {
           e.printStackTrace();
       }
      
       model.addAttribute("message", "등록 실패!");
       return "board2/insertForm2"; 
   }

   @GetMapping("/boardList")
   public String boardList(Model model) {
      log.info("boardList");
      try {
         List<Board2> boardList = boardService2.boardList();
         model.addAttribute("boardList", boardList);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "board2/boardList";
   }
   
   @GetMapping("/detail")
   public String boardDetail(Board2 b, Model model) {
      log.info("boardDetail board=" + b.toString());
      try {
         Board2 board = boardService2.selectByNo(b);
         if(board == null) {
            model.addAttribute("message", "%d 번 게시글의 상세정보가 없습니다.".formatted(b.getNo()));
            return "board2/failed";
         }
         model.addAttribute("board", board);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "board2/detail";
   }
   
   @GetMapping("/delete")
   public String boardDelete(Board2 board, Model model) {
      log.info("boardDelete board=" + board.toString());
      try {
         int count = boardService2.deleteBoard(board);
         if(count > 0) {
            model.addAttribute("message", "%d 번 게시판이 삭제되었습니다.".formatted(board.getNo()));
            return "board2/success";
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      model.addAttribute("message", "%d 번 게시판 삭제 실패.".formatted(board.getNo())); 
      return "board2/failed";
   }
   
   @GetMapping("/updateForm")
   public String boardUpdateForm(Board2 b, Model model) {
      log.info("boardUpdateForm board=" + b.toString());
      try {
         Board2 board = boardService2.selectByNo(b);
         if(board == null) {
            model.addAttribute("message", "%d 번 게시글의 정보가 없습니다..".formatted(b.getNo()));
            return "board2/failed";
         }
         model.addAttribute("board", board);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "board2/updateForm";
   }
   
   @PostMapping("/update")
   public String boardUpdate(Board2 b, Model model) {
      log.info("boardUpdate board=" + b.toString());
      try {
         int count = boardService2.updateBoard(b);
         
         if(count >= 0) { 
            model.addAttribute("message", "%s 님의 게시판 수정성공".formatted(b.getUserId()));
            return "board2/success";
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      model.addAttribute("message", "%s 님의 게시판 수정실패".formatted(b.getUserId()));
      return "board2/updateForm";
   }
   
   @GetMapping("/search")
   public String boardSearch(Board2 board, Model model) {
      log.info("boardSearch board: " + board.toString());
      try {
         List<Board2> boardList = boardService2.boardSearch(board);
         model.addAttribute("boardList", boardList);
      } catch (Exception e) {
         e.printStackTrace();
      }
      return "board2/boardList";
   }
}