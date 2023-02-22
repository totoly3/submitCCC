<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
<html>
<head>

  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1> 카카오페이 결제해보기 </h1>
 
 <button id="jq" onclick="pay()">결제하기</button>
 
 <script>
 function pay(){
	 jQuery.ajax({
		    url:"kakaopayCls",
		    dataType:'json',
		    success:function(data){
		    	
 		    	   var box= data.next_redirect_pc_url;
		    	    window.open(box);
		    	  alert("성공");
		    },
		    error:function(error){
		        alert(error);
		    }
		});

 };
 </script>
 
 
</body>
</html>