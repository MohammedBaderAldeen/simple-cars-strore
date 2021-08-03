<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.demo.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Parametars</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/css.css" rel="stylesheet">
</head>
<body>


	<div class="container text-center">
		<h3>Edit Parametars</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="/saveParametars">
			<input type="hidden" name="id"
				value="${parametars.id}"/> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<!--  for CSRF secirty -->

			<div class="form-group">
				<label class="control-label col-md-3">Count Seat</label>
				<div class="col-md-7">
					 <input type="text" class="form-control" name="count_seat"
						value="${parametars.count_seat}" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Earning</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="earning"
						value="${parametars.earning}" />
				</div>
			</div>
			

			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Update" />
			</div>
		</form>
	</div>
</body>
</html>