<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	
</h1>

<table class="table table-dark table-hover">
		<h1>메인 페이지</h1>
<%-- <c:if test="${not empty sessionScope.member}">
		
		<h1>로그인 상태</h1>
	</c:if>
	<c:if test="${empty member}">
	<h1>비로그인 상태</h1>
	</c:if> --%>
	
	<p>
		${member.userId}<%--  : ${sessionScope.member.name} --%>        님 환영합니다.
	</p>
		
		<a class="btn btn-primary" href="../my/login">로그인(삭제예정)</a><br>
		<a class="btn btn-primary" href="../my/test">member리스트(삭제예정)</a><br>
		<a class="btn btn-primary" href="../my/join">회원가입(삭제예정)</a><br>
		
		<c:if test="${not empty sessionScope.member}">
			<a class="btn btn-primary" href="../my/mypage">마이페이지</a><br>
		</c:if>
		<a class="btn btn-primary" href="../my/mypage">마이페이지</a><br>
		<!-- <thead>
			<th>번호</th><th>아디</th><th>비번</th>
		</thead>
		 -->
		 
		 <tbody>
			 <c:forEach items="${list}" var="d">
				<tr>
				<td>${d.userNo}</a></td>
				<td>${d.userId}</td>
				<td>${d.userPw}</td>
				</tr>
			</c:forEach> 	
		</tbody>
	</table>



</body>
</html>
