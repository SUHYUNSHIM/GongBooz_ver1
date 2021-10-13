<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href='${pageContext.request.contextPath}/resources/fullcalendar/main.css' rel='stylesheet' />
    <script src='${pageContext.request.contextPath}/resources/fullcalendar/main.js'></script>
    <script>

      document.addEventListener('DOMContentLoaded', function() {
        var calendarEl = document.getElementById('calendar');
        var calendar = new FullCalendar.Calendar(calendarEl, {
          initialView: 'dayGridMonth',
          googleCalendarApiKey: 'AIzaSyAo_lknaQtrqzHbvRGYxYkVAys07lLWu-c',
          events: {
            googleCalendarId: 'b0dp00003s6p9fd2hmoi65g6i8@group.calendar.google.com',
            className: 'gcal-event' // an option!
          },
          eventClick: function(info){
        	  info.jsEvent.stopPropagation();
        	  info.jsEvent.preventDefault();
          }
        });
        calendar.render();
      });

    </script>
<style>
	
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
	#calWrap{
		width:730px;
		   background-color:#FFFFF0;  
		/* margin:300px auto; */
		/* color:black; */
		border:1px solid #ffffff;
		/* margin-left:30px; */
		
		 box-shadow:  2px 5px 16px 0px, 5px 5px 15px 5px rgba(0,0,0,0);
			       border-radius:4px;
	}
	
	#calendar{
		width:700px;
		margin:0px auto;
		padding-top: 30px;
		padding-left: 40px;
		padding-right: 40px;
		 padding-bottom:70px; 
	}
	h2{
		margin-left:70px;
		padding-top:40px;
		
	}

</style>
</head>
<body>
 <div id="calWrap">
 	<h2>주요기업 취업일정 공고</h2>
 	<div id='calendar'>
 	
 </div>
</div>
 

</body>
</html>