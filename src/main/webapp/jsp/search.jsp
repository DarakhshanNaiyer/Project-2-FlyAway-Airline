<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix='c'%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for Flights</title>
</head>
<body>
	<table>
		<tr>
			<td><a href="login">Admin login</a></td>
		</tr>

	</table>

	<div align="center">

		<form id="serForm" modelAttribute="availableFlights"
			action="searchProcess" method="post">


			<label>Source</label> <select name="source">
				<option value="None">--select--</option>

				<c:forEach items="${locationList}" var="source">
					<option value="${source.locId}"
						<c:if test="${source.locId eq selectedCatId}">selected="selected"</c:if>>
						${source.locName}</option>
				</c:forEach>
			</select> <br /> <br />
			
			
			
			 <label>Destination</label>
			  <select name="destination">
				<option value="None">--select--</option>

				<c:forEach items="${locationList}" var="destination">
					<option value="${destination.locId}"
						<c:if test="${destination.locId eq selectedCatId}">selected="selected"</c:if>>
						${destination.locName}</option>
				</c:forEach>
			</select> <br /> <br /> 
			
			 <label>Date</label>
			<input path="journeyDate" name="journeyDate" id="journeyDate" /> <br>
			<br /> <label>No. of Seats</label> <input path="numberOfSeats"
				name="numberOfSeats" id="numberOfSeats" /> <br /> <br />
			<button id="search" name="search">Search</button>
		</form>
	</div>

	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${exception}</td>
		</tr>
	</table>
</body>
</html>