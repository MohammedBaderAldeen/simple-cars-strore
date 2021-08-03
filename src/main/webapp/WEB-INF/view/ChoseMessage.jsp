<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="com.example.demo.model.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Car List</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<link href="static/css/css.css" rel="stylesheet">
</head>
<body>

	<%
		List<Cars> cars = (List<Cars>) request.getAttribute("cars");
	%>

	<div class="container text-center" id="tasksDiv">
		<h3>Cars List</h3>
		<hr>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>

						<th>Name</th>
						<th>price</th>
						<th>Count seat</th>
						<th>Buyer Name</th>
						<th>Sale Price</th>
						<th>Sale Date</th>
						<th>Send Message Queue</th>

					</tr>
				</thead>
				<tbody>
					<%
						for (int i = 0; i < cars.size(); i++) {
					%>
					<tr>

						<td>
							<%
								out.print(cars.get(i).getName_car());
							%>
						</td>

						<td>
							<%
								out.print(cars.get(i).getPrice());
							%>
						</td>
						
						<td>
							<%
								out.print(cars.get(i).getCount_seat());
							%>
						</td>
						
						<td>
							<%
								out.print(cars.get(i).getBuyer_name());
							%>
						</td>
						
						<td>
							<%
								out.print(cars.get(i).getSale_price());
							%>
						</td>
						
						<td>
							<%
								out.print(cars.get(i).getSale_date());
							%>
						</td>



						<td><a
							href="/set-MessageQueue?id=<%out.print(cars.get(i).getId());%>"><span
								class="glyphicon glyphicon-list-alt"></span></a></td>


					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>


</body>
</html>