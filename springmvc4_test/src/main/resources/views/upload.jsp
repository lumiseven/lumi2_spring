<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>springMVC file upload test</title>
  </head>
  <body>
  	<div class="upload">
  		<form action="upload" enctype="multipart/form-data" method="post">
  			<input type="file" name="file">
  			<br/>
  			<input type="submit" value="uploadFileHere">
  		</form>
  	</div>
  </body>
</html>
