<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<style>
 @import url('https://fonts.googleapis.com/css2?family=Sacramento&display=swap');
 
 body::before{ 
    position: fixed; top: 0; left: 0; right: 0; bottom: 0;
    background-image:linear-gradient( rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2) ),
                 url("https://cdn.pixabay.com/photo/2016/06/16/13/00/rain-stoppers-1461288_960_720.jpg");
    background-size:cover;   filter: blur(5px);   content: "";   z-index: -1;   transform: scale(1.05); } 
	
	.findid{
	
	margin: 170px auto;
	width:300px;
	/* background-color:white; */
	background: transparent;
	padding:30px;
	box-shadow:  2px 5px 16px 0px, 5px 5px 15px 5px rgba(0,0,0,0);
	 border:none;
	 border-bottom: 1px solid #ddd;
	  overflow: hidden;
	 border-radius:4px;
	  border:1px solid #ddd;
	  
}
	
	
	.btn{
		width:290px;
		height:30px;
		background-color:#E4F7BA;
		color:#4C4C4C;
		border:none;
		border-radius:4px;
		font-weight:bold;
	}
	
	.btn1{
		width:290px;
		height:30px;
		margin-top:17px;
		background-color:#E4F7BA;
		color:#4C4C4C;
		border:none;
		border-radius:4px;
		font-weight:bold;
	}
	
	.btn:hover{
		background-color:#D2E5A8;
	}
	.btn1:hover{
		background-color:#D2E5A8;
	}
	
	
	h5{
		text-align:center;
		color:#ffffff;
	}
	
	.welcome{
		text-align:center;
		color:#ffffff;
	
	}
	.logo{
		 color:#ffffff;
		 text-align:center;
		 margin-bottom:70px;
	}
	
	.gongbooz {
           color:#ffffff;
           margin-bottom:70px;
           margin-top:40px;
           font-family: 'Sacramento', cursive;
           font-size:40px;
       }

</style>

<script>
	$(function(){
		$("#loginBtn").click(function(){
			location.href='login.do';
		})
	})
</script>
</head>
<body>
<div id="findWrap">
		<div class="findid">
			<div class="logo">
	       <p class="gongbooz">GongBooZ</p> 
			</div>
			<div class="w3-center w3-large w3-margin-top">
				<!-- <h3>아이디 찾기 검색결과</h3> -->
				<p class="welcome">아이디 찾기 검색결과</p>
			</div>
			<div>
			<%-- 	<h5>
					${ id }
				</h5> --%>
				
				<c:forEach items="${array}" var = "list">
				<h5>${list.userid}</h5>
				</c:forEach>
				<p class="w3-center">
					<button type="button" id=loginBtn class="btn">Login</button>
					<button type="button" onclick="history.go(-1);" class="btn1">Cancel</button>
				</p>
			</div>
		</div>
	</div>
</body>
</html>