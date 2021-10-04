<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>스터디 모집 게시판</h1>
	<!--DB에서 가져와서 실시간 반영. mapper. ajax로 검색  -->
	<!--private String study_name; //스터디 모임 이름
	private String study_tag; //스터디 종류 태그
	private String region; //오프라인 장소
	private int max_member; //인원 제한수   -->
	
	<table border="2">
	<thead> <tr><th>이름</th> <th>태그</th><th>장소</th><th>정원</th></tr></thead>
	<tbody>
		<c:forEach var="imsi" items="${alist}">
			<tr>
				<td>${imsi.study_name }</td>
				<td>${imsi.study_tag }</td>
				<td>${imsi.region }</td>
				<td>${imsi.max_number}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<!--form, controller로 검색 만들기..  -->
<div id="holder">
	<!--동적 버튼 생성  -->
	
	<div id="create_btn">
	<!--버튼 누를 시 새로운 버튼형태로 스터디 목록을 볼 수 있다.  -->
	<form action="new_study" method="post">		
		<button id= "study_create" type="submit" name="study_create">스터디 만들기</button>		
	</form>
	</div>
</div>

</body>
</html>