<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 수정</title>
    <style>
        body { font-family: sans-serif; background: #f4f7f6; padding: 40px; }
        .container { max-width: 600px; margin: auto; background: white; padding: 30px; border-radius: 12px; }
        input, textarea { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ddd; border-radius: 8px; box-sizing: border-box; }
    </style>
</head>
<body>
    <div class="container">
        <h2>게시글 수정</h2>
        <form action="/board2/update" method="post">
            <input type="hidden" name="no" value="${board.no}">
            <input type="text" name="userId" value="${board.userId}" readonly>
            <input type="text" name="title" value="${board.title}" required>
            <textarea name="content" rows="10" required>${board.content}</textarea>
            <button type="submit" style="background: #2563eb; color: white; border: none; padding: 15px; width: 100%; cursor: pointer;">수정완료</button>
        </form>
    </div>
</body>
</html>