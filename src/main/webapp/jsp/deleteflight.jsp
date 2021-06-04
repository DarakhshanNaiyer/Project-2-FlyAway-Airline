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

<form:form id="removeflight" modelAttribute="removeflight"
		action="deleteflightinfo" method="post">

		<table align="center">
			<tr>
				<td><form:label path="flightId">flightId</form:label></td>
				<td><form:input path="flightId" name="flightId" id="flightId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><form:button id="delete" name="delete">Delete</form:button></td>
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