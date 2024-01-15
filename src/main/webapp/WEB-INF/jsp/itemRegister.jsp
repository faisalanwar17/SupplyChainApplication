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
        <h1 align="center">Registration Form</h1>
      <form action="getbackmanagerDashboard"  method="post" class="Form">
		<input type ="hidden" name= "comp" value="<%=request.getAttribute("comp")%>"/>
			<button type="submit"  >
            Back
            </button>
            </form>
        
        <form action="createitem" method="post" class="Form">
        
       			<%if(request.getAttribute("error")!= null){%>
				
					<p style="color:#FF0000">${error}</p>
				
				<%}%>
        
            <label >Item ID:</label>
            <input type="number" id="itemid" name="itemid" value="${ItemModel.itemid}" placeholder="Item ID">
            <p >
    		
    	    </p>
           
           
            <label >Item Name :</label>
            <p>
            <select id="itemname" name="itemname">
            <option value="none" selected disabled hidden>Select Item</option>
  			<option value="motherboard">Mother Board</option>
  			<option value="ram">Ram</option>
  			<option value="coolent">Coolent</option>
  			<option value="compressor">Compressor</option>
  			<option value="leddisplay">Led display</option>
  			<option value="tvchip">Tv chip</option>
  			
            </select>
            
            <p>
            
    	
    	    </p>
    	
            <label >Supplier Id :</label>
            <input  readonly="readonly" class="w3-input w3-border" type="text"
						  name="supplierid"  value="<%=request.getAttribute("comp")%>" >
  			<p>
  			</p>
  			 <label >Availability:</label>
            <input type="number" id="availability" name="availability" value="${ItemModel.availability}" placeholder="Availability">
            
            <p>
  			</p>
  			 <label >Cost:</label>
            <input type="number" id="cost" name="cost" value="${ItemModel.cost}" placeholder="cost">
           
    	    
    		
    	    
            <br>
            <button  class="registerbtn" type="submit">Register</button>
        </form>
		</div>
</body>

</html>