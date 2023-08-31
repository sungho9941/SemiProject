<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	
	<style>
		div.left {
	   width: 40%; //원하는 사이즈 만큼 조절
	   float: left;
	   position: relative;
		}
	
		div.right {
	   width: 60%; //원하는 사이즈 만큼 조절
	   float: right;
	   position: relative;
		}
	</style>
</head>
<body>    

    <c:import url="../temp/header1.jsp"></c:import>
	
	<div class='left'>test</div>
	<div class='right'>test</div>
	
	
	<div id="nav">
		
		<ul>
		<li><a href="./mypage">마이페이지</a></li><br><br>
		  <li><a href="./check">정보수정</a></li><br><br>
		  <li><a href="./list">내판매글/구매내역/후기</a></li><br><br>
		  <li>내 찜 목록</li><br><br>
		  <li>택배조회</li><br><br>
		  <li><a href="./management">상품관리</a></li><br><br>
		  <li><a href="./delete">회원탈퇴</a></li>
		</ul>
	</div>
	
	<div id="section">
	<p>마이페이지</p>
		<p>
			<img alt="" src="../resources/upload/member/${member.myPageFileDTO.fileName}" onerror="this.onerror-null; this.src='../resources/img/imgtest.jpeg';" width="200"; height="300">
		</p>
	</div>
	
	<div id="section">
		<p>${member.userId} 님</p>
		<p>${member.email}</p>
		
		<p>자기소개 : ${member.intro}</p>
		
		<p>판매횟수 : </p>
		<p>구매횟수 : </p>
	</div>
	
	
	
	<c:import url="../temp/footer1.jsp"></c:import>
    
</body>
</html>