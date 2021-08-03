<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.demo.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Erorr</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/css.css" rel="stylesheet">
</head>
<body>


	<div class="container text-center">
		<h3>Erorr</h3>
		<hr>
		<form class="form-horizontal" method="GET" action="/Home">
			 <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<!--  for CSRF secirty -->

			<div class="form-group">
				<label class="control-label col-md-3">Erorr this car is update by another one</label>
			</div>


			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="OK" />
			</div>
		</form>
	</div>
</body>
</html>