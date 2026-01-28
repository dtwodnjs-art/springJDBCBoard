package com.board.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.board.domain.Board2;

@Repository
public class BoardDAO2 {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

   
    public int insertBoard(Board2 board) {
       
        String query = "insert into jdbcBoard2 values(jdbcBoard2_seq.nextval, ?, ?, ?, ?, sysdate, 0)";
        
        
        int count = jdbcTemplate.update(query, 
                                        board.getUserId(), 
                                        board.getUserpassword(), 
                                        board.getTitle(), 
                                        board.getContent());
        return count;
    }

 
    public List<Board2> boardList() {
        String query = "select * from jdbcBoard2 where no > 0 order by no desc, regdate desc";
        
        List<Board2> boardList = jdbcTemplate.query(query, new RowMapper<Board2>() {
            @Override
            public Board2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board2 board = new Board2();
                board.setNo(rs.getInt("no"));
                board.setUserId(rs.getString("userId"));
                board.setUserpassword(rs.getString("userpassword"));
                board.setTitle(rs.getString("title"));
                board.setContent(rs.getString("content"));
                board.setRegdate(rs.getDate("regdate"));
                board.setReadcount(rs.getInt("readcount"));
                return board;
            }
        });
        
        return boardList;
    }

    // 3. 게시글 상세 조회
    public Board2 selectByNo(Board2 board) {
        String query = "select * from jdbcBoard2 where no = ?";
        
        List<Board2> boardList = jdbcTemplate.query(query, new RowMapper<Board2>() {
            @Override
            public Board2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board2 b = new Board2();
                b.setNo(rs.getInt("no"));
                b.setUserId(rs.getString("userId"));
                b.setUserpassword(rs.getString("userpassword"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setRegdate(rs.getDate("regdate"));
                b.setReadcount(rs.getInt("readcount"));
                return b;
            }
        }, board.getNo());

        return boardList.isEmpty() ? null : boardList.get(0);
    }

    // 4. 게시글 삭제
    public int deleteBoard(Board2 board) {
        String query = "delete from jdbcBoard2 where no = ?";
        int count = jdbcTemplate.update(query, board.getNo());
        return count;
    }

    // 5. 게시글 수정
    public int updateBoard(Board2 board) {
        
        String query = "update jdbcBoard2 set userId = ?, title = ?, content = ? where no = ?";
        int count = jdbcTemplate.update(query, 
                                        board.getUserId(), 
                                        board.getTitle(), 
                                        board.getContent(), 
                                        board.getNo());
        return count;
    }

    // 6. 게시글 검색
    public List<Board2> boardSearch(Board2 board) {
        String searchItem = board.getSearchType(); 
        List<String> searchList = Arrays.asList("title", "content", "userId");
        
        if(searchItem == null || !searchList.contains(searchItem)) {
            searchItem = "title";
        }

       
        String query = "select * from jdbcBoard2 where " + searchItem + " like '%" + board.getKeyword() + "%' order by no desc";

        List<Board2> boardList = jdbcTemplate.query(query, new RowMapper<Board2>() {
            @Override
            public Board2 mapRow(ResultSet rs, int rowNum) throws SQLException {
                Board2 b = new Board2();
                b.setNo(rs.getInt("no"));
                b.setUserId(rs.getString("userId"));
                b.setTitle(rs.getString("title"));
                b.setContent(rs.getString("content"));
                b.setRegdate(rs.getDate("regdate"));
                b.setReadcount(rs.getInt("readcount"));
                return b;
            }
        });

        return boardList;
    }
}
