<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form id="newFlight" modelAttribute="newflight"
		action="newflightinfo" method="post">

		<table align="center">
			<tr>
				<td><form:label path="flightId">flightId</form:label></td>
				<td><form:input path="flightId" name="flightId" id="flightId" /></td>
			</tr>
			<tr>
				<td><form:label path="airlineName">airlineName</form:label></td>
				<td><form:input path="airlineName" name="airlineName"
						id="airlineName" /></td>
			</tr>
			<tr>
				<td><form:label path="source">source</form:label></td>
				<td><form:input path="source" name="source"
						id="source" /></td>
			</tr>
			<tr>
				<td><form:label path="destination">Destination</form:label></td>
				<td><form:input path="destination" name="destination"
						id="destination" /></td>
			</tr>
			<tr>
				<td><form:label path="departureTime">departureTime</form:label></td>
				<td><form:input path="departureTime" name="departureTime" id="departureTime" /></td>
			</tr><tr>
				<td><form:label path="journeyDate">journeyDate</form:label></td>
				<td><form:input path="journeyDate" name="journeyDate" id="journeyDate" /></td>
			</tr><tr>
				<td><form:label path="arrivalTime">arrivalTime</form:label></td>
				<td><form:input path="arrivalTime" name="arrivalTime" id="arrivalTime" /></td>
			</tr>
			<tr>
				<td><form:label path="fare">fare</form:label></td>
				<td><form:input path="fare" name="fare" id="fare" /></td>
			</tr>
			<tr>
				<td><form:label path="availableSeats">availableSeats</form:label></td>
				<td><form:input path="availableSeats" name="availableSeats" id="availableSeats" /></td>
			</tr>
            <tr>
				<td></td>
				<td><form:button id="add" name="add">Add</form:button></td>
			</tr>			
			</table>

	</form:form>
	
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${exception}</td>
		</tr>
	</table>

</body>
</html>