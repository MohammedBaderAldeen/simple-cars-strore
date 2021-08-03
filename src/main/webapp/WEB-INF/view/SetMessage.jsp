<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.example.demo.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send Message Queue</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/css.css" rel="stylesheet">
</head>
<body>

	<%
	    MyMessage message = (MyMessage) request.getAttribute("message");
		Cars car = (Cars) request.getAttribute("car");
	%>

	<div class="container text-center">
		<h3>Send Message Queue</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="/SendQueue?id=<%out.print(car.getId());%>">
			<input type="hidden" name="id"
				value="<%out.print(car.getId());%>" /> <input
				type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
			<!--  for CSRF secirty -->

			<div class="form-group">
				<label class="control-label col-md-3">Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="name_car"
						value="<%out.print(message.getData().getName_car());%>" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-md-3">Price</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="price"
						value="<%out.print(message.getData().getPrice());%>" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">Count Seat</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="count_seat"
						value="<%out.print(message.getData().getCount_seat());%>" />
				</div>
			</div>
			
				<div class="form-group">
				<label class="control-label col-md-3">Buyer Name</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="buyer_name"
						value="<%out.print(message.getData().getBuyer_name());%>"/>
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">Sale Price</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="sale_price"
						value="<%out.print(message.getData().getSale_price());%>" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-md-3">Email</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="email"/>
				</div>
			</div>
			
						

			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="Send Message" />
			</div>
		</form>
	</div>
</body>
</html>