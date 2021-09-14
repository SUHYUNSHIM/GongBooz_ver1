<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디룸 </title>
</head>
<body>
<%@ include file="hello.jsp" %>
${name} 님 환영합니다. <!--로그인 후 다시 돌아와서 아이디가 표시되어야 한다.  -->
<form action="studyroom" method="get">
	<button id="goto_study" type="submit" value="HSK" name="room1">스터디1</button>
</form>
</body>
</html>