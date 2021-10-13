<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
			 li {list-style: none; float: left; padding: 6px;} 
			
			*{
				margin:0;
				padding:0;
			  /*   color:white; */
			}
			
	 	 	   body::before{ 
      position: fixed; top: 0; left: 0; right: 0; bottom: 0;
      background-image:linear-gradient( rgba(0, 0, 0, 0.2), rgba(0, 0, 0, 0.2) ),
                   url("https://cdn.pixabay.com/photo/2016/06/16/13/00/rain-stoppers-1461288_960_720.jpg");
      background-size:cover;   filter: blur(5px);   content: "";   z-index: -1;   transform: scale(1.05); }  
			
			table{
				
				border-collapse:collapse;
			}
			
			a{
				text-decoration : none;
				/* color: inherit; */
				/* color:white; */
			}
			/* 상하좌우 전부 안쪽 여백 주기 */
			#root{
				padding: 50px;
				/* width:700px; */
				background-color:#FFFFF0; 
				margin-top:100px;
				/* margin-left:50px; */
				width:100%;
				
				height:540px;
				
				
			}
			
			.head{
			  margin-bottom:10px;
			}
			
			.boardlist_wrap{
				width:700px;
				
				
				margin:0px auto;
			}
			
			.board_list{
				 width:700px; 
				
				/* 표 자체에 border-top주기  */
			 	border-bottom:2px solid #3c3a3a; 
				border-top:2px solid #3c3a3a; 
			}
			
			.board_list th{
				background-color:#3c3a3a;
				color:white;
				
			}
			
			.board_list th, .board_list td{
				/*위 아래 좌우 간격 이 너무 가까워서 padding 값을 준다.  */
				padding: 7px;
				
				font-size:12px;
			}
			
			/* 리스트 전체 가운데 정렬 */
			.board_list td{
				text-align:center;
				font-size:12px;
				
			}
			
			/* 제목만 왼쪽 정렬 */
			.board_list .tit{
				
				text-align:left;
			}
			
			.board_list .rep{
				font-size:13px;
			}
			
			/* a 태그에  마우스 올렸을 때   */
			
		 	 A:link {text-decoration:none; color:#000080}
			A:visited {text-decoration:none; color:#000080}
			A:active {text-decoration:none; color:#000080}   
			/*  A:link {text-decoration:none; color:white}
			A:visited {text-decoration:none; color:white}
			A:active {text-decoration:none; color:white}   */
			
			A:hover {text-decoration:none; color:#529CFF} 
			
			/*리스트 아래에만 경계선 넣기   */
			.board_list tr{
				border-bottom : 1px solid #ccc;
			}
			
			.container{
				 position:relative;
			}
			.paging{
				width:500px;
				
				/*  margin:0 70px; */
				font-size:14px;
	
			}
			
			.search{
				margin-bottom:7px;
				text-align:center;
				font-size:14px;
				
			
				
			}
			
			.search option{
					background-color:#FFFFF0;
			}
			
			.searchT{
				text-align:center;
				width:70px;
				height:21px;
				/* color:#000; */
				 background-color:#FFFFF0;
				 border-radius:4px;
			} 
			
			
			#searchBtn{
				 background-color:#3c3a3a;
				 color:white;
				  /*테두리없음*/
			     border: none;
			     width:40px;
			     height:21px;
			     border-radius:4px;
			}
			
			#keywordInput{
				width:300px;
				height:17px;
				 background-color:#FFFFF0;
				/* color:#000; */
			
				border-radius:4px;

			



			}
			
			.btn_bottom{
				margin-top:4px;
				font-size:14px;
				width:700px;
				
				
			}
			
			.btn_bottom .btn_list{
				text-align:left;
			}
			.btn_bottom .btn_write{
				text-align:right;
			}
			
			/* 		.btn1{
				 background-color:#3c3a3a;
				 color:white;
				  /*테두리없음*/
			     border: none;
			     width:40px;
			     height:21px;
			}
		 */
		 
		 .b_hover:hover{
		 	background-color:#ddd;
		 }
			
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 		<%
		 //로그인 했는지 확인
		 if(session.getAttribute("member")==null){
		%>
		 <script>
		  location.href="${pageContext.request.contextPath}/member/login.do";
		 </script>
		<%}%> --%>	
		<c:if test="${member.userid == null}">
								<!-- <p>로그인 후에 작성하실 수 있습니다.</p> -->
								<script>
									location.href="${pageContext.request.contextPath}/member/login.do";
	
								</script>
			</c:if> 

	
	 <c:if test="${member == null}"><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></c:if> 	
	
	<c:if test="${member != null}">
			<a href="${pageContext.request.contextPath}/member/logout.do">로그아웃</a>
			<a href="${pageContext.request.contextPath}/member/myinfo.do">마이페이지</a>
			<%-- <p style="color:white;">${member.userid}님 안녕하세요.</p> --%>
			<span style="color:white;">${member.userid}님 안녕하세요.</span>
			
	</c:if>
	
	<div id="root">
		<!-- 	<header>
				<h4> 자유롭게 의견을 남겨주세요</h4>
				<h3>Q&A</h3>
				<h5>자유롭게 의견을 남겨주세요</h5>
			</header>
			 -->
			
	
			
			
			<div class="boardlist_wrap">
			<!-- <section id="container"> -->
				<div class="head">	
					<h3>Q&A</h3>
					<h5>자유롭게 의견을 남겨주세요</h5>
				</div>	
					<!--검색  -->
					<div class="search">
					    <select class="searchT" name="searchType">
					      <option value="n"<c:out value="${scri.searchType == null ? 'selected' : ''}"/>>전체</option>
					      <option value="t"<c:out value="${scri.searchType eq 't' ? 'selected' : ''}"/>>제목</option>
					      <option value="c"<c:out value="${scri.searchType eq 'c' ? 'selected' : ''}"/>>내용</option>
					      <option value="w"<c:out value="${scri.searchType eq 'w' ? 'selected' : ''}"/>>작성자</option>
					      <option value="tc"<c:out value="${scri.searchType eq 'tc' ? 'selected' : ''}"/>>제목+내용</option>
					    </select>
					
					    <input type="text" name="keyword" id="keywordInput" value="${scri.keyword}"/>
					
					    <button id="searchBtn" type="button">검색</button>
					    <script>
					      $(function(){
					        $('#searchBtn').click(function() {
					          self.location = "boardList.do" + '${pageMaker.makeQuery(1)}' + "&searchType=" + $("select option:selected").val() + "&keyword=" + encodeURIComponent($('#keywordInput').val());
					        });
					      });   
					    </script>
					  </div>	
				
				<form role="form" method="get">
					
					<table class="board_list">
						<tr>
							<th width=40>번호</th>
							<th width=380>제목</th>
							<th width=100>작성자</th>
							<th width=100>등록일</th>
							<th width=45>추천수</th>
							<th width=45>조회수</th>
						</tr>
						
						<c:forEach items="${boardList}" var = "list">
							 <tr>
								<td ><c:out value="${list.bno}" /></td>
								<td class="tit">
								<%-- <a href="boardView.do?bno=${list.bno}&page=${scri.page}&perPageNum=${scri.perPageNum}&searchType=${scri.searchType}&keyword=${scri.keyword}"> --%>
								<a href="boardView.do?bno=${list.bno}&page=${scri.page}&perPageNum=${scri.perPageNum}&searchType=${scri.searchType}&keyword=${scri.keyword}&userid=${member.userid}">
								<c:out value="${list.title}" /> 
									<%-- <span class="rep"> (${list.recnt})</span> --%>
									
									 <c:if test="${list.recnt > 0}">
										<span class="rep"> (${list.recnt})</span>
									</c:if>  
									
								</a>
								</td>
								<td><c:out value="${list.writer}" /></td>
								<td><fmt:formatDate value="${list.regdate}" pattern="yyyy-MM-dd"/></td>
								<td><c:out value="${list.blike}" /></td>
								<td><c:out value="${list.hit}" /></td>
							</tr> 
						</c:forEach>
					</table>
			
				<table class="btn_bottom">
					<tr >
						<td class="btn_list"><a class="btn1" href="boardList.do">목록</a></td>
						<td class="btn_write"><a class="btn2" href="boardInsert.do">글쓰기</a></td>
					</tr>
				</table>
					
			 	 <div class="paging" >
				  <ul>
				    	<li><a href="#">◀◀</a></li> 
				    <c:if test="${pageMaker.prev}">
				    	<li><a href="boardList.do${pageMaker.makeSearch(pageMaker.startPage - 1)}">◀</a></li>
				    </c:if> 
				
				    <c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="idx">
				    	<li><a href="boardList.do${pageMaker.makeSearch(idx)}">${idx}</a></li>
				    </c:forEach>
				
				    <c:if test="${pageMaker.next && pageMaker.endPage > 0}">
				    	<li><a href="boardList.do${pageMaker.makeSearch(pageMaker.endPage + 1)}">▶</a></li>
				    </c:if> 
				  		 <li><a href="#">▶▶</a></li> 
				  </ul>
				</div> 
											
				</form>
			<!-- </section> -->
		</div>
		</div>
</body>
</html>