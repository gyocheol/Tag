<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>게시판 목록</title>
    <!-- 여기에 필요한 스타일 및 스크립트를 추가할 수 있습니다. -->
</head>
<body>
<div class="container" style="text-align: center;">
    <br/>
    <h3 id="font-h3">게시판 목록</h3>
    <br/><br/>
    <table style="width: 700px; margin: auto">
        <thead>
        <tr>
            <th style="width: 10%">번호</th>
            <th style="width: 50%">제목</th>
            <th style="width: 15%">작성자</th>
            <th style="width: 15%">등록일</th>
            <th style="width: 10%">댓글 수</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList.content}" var="board" varStatus="loop">
            <tr>
                <td>${loop.index+1}</td>
                <td style="text-align: left"><a href="board/${board.id}">${board.title}</a></td>
                <td>${board.name}</td>
                <td>${board.createdDate}</td>
                <td>${board.commentCnt}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
            <!-- 페이지 그룹 -->
            <c:forEach begin="${startPage}" end="${endPage}" var="i">
                <li class="page-item <c:if test='${nowPage == i}'>active</c:if>">
                    <a class="page-link" href="?page=${i}">${i}</a>
                </li>
            </c:forEach>
        </ul>
    </nav>
    <a href="createBoard">새글 등록</a>
</div>
</body>
</html>