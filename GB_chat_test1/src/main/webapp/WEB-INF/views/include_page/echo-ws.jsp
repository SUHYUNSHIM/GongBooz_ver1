<%@ page session="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.4.0/sockjs.min.js"></script>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
<script>
//전역변수 선언-모든 홈페이지에서 사용 할 수 있게 index에 저장
var socket = null;
$(document).ready(function(){
    if(!isEmpty($("#session_id").val()))
            connectWS();
});
    $(".chat_start_main").click(function(){
        $(this).css("display","none");
        $(".chat_main").css("display","inline");
    })
    $(".chat_main .modal-header").click(function(){
        $(".chat_start_main").css("display","inline");
        $(".chat_main").css("display","none");
    });
 
    function connectWS(){
        var sock = new SockJS("/echo");
            socket =sock;
        sock.onopen = function() {
               console.log('info: connection opened.');
        };
        sock.onmessage = function(e){
//             console.log(e);
//             var strArray = e.data.split(":");
//             if(e.data.indexof(":") > -1){
//                 $(".chat_start_main").text(strArray[0]+"님이 메세지를 보냈습니다.");
//             }
//             else{
//             }
            $("#chat").append(e.data + "<br/>");
        }
        sock.onclose = function(){
            $("#chat").append("연결 종료");
//              setTimeout(function(){conntectWs();} , 10000); 
        }
        sock.onerror = function (err) {console.log('Errors : ' , err);};
 
        $("#chatForm").submit(function(event){
            event.preventDefault();
                sock.send($("#message").val());
                $("#message").val('').focus();    
        });
    }
</script>
</body>
</html>