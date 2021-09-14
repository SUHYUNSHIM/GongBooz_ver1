<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post" onsubmit="return checkSubmit()">
아이디<input type="text" name="name"><br>
<input type="submit" value="전송">
</form>

<script>
	function checkSubmit(){
		if(!confirm("참가하시겠습니까?")){
			return false;
		}
	}
</script>
</body>
</html>