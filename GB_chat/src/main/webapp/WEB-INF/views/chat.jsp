<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.js"></script>
<script type="text/javascript"
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.1.5/sockjs.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
String name = (String)session.getAttribute("name");
%>
	<h3><%=name %> 님 환영합니다. </h3>
	<input type="text" id="message"/>
	<input type="button" id="sendBtn" value="submit"/>
	<div id="messageArea"></div>
</body>

<script type="text/javascript">
	$("#sendBtn").click(function() {
		sendMessage();
		$('#message').val('')
	});

	let sock = new SockJS("http://00fc-61-75-24-48.ngrok.io/wn/echo"); //http://ngrok주소/wn/echo/  ea35-61-75-24-48.ngrok.io
	//let sock = new SockJs("http://localhost:20219/wn/echo");
	//let sock = new SockJf("http://localhost:21092/wn/echo");
	sock.onmessage = onMessage;
	sock.onclose = onClose;
	// 메시지 전송
	function sendMessage() {
		sock.send($("#message").val());
	}
	// 서버로부터 메시지를 받았을 때
	function onMessage(msg) {
		var data = msg.data;
		$("#messageArea").append("<%=name%>:"+ data + "<br/>");
	}
	// 서버와 연결을 끊었을 때
	function onClose(evt) {
		$("#messageArea").append("연결 끊김");

	}
</script>

</html>