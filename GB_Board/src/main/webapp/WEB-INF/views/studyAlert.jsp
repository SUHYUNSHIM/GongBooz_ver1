<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<link href="${path}/resources/css/studyroomMain.css" rel="stylesheet"/>
<meta charset="UTF-8">

<title>스터디 입장</title>
</head>
<%
	String study_name = (String)request.getAttribute("study_name");

%>

<body>
<!--header title  -->
	<div class="modal-header">
		<h5 class="modal-title" id="insertModalLabel">스터디 참가</h5>
		<button class="close" type="button" data-dismiss="modal" aria-label="Close">
		<span aria-hidden="true">✖</span>
		</button>
	</div>
	
	<div class="modal-body">
		<%-- <form action="studyRoom.do" method="post"> --%>
			<div id="name">
			<%-- ${study_name} --%>
			"${study_name}"에 참가하시겠습니까?
			<%-- ${study_name}에  참가하시겠습니까? --%>
			</div>
		<a href="studyRoom.do?study_name=${study_name}">
		<input type="submit" value="참여하기" id="plus"> <!--id가 plus인 버튼의 css가 만들어져있다.  -->
		</a>
		<%-- </form> --%>
	</div>

</body>
</html>