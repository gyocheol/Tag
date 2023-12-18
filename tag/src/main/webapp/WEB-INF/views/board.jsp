<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>

<%--<html lang="en">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--    <title>게시판 목록</title>--%>
<%--    <!-- 여기에 필요한 스타일 및 스크립트를 추가할 수 있습니다. -->--%>
<%--</head>--%>
<%--<body>--%>
<%--<div class="container" style="text-align: center;">--%>
<%--    <br/>--%>
<%--    <h3 id="font-h3">게시판 목록</h3>--%>
<%--    <br/><br/>--%>
<%--    <table style="width: 700px; margin: auto">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th style="width: 10%">번호</th>--%>
<%--            <th style="width: 50%">제목</th>--%>
<%--            <th style="width: 15%">작성자</th>--%>
<%--            <th style="width: 15%">등록일</th>--%>
<%--            <th style="width: 10%">댓글 수</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach items="${boardList.content}" var="board" varStatus="loop">--%>
<%--            <tr>--%>
<%--                <td>${loop.index+1}</td>--%>
<%--                <td style="text-align: left"><a href="board/${board.id}">${board.title}</a></td>--%>
<%--                <td>${board.name}</td>--%>
<%--                <td>${board.createdDate}</td>--%>
<%--                <td>${board.commentCnt}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>
<%--    <nav aria-label="Page navigation">--%>
<%--        <ul class="pagination justify-content-center">--%>
<%--            <!-- 페이지 그룹 -->--%>
<%--            <c:forEach begin="${startPage}" end="${endPage}" var="i">--%>
<%--                <li class="page-item <c:if test='${nowPage == i}'>active</c:if>">--%>
<%--                    <a class="page-link" href="?page=${i}">${i}</a>--%>
<%--                </li>--%>
<%--            </c:forEach>--%>
<%--        </ul>--%>
<%--    </nav>--%>
<%--    <a href="createBoard">새글 등록</a>--%>
<%--</div>--%>
<%--</body>--%>
<%--</html>--%>

<%--<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="ko">--%>
<%--<head>--%>
<%--    <meta charset="UTF-8">--%>
<%--    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
<%--    <title>게시판</title>--%>
<%--    <!-- 부트스트랩 CSS 링크 -->--%>
<%--    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>

<%--<div class="container mt-5">--%>
<%--    <h2>게시판</h2>--%>
<%--    <table class="table table-bordered mt-3">--%>
<%--        <thead>--%>
<%--        <tr>--%>
<%--            <th scope="col">번호</th>--%>
<%--            <th scope="col">제목</th>--%>
<%--            <th scope="col">작성자</th>--%>
<%--            <th scope="col">작성일</th>--%>
<%--            <th scope="col">댓글 수</th>--%>
<%--        </tr>--%>
<%--        </thead>--%>
<%--        <tbody>--%>
<%--        <c:forEach var="board" items="${boardList.content}" varStatus="loop">--%>
<%--            <tr>--%>
<%--                <td>${loop.index+1}</td>--%>
<%--                <td>${board.title}</td>--%>
<%--                <td>${board.name}</td>--%>
<%--                <td>${board.createdDate}</td>--%>
<%--                <td>${board.commentCnt}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--    </table>--%>

<%--    <div class="d-flex justify-content-center mt-4">--%>
<%--        <nav aria-label="Page navigation example">--%>
<%--            <ul class="pagination">--%>
<%--                <li class="page-item<c:if test="${nowPage == 1}"> active</c:if>">--%>
<%--                    <a class="page-link" href="?page=1">1</a>--%>
<%--                </li>--%>
<%--                <c:forEach begin="2" end="${boardList.totalPages}" var="page">--%>
<%--                    <li class="page-item<c:if test="${nowPage == page}"> active</c:if>">--%>
<%--                        <a class="page-link" href="?page=${page}">${page}</a>--%>
<%--                    </li>--%>
<%--                </c:forEach>--%>
<%--            </ul>--%>
<%--        </nav>--%>
<%--    </div>--%>
<%--</div>--%>

<%--<!-- 부트스트랩 JS 및 jQuery, Popper.js 링크 -->--%>
<%--<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>--%>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>--%>
<%--<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>--%>

<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>게시판</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container mt-5">
        <h2>게시판</h2>
        <table class="table table-bordered mt-3">
            <thead>
            <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="board" items="${boardList.content}" varStatus="loop">
                <tr>
                    <td>${loop.index+1}</td>
                    <td>${board.title}</td>
                    <td>${board.name}</td>
                    <td>${board.createdDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <!-- page 현재 2페이지에서 3페이지 버튼까지 뜨는 현상..-->
    <div class="d-flex justify-content-center mt-4">
        <nav aria-label="Page navigation example">
            <ul class="pagination">
                <c:forEach begin="1" end="${boardList.totalPages+1}" var="pageNumber">
                    <li class="page-item<c:if test="${nowPage == pageNumber}"> active</c:if>">
                        <a class="page-link" href="?page=${pageNumber-1}">${pageNumber}</a>
                    </li>
                </c:forEach>
            </ul>
        </nav>
    </div>
<!-- 부트스트랩 JS 및 jQuery, Popper.js 링크 -->
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</body>
</html>
