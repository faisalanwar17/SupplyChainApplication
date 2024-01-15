<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="neu.edu.controller.model.ManufactureModel"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Registration</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Raleway">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script
	src="https://www.google.com/recaptcha/api.js?onload=onloadCallback&render=explicit"
	async defer></script>


</head>
<body>
	<div class="w3-container w3-light-grey" style="padding: 28px 16px"
		id="contact">
		<h3 class="w3-center">Enter Supplier Details</h3>
		<p class="w3-center w3-large">All fields are required</p>
		<div style="margin-top: 48px">
			<form action="updatemanufacturer" method="post">
			<% 
			ManufactureModel supplier = (ManufactureModel) request.getAttribute("manufacture");
			%>
				<p>
					<label>Manufacture ID</label>
					<input  readonly="readonly" class="w3-input w3-border" type="text"
						  name="manufactureid"  value="<%=supplier.getManufactureid()%>" >
				</p>
				
		
					<label >Weather :</label>
            <p>
            <select id="Weather" name="Weather">
            <option value="<%=supplier.getWeather()%>" selected ><%=supplier.getWeather()%></option>
  			<option value="Cloudy">Cloudy</option>
  			<option value="Rainy">Rainy</option>
  			<option value="Sunny">Sunny</option>
  			
            </select>
				</p>
				
		
            <label >Political Issues :</label>
            <p>
            <select id="politicalissues" name="politicalissues">
            <option value="<%=supplier.getPoliticalissues()%>" selected  ><%=supplier.getPoliticalissues()%></option>
  			<option value="Yes">Yes</option>
  			<option value="No">No</option>
  		
  			
            </select>
            </p>
           
            <label >Labour Issues :</label>
            <p>
            <select id="labourissues" name="labourissues">
           
           	<option value="<%=supplier.getLabourissues()%>" selected  ><%=supplier.getLabourissues()%></option>
  			<option value="Yes">Yes</option>
  			<option value="No">No</option>
  		
  			
            </select>
            </p>
            
            <label >Driver Issues :</label>
            <p>
            <select id="driverissues" name="driverissues">
            <option value="<%=supplier.getDriverissues()%>" selected  ><%=supplier.getDriverissues()%></option>
  			<option value="Yes">Yes</option>
  			<option value="No">No</option>
  		
  			
            </select>
            </p>
				
				
				<div>
					<div id='html_element'></div>
					<div id="captcha" style="margin-left: 100px; color: red" ></div>
				</div>
				<br>
				<br>
				<br>
				<br>
				<br>
				<p>
					<button class="w3-button w3-black w3-right" type="submit"
						onclick="" >
						<i class="fa fa-arrow-circle-right"></i> Update
					</button>
				</p>
			</form>

		</div>
	</div>
	
</body>
</html>