<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
.container {  
    padding: 50px;  
  background-color: lightblue;  
}  
  
input[type=text], input[type=password], input[type=tel], input[type=number] textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}
input[type=dropdown]{
	width: 100%;  
    padding: 15px;  
  	margin: 5px 0 22px 0;  
  	display: inline-block;  
 	border: none;  
  	background: #f1f1f1;


}
input[type=number]{
	width: 100%;  
    padding: 15px;  
  	margin: 5px 0 22px 0;  
  	display: inline-block;  
 	border: none;  
  	background: #f1f1f1;


}
input[type=tel] {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  
 input[type=email] {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  
input[type=text]:focus, input[type=password]:focus, input[type=email]:focus, input[type=tel]:focus input[type=number]:focus{  
  background-color: orange;  
  outline: none;  
}  
.email{
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1; 
	
}
 div {  
            padding: 10px 0;  
         }  
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}  
.registerbtn:hover {  
  opacity: 1;  
}  
</style>
<body>

        <br/>
        <div class="container">
        <h1 align="center">Registration For Manufacture</h1>
      
        
        <form action="saveemployeemanufacturer" method="post" class="Form">
        
       			<%if(request.getAttribute("error")!= null){%>
				
					<p style="color:#FF0000">${error}</p>
				
				<%}%>
        
            <label >First name:</label>
            <input type="text" id="fname" name="firstName" value="${employeeModel.firstName}" placeholder="First name">
            <p >
    		
    	    </p>
           
            <label >Last name:</label>
            <input type="text" id="lname" name="lastName" value="${employeeModel.lastName}" placeholder="Last name">
            
            <label >Email:</label>
            <p>
            <input type="email" id="email" name="email" value="${employeeModel.email}" placeholder="Email">
    	
    	    </p>
    	    <label >Address Line 1:</label>
            <p>
            <input type="text" id="address" name="address" value="${employeeModel.address}" placeholder="address">
            <label >City :</label>
            <p>
            <input type="text" id="city" name="city" value="${employeeModel.city}" placeholder="city">
            <label >State :</label>
            <p>
            <input type="text" id="state" name="state" value="${employeeModel.state}" placeholder="state">
            <label >Country :</label>
            <p>
            <input type="text" id="country" name="country" value="${employeeModel.country}" placeholder="country">
            <label >Role :</label>
            <p>
            <select id="role" name="role">
            <option value="none" selected disabled hidden>Select Role</option>
  			<option value="ProcurementManager">Procurement Manager</option>
  			<option value="ProductionManager">Production Manager</option>
  			<option value="SupplyManager">Supply Manager</option>
  			</select>
            
            <p>
            </p>
            <label >Company Id :</label>
            <select id="companyid" name="companyid">
            <option value="none" selected disabled hidden>Select Company</option>
  			<option value="Manufacturer_A">Manufacturer A</option>
  			<option value="Manufacturer_B">Manufacturer B</option>
  			<option value="Manufacturer_C">Manufacturer C</option>
            </select>
    	
    	    
            
             <p>
    
    	    </p>
    	    <label >Username (No space in between and must include underscore):</label>
             <input type="text" id="username" name="username" value="${employeeModel.username}">
             
             <label >Password (Must include Upper Case, LowerCase, and Digit and at least 8 characters of length):</label>
              <input type="password" id="pwd" name="password">
              <p>
    		
    	    
            <br>
            <button  class="registerbtn" type="submit">Register</button>
        </form>
		</div>
</body>
</html>