<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>


<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	 body::before{ 
      position: fixed; top: 0; left: 0; right: 0; bottom: 0;
      background-image:linear-gradient( rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2) ),
                   url("https://cdn.pixabay.com/photo/2016/06/16/13/00/rain-stoppers-1461288_960_720.jpg");
      background-size:cover;   filter: blur(5px);   content: "";   z-index: -1;   transform: scale(1.05); } 
      
      a{
      	color:#ffffff;
      	margin:30px;
      	text-decoration:none;
      } 
</style>

</head>
<body>

<script>
	/* location.href="board/boardList.do"	 */
	/* location.href="boardkaja.do" */	
	
</script>
	<!--   <a href="board/boardList.do">자유 게시판</a>  
	  <a href="member/kajainfo.do">마이페이지</a>  
	  <a href="member/memberUpdateView.do">회원정보수정</a>  
	  <a href="member/memberDeleteView.do">회원탈퇴</a>  --> 
<!-- <a href="member/login.do">로그인 </a> -->
	

	<c:if test="${member != null}"><a href="member/logout.do">로그아웃</a></c:if>
	<c:if test="${member != null}"><a href="${pageContext.request.contextPath}/member/myinfo.do">마이페이지</a></c:if>
	<c:if test="${member == null}"><a href="member/login.do">로그인</a></c:if>
	<c:if test="${member != null}">
			<%-- <p style="color:white;">${member.userid}님 안녕하세요.</p> --%>
			<span style="color:white;">${member.userid}님 안녕하세요.</span>
	</c:if>


</body>

</html>