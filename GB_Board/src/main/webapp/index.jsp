<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스터디 모집 메인 게시판</title>
</head>
<body>
<!--동적 버튼 생성  -->

<!--버튼 누를 시 새로운 버튼형태로 스터디 목록을 볼 수 있다.  -->
<form action="new_study" method="post">
<div style='width:80px;'>


<!--studyAll.jsp  -->
<button id= "study_create" type="submit" name="study_create">스터디 만들기</button>
</div>
</form>
<h1>스터디 선택 버튼들이 나타나는 영역</h1>
<!--스터디 전체 목록이 나타나야 한다. include. 데이터베이스에서 가져오기. 실시간 반영. include  -->	
<script>
	location.href="studyAll.do"  //기존의 mybatis project에서 한 방법*/
	
	//스터디명 검색할 때 ajax 쓰기. gbMusic, gbMain 참조 
	function searchStudy(){
		var selectedTag = $().val();
	}
	
	</script>
<script>
</script>
</body>
</html>