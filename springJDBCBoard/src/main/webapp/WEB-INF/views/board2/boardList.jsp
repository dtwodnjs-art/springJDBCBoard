<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>
    <style>
        body { font-family: 'Pretendard', sans-serif; background: #f4f7f6; padding: 40px; }
        .container { max-width: 1000px; margin: auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); }
        .header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 25px; }
        .btn { padding: 10px 20px; border-radius: 8px; text-decoration: none; font-weight: 600; font-size: 14px; color: white; }
        .btn-write { background: #2563eb; }
        .search-area { background: #f8f9fa; padding: 15px; border-radius: 8px; margin-bottom: 20px; text-align: right; }
        .search-area select, .search-area input { padding: 8px; border: 1px solid #ddd; border-radius: 4px; }
        table { width: 100%; border-collapse: collapse; }
        th { background: #f8f9fa; padding: 15px; border-bottom: 2px solid #eee; }
        td { padding: 15px; border-bottom: 1px solid #eee; text-align: center; }
        tr:hover { background: #f9fafb; cursor: pointer; }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <h1>자유 게시판</h1>
        <a href="/board2/insertForm2" class="btn btn-write">글쓰기</a>
    </div>

    <div class="search-area">
        <form action="/board2/search" method="get">
            <select name="searchType">
                <option value="title">제목</option>
                <option value="userId">작성자</option>
                <option value="content">내용</option>
            </select>
            <input type="text" name="keyword" placeholder="검색어 입력">
            <button type="submit" style="padding: 8px 15px; cursor: pointer;">검색</button>
        </form>
    </div>

    <table>
        <thead>
            <tr>
                <th>번호</th><th>제목</th><th>작성자</th><th>날짜</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="b" items="${boardList}">
                <tr onclick="location.href='/board2/detail?no=${b.no}'">
                    <td>${b.no}</td>
                    <td style="text-align:left;"><b>${b.title}</b></td>
                    <td>${b.userId}</td>
                    <td><fmt:formatDate value="${b.regdate}" pattern="yyyy-MM-dd"/></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>