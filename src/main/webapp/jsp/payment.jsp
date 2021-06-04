<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Payment</title>
</head>
<body>




	<form id="paymentForm" modelAttribute="pay"
		action="paymentProcess" method="get">

		<table align="center" cellpadding="5">
			<tr>
				<td><label >Card Number:</label></td>
				<td><input  name="cardNumber"
						id="cardNumber" /></td>
			</tr>
			<tr>
				<td><label >Expiry Month:</label></td>
				<td><input  name="exMonth" id="exMonth" /></td>
			</tr>
			<tr>
				<td><label >Expiry Year:</label></td>
				<td><input  name="exYear" id="exYear" /></td>
			</tr>
			<tr>
				<td><label >Name on the card:</label></td>
				<td><input name="nameOnCard"
						id="nameOnCard" /></td>
			</tr>
			<tr>
				<td></td>
				<td><button id="payment" name="payment">Pay Now</button></td>
			</tr>
			<tr></tr>

		</table>
	</form>







</body>
</html>