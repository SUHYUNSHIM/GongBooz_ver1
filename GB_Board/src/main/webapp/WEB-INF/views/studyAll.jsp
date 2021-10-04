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
	
<!--검색 창  -->
<section class="sc-search searching">
	<form class="search-controller">
		<input type="text" placeholder="참여를 원하는 스터디를 검색해 보세요.">
		<button>검색</button>
	</form>
</section>

<!--form, controller로 검색 만들기..  -->
<section class ="sc-holder">
	<!--동적 버튼 생성  -->
	
	<div id="create_btn">
	<!--버튼 누를 시 새로운 버튼형태로 스터디 목록을 볼 수 있다.  -->
	<form action="new_study" method="post">		
		<button id= "study_create" type="submit" name="study_create">스터디 만들기</button>		
	</form>
	</div>

<br></br>

	<div class="studyroom-container">
	
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
		
		<!--table에서 studyrooom 하나의 div 클래스들 형태로 바꿔야 한다.  티켓박스 공연 좌석 표 만들때 코드 참조-->
		<!--태그 클래스 명따라서 안에 innterHtml로 쓴다  -->
		<div class="sc-studyroom rooms">
			<div class="study_tag">
			<div class="sc-studyroom tag">
				<p>외국어</p>
			</div>
			</div>
			<div class="study_name">
				<h3>토익 900 스터디</h3>
				<p>스터디 만든이</p>
			</div>
			<div class="study_info">
				<div class="study_info region">강남역 Y어학원</div>
				<div class="study_info users_num">1/5</div>
			</div>
		</div>	
	</div>
</section>
</body>
</html>