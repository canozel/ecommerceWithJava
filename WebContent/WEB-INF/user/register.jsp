<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kayıt</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/stylesheets/register.css"/>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="http://ajax.aspnetcdn.com/ajax/jquery.validate/1.15.0/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/javascripts/register.js"></script>
</head>
<body>
	<div class="container">
		<div class="title">Kayıt Ol</div>
		<form name="register" action="/register" method="post">
			<input id="email" type="text" name="email" placeholder= "ornek@ornek.com" ><br>
	  		<input id="password" type="password" name="password" placeholder="şifre"><br>
	  		<input type="submit" value="Kayıt Ol">
		</form>
	</div>
</body>
</html>