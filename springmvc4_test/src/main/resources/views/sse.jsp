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
  		if (!!window.EventSource){
  			var source = new EventSource('push');
  			s='';
  			source.addEventListener('message', function(e){
  				s+=e.data+"<br/>";
  				$("#msgFromPush").html(s);
  			});
  			
  			source.addEventListener('open', function(e){
  				console.log("connection openning");
  			}, false);
  			
  			source.addEventListener('error', function(e){
  				if (e.eventPhase == EventSource.CLOSED){
  					console.log("connection terminal")
  				} else {
  					console.log(e.eventPhase);
  				}
  			}, false);
  		} else {
  			console.log("browser may not support SSE");
  		}
  	</script>
  </body>
</html>
