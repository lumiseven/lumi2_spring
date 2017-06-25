<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>HttpMessageConverter Demo</title>
  </head>
  <body>
  	<div id="resp"></div>
  	<input type="button" onclick="req();" value="request"/>
  </body>
  <script type="text/javascript" src="asserts/js/jquery.min.js"></script>
  <script>
  	function req(){
  		$.ajax({
  			url: "convert",
  			data: "7-lumiseven",
  			type: "POST",
  			contentType: "application/lumiseven",
  			success: function(data){
  				$("#resp").html(data);
  			}
  		});
  	}
  </script>
</html>
