<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.demo.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create User</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/css.css" rel="stylesheet">
</head>
<body>

	

	<div class="container text-center">
		<h3>Create User</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="/AddUser">
		
		
			<input type="hidden" name="id"  />
			
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}" />
			<!--  for CSRF secirty -->
			
			<div class="form-group">
				<label class="control-label col-md-3">User Name</label>
				<div class="col-md-7">
					<input type="text" required class="form-control" name="userName" 
						 />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">Password</label>
				<div class="col-md-7">
					<input type="text" required class="form-control" name="password" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">Roles</label>
				<div class="col-md-7">
					<input type="text" required class="form-control" name="roles"  />
				</div>
			</div>
			
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Save" />
			</div>
		</form>
	</div>


</body>
</html>