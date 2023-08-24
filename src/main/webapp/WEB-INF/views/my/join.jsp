<!-- 테스트용으로 나중에 삭제 -->

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1 class="mt-4 mb-4">join page</h1>
	
	
	
	<form action="./join" method="post" enctype="multipart/form-data" id="frm">
	<div class="mb-4">
	 <label for="id" class="form-label">id</label>
 	 <input type="text" name="id" class="form-control" id="id" placeholder="id를 입력하세요">
	<span id="idx"></span>
	</div>

	<div class="mb-4">
	 <label for="pw" class="form-label">pw</label>
 	 <input type="password" name="pw" class="form-control" id="pw" placeholder="pw를 입력하세요">
	  <span id="pwx"></span>
	</div>

	<div class="mb-4">
		<label for="pw" class="form-label">pw</label>
		 <input type="password" name="pw2" class="form-control" id="pw2" placeholder="pw를 입력하세요">
		 <span id="pwx2"></span>
		</div>
	
	<div class="mb-4">
	 <label for="name" class="form-label">name</label>
 	 <input type="text" name="name" class="form-control" id="name" placeholder="name을 입력하세요">
	  <span id="namex"></span>
	</div>
	
	<div class="mb-4">
	 <label for="email" class="form-label">email</label>
 	 <input type="email" name="email" class="form-control" id="email" placeholder="email을 입력하세요">
	  <span id="emailx"></span>
	</div>
	
	<div class="mb-4">
	 <label for="birth" class="form-label">birth</label>
 	 <input type="date" name="birth" class="form-control" id="birth" placeholder="email을 입력하세요">
	  <span id="birthx"></span>
	</div>
	
	<div class="mb-4">
	 <label for="pic" class="form-label">사진첨부</label>
 	 <input type="file" name="pic" class="form-control" id="pic" placeholder="email을 입력하세요">
	</div>
	
	<div class="mb-3">
		<button type="submit">회원가입</button>
	</div>
	
	</form>
</body>
</html>