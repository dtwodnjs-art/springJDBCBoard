<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>게시글 작성</title>
    <style>
        body { font-family: 'Pretendard', sans-serif; background: #f4f7f6; padding: 40px; }
        .container { max-width: 600px; margin: auto; background: white; padding: 30px; border-radius: 12px; box-shadow: 0 4px 15px rgba(0,0,0,0.05); }
        h2 { border-bottom: 2px solid #2563eb; padding-bottom: 10px; color: #333; }
        input, textarea { width: 100%; padding: 12px; margin: 10px 0; border: 1px solid #ddd; border-radius: 8px; box-sizing: border-box; }
        .btn-submit { background: #2563eb; color: white; border: none; padding: 15px; border-radius: 8px; cursor: pointer; width: 100%; font-weight: bold; font-size: 16px; margin-top: 10px; }
        .back-link { display: block; text-align: center; margin-top: 20px; color: #666; text-decoration: none; }
    </style>
</head>
<body>
    <div class="container">
        <h2>새 글 작성</h2>
        <form action="/board2/insert2" method="post">
            <input type="text" name="userId" placeholder="작성자 아이디" required>
            <input type="password" name="userpassword" placeholder="비밀번호" required>
            <input type="text" name="title" placeholder="제목을 입력하세요" required>
            <textarea name="content" rows="10" placeholder="내용을 입력하세요" required></textarea>
            <button type="submit" class="btn-submit">등록하기</button>
        </form>
        <a href="/board2/boardList" class="back-link">목록으로 돌아가기</a>
    </div>
</body>
</html>