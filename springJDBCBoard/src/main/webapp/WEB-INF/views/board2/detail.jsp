<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 상세보기</title>
    <style>
        body { font-family: 'Pretendard', sans-serif; background: #f4f7f6; padding: 40px; }
        .container { max-width: 800px; margin: auto; background: white; padding: 40px; border-radius: 12px; }
        .info { color: #888; margin-bottom: 20px; border-bottom: 1px solid #eee; padding-bottom: 10px; }
        .content { min-height: 250px; line-height: 1.6; }
        .btn-group { display: flex; justify-content: flex-end; gap: 10px; margin-top: 30px; }
        .btn { padding: 10px 20px; border-radius: 8px; text-decoration: none; color: white; font-weight: bold; }
    </style>
</head>
<body>
<div class="container">
    <h1>${board.title}</h1>
    <div class="info">
        작성자: ${board.userId} | 날짜: <fmt:formatDate value="${board.regdate}" pattern="yyyy-MM-dd HH:mm" />
    </div>
    <div class="content">${board.content}</div>
    <div class="btn-group">
        <a href="/board2/updateForm?no=${board.no}" class="btn" style="background: #f59e0b;">수정</a>
        <a href="/board2/delete?no=${board.no}" class="btn" style="background: #ef4444;" onclick="return confirm('삭제할까요?')">삭제</a>
        <a href="/board2/boardList" class="btn" style="background: #6b7280;">목록</a>
    </div>
</div>
</body>
</html>