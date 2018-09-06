<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img src="${pageContext.request.contextPath}/Icon.png" >
	<h2>회원가입</h2>
	<form action="insert" method="">
		<label for="email">이메일</label>
		<input type="email" name="email" id="email" required="required" /><br />
		<label for="pw">비밀번호</label>
		<input type="password" name="pw" id="pw" required="required" /><br />
		<label for="name">이름</label>
		<input type="text" name="name" id="name" required="required" /><br />
		<label for="phone">전화번호</label>
		<input type="tel" name="pw" id="phone" required="required" /><br />
		<label for="addr">주소</label>
		<input type="text" name="addr" id="addr" required="required" /><br />
		
		<input type="submit" value="회원가입" />
		<input type="button" value="메인으로" onclick="location.href='../index.jsp'"/>
	</form>
</body>
</html>