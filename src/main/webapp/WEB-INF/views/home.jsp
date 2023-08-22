<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!   ㅇㅇ
</h1>

<table class="table table-dark table-hover">
		<thead>
			<th>번호</th><th>아디</th><th>비번</th>
		</thead>
		<tbody>
			<%-- <c:forEach items="${list}" var="d">
				<tr>
				<td>${d.userNo}</a></td>
				<td>${d.userId}</td>
				<td>${d.userPw}</td>
				</tr>
			</c:forEach> --%>		
		</tbody>
	</table>

<P> ${list}. </P>

<a class="btn btn-primary" href="../my/login">로그인</a>
</body>
</html>
