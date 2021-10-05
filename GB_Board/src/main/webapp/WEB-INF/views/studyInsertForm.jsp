<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 등록</title>
</head>
<body>
	<h1>스터디 등록하기 </h1>
	<form action="studyInsert.do" method="post">
	<h3>스터디 이름 <input type="text" name="study_name"></h3>
	<h3>스터디 종류 <select name="study_tag">
		<option value="외국어">외국어</option>
		<option value="면접">면접</option>
		<option value="스터디윗미">스터디윗미</option>
		<option value="대외활동">대외활동</option>
		<option value="자격증">자격증</option>
		<option value="공무원">공무원</option>
		<option value="기타">기타</option>
	</select>
	
	<h3>오프라인 모임 장소 <input type="text" name="region"></h3>
	<h3>정원 <input type="text" name="max_number"></h3>
	<input type="submit" value="등록하기"></h3>
	</form>
</body>
</html>