<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SSE Demo</title>
  </head>
  <body>
  	<div id="msgFromPush"></div>
  	<script type="text/javascript" src="<c:url value='asserts/js/jquery.min.js'/>"></script>
  	<script type="text/javascript">
  		function deferred(){
  			$.get('defer', function(data){
  				console.log(data);
  				deferred();
  			});
  		}
  		deferred();
  	</script>
  </body>
</html>
