<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
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
		<p>${member.userId} 님</p>
		
		<p>
			<img alt="" src="../resources/upload/member/${member.myPageFileDTO.fileName}"> 
		</p>
		
		<p text-align="left">자기소개</p>
		<p>${member.intro}</p>	
	</div>
	
	<div id="section">
		<p>판매횟수 : </p>
	</div>
	<div id="section">
		<p>구매횟수 : </p>
	</div>
	
	<div id="footer">
		<h2>FOOTER</h2>
	</div>
    
		<p>zzz</p>
		
		<p>
			<img alt="" src="../resources/upload/member/${member.myPageFileDTO.fileName}"> 
		</p>
		
		<p>
			<img alt="" src="../resources/upload/member/${member.myPageFileDTO.originalFileName}"> 
		</p>
		
		<p>
			<img alt="" src="../resources/upload/member/0cb08601-c0a8-4863-b66e-d41349a2cc2d_img1.jpg">
		</p>
</body>
</html>
