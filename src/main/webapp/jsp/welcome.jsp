<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
</head>
<body>
	 <table>
		 <tr>
			<td>Welcome ${username}</td>
		</tr>
	   </table>
	   
	<table align="center">
		<tr>
			<td><a href="addnewflights">Add New Flights</a></td>
		</tr>
	</table>
	
		<table  align="right">
		<tr>
           <td><a href="home">Log Out</a></td>
		</tr>
	</table>
	
	<table align="center">
		<tr>
			<td><a href="deleteflight">Delete A Flight</a></td>
		</tr>
	</table>
	
	<table align="center">
		<tr>
			<td style="font-style: italic; color: green;">${message}</td>
		</tr>
	</table>
	
</body>
</html>