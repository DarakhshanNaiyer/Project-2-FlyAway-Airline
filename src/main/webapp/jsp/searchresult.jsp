<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c' %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Register</title>
</head>
<body>
	<div align="center">
		<h1>Flight List</h1>

		<table border="1" cellpadding="5">
			<tr>
				<th>Flight Id</th>
				<th>Airline Name</th>
				<th>Source</th>
				<th>Departure Time</th>
				<th>Destination</th>
				<th>Arrival Time</th>
				<th>Fare</th>
				<th>Available Seats</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${flightsList}" var="flight" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${flight.airlineName}</td>
					<td>${flight.source}</td>
					<td>${flight.departureTime}</td>
					<td>${flight.destination}</td>
					<td>${flight.arrivalTime}</td>
					<td>${flight.fare}</td>
					<td>${flight.availableSeats}</td>
					<td><a href="register">Book</a></td>

				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>