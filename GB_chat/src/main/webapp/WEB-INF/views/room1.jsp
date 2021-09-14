<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디1</title>
<style>
.chat-box {
  background: #98C4C7;
  float: right;
}

</style>

</head>
<body>
<h3>${room1 }스터디 방입니다.</h3>
<div class ="chat-box" >		
	<div id="stage">${room1 }스터디의 채팅방</div> 
	<p></p>		
	<%@ include file="chat.jsp" %>															
	
</div>
</body>
</html>