<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>회원수정</title>
	<style>
		#header {
			background-color:gray;
			height:100px;
		}
		#nav {
			background-color:green;
			color:white;
			width:200px;
			height:700px;
			float:left;
		}
		#section {
			width:200px;
			text-align:left;
			float:left;
			padding:10px;
		}
		#footer {
			background-color:gray;
			height:100px;
			clear:both;
		}
		
		#header, #nav, #section, #footer { text-align:center; }
		#header, #footer { line-height:100px; }
		/* #nav, #section { line-height:240px; } */
	</style>
</head>
<body>    
    <div id="header">
		<a href="../">header</a><br>
		
	</div>
	
	<div id="nav">
		
		<ul>
		  <li><a href="./update">정보수정</a></li><br><br>
		  <li><a href="list">내판매글/구매내역</a></li><br><br>
		  <li>내 찜 목록</li><br><br>
		  <li>택배조회</li><br><br>
		  <li>회원탈퇴</li>
		</ul>
	</div>
	
	<div id="section">
	<p>정보수정페이지</p>
		<p>
			<img alt="" src="../resources/upload/member/${member.myPageFileDTO.fileName}" onerror="this.onerror-null; this.src='../resources/images/imgtest.jpeg';">
		</p>
		<button type="button">수정</button>
	</div>
	
	<div id="section">
		<br><br>
		<p>이름</p>
		<input type="text" value="${member.name}">
		<br>
		<p>비밀번호</p>
		<input type="password" value="${member.userPw}">
		<br>
		<p>비밀번호 확인</p>
		<input type="password" value="${member.userPw}">
		<br>
		
		<p>자기소개</p>
		<input type="text" value="${member.intro}">
		
	</div>
	
	
	
	<div id="footer">
		<h2>FOOTER</h2>
	</div>
    
</body>
</html>
