<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="neu.edu.controller.model.Options"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<title>W3.CSS Template</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<style>
body, h1, h2, h3, h4, h5, h6 {
	font-family: "Raleway", sans-serif
}

body, html {
	height: 100%;
	line-height: 1.8;
}

/* Full height image header */
.bgimg-1 {
	background-position: center;
	background-size: cover;
	background-color: lightcyan;
	background-image: url("/w3images/mac.jpg");
	min-height: 100%;
}

.w3-bar .w3-button {
	padding: 16px;
}
</style>
</head>
<body>

	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-card" id="myNavbar">
			
			<!-- Right-sided navbar links -->
			<div class="w3-right">
				<a href="logout"  ><i
					></i>LOGOUT</a>
			</div>
			<!-- Hide right-floated links on small screens and replace them with a menu icon -->

		</div>
	</div>



	<!-- Header with full-height image -->
	<header class="bgimg-1 w3-display-container w3-grayscale-min" id="home">
		<div class="w3-display-top w3-text-white" style="padding: 48px">
			<p>
				<a href="#about"
					class="w3-button w3-white w3-padding-large w3-large w3-margin-top w3-opacity w3-hover-opacity-off">Welcome
					${sessionScope['currentUser'].firstName}</a>
			</p>
		</div>
		<div align="center">
		<form   action="orderacceptbysupplier" method="post" class="Form">
		<%if(request.getAttribute("error")!= null){%>
				
					<p style="color:#FF0000">${error}</p>
				
				<%}%>
			<table class="w3-table w3-striped w3-border">
			<thead>
				<tr>
					<th><h3>Order ID</h3></th>
					<th><h3>Item Name</h3></th>
					<th><h3>Units</h3></th>
					<th><h3>Cost</h3></th>
					<th><h3>Status </h3></th>
				</tr>
				</thead>
				
				
				<%
				for(Options order : (ArrayList<Options>) request.getAttribute("order"))
						{
				%>
				<tr>
					<td><input type= "radio" id="orderid" name= "orderid" value="<%=order.getOrderid() %>"  required/><%=order.getOrderid() %></td>
					<td ><%=order.getItemname()%></td>
					<td><%=order.getUnits()%></td>
					<td><%=order.getCost()%></td>
					<td><%=order.getStatus()%></td>
					

				</tr>
				<%
						}
				%>

			</table>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
        <button type="submit"  >
            Accept
        </button>
          
        	&nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
            &nbsp;
        
			
		</form>
		<form action="getbackmanagerDashboard"  method="post" class="Form">
		<input type ="hidden" name= "comp" value="<%=request.getAttribute("comp")%>"/>
			<button type="submit"  >
            Back
            </button>
            </form>
        
		</div>
		
	</header>




	<!-- Footer -->
	<footer class="w3-center w3-black w3-padding-64">
		<div class="w3-xlarge w3-section">
			<i class="fa fa-facebook-official w3-hover-opacity"></i> <i
				class="fa fa-instagram w3-hover-opacity"></i> <i
				class="fa fa-snapchat w3-hover-opacity"></i> <i
				class="fa fa-pinterest-p w3-hover-opacity"></i> <i
				class="fa fa-twitter w3-hover-opacity"></i> <i
				class="fa fa-linkedin w3-hover-opacity"></i>
		</div>
		<p>
			Developed by Mohammed Faisal Anwar
		</p>
	</footer>


</body>
</html>