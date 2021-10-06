<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GongBooz-online study</title>
<link href="${path}/resources/css/studyroomMain.css" rel="stylesheet"/>
</head> 
<body>
	<h1>스터디 모집 게시판</h1>
	<!--DB에서 가져와서 실시간 반영. mapper. ajax로 검색  -->
	<!--private String study_name; //스터디 모임 이름
	private String study_tag; //스터디 종류 태그
	private String region; //오프라인 장소
	private int max_number; //인원 제한수   -->
	
<!--검색 창  -->
<section class="sc-search">
	<form action="search-controller.do" method="post">
		<select name="filter">
			<option value="study_name">스터디명</option>
			<option value="study_tag">태그</option>
			<option value="region">오프라인 지역</option>
		</select>	
		<input type="text" name="search" placeholder="필터에 맞춰 검색해보세요" style="width:300px">
		<input type="submit" value="검색">
	</form>
</section>

<section class ="sc-search">

<!--form, controller로 검색 만들기..  -->

	<!--동적 버튼 생성  -->
	
	<div id="create_btn">
	<!--버튼 누를 시 새로운 버튼형태로 스터디 목록을 볼 수 있다.  -->
	<form action="studyInsertForm.do" method="post">		
		<h3>스터디 목록&nbsp;&nbsp;<button id= "study_create" type="submit" name="study_create">스터디 만들기</button></h3>	
	</form>
	</div>
</section>

<div id="search_result">

	

	<table border="2">
		<thead> <tr><th>이름</th> <th>태그</th><th>장소</th><th>정원</th></tr></thead>
		<tbody>
			<c:forEach var="imsi" items="${alist}" varStatus="status">
			[${status.index}]:${alist[status.index].study_name}
				<tr>
					<td>${imsi.study_name }</td>
					<td>${imsi.study_tag }</td>
					<td>${imsi.region }</td>
					<td>${imsi.max_number}</td> <!--스터디 가입하기 버튼 누르면 0/max_number->1/max_number 순으로 들어가야 한다.  -->
			</tr>			
			</c:forEach>
		</tbody>
		</table>	
</div>
<!-- https://offbyone.tistory.com/367  c ,jstl 문법-->

<br></br>
<section class = "sc-holder">
	<div class="studyroom-container">	
		<c:forEach items="${alist}" varStatus="status">	
		<div id="studyroom">
			${status.count} ${alist[status.count].study_name} ${alist[status.count].study_tag}
			${alist[status.count].region}
			${alist[status.count].max_number}<br></br>
		
		<c:if test= "${status.count eq 3}">
			<c:out value="줄바꾸기" />
			<p></p>	
		</c:if>		
		</div>		
		</c:forEach>			
		<!--table에서 studyrooom 하나의 div 클래스들 형태로 바꿔야 한다.  티켓박스 공연 좌석 표 만들때 코드 참조-->
		<!--태그 클래스 명따라서 안에 innterHtml로 쓴다  -->
	
	</div>
</section> 
</body>
</html>