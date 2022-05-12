<%@page import="com.PowerGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.css">
		<title>Electro Grid - Power Generator Management</title>
		<link rel="stylesheet" href="Views/css/bootstrap.min.css">
		<script src="Components/jquery-3.6.0.min.js"></script>
		<script src="Components/PowerGenerator.js"></script>
		<style>
		tr:nth-child(even) {
 			 background-color:rgb(255, 245, 147);
		}
		tr:nth-child(odd) {
 			 background-color:rgb(255, 245, 147);
		}
		table {
  			border-collapse: collapse;
  			width: 100%;
		}
		th, td {
		  padding: 8px;
		  text-align: left;
		  border-bottom: 2px solid black;
		  border-left: 0.5px solid #ddd;
		  border-right: 0.5px solid #ddd;
		  border-top: 2px solid black;
		}
		
		tr:hover {background-color:#ffb366;}
		
		</style>
</head>
	
<body>
<div style="background-image: url('https://img.freepik.com/free-vector/white-gold-geometric-pattern-background-vector_53876-140726.jpg?w=2000'); background-repeat: no-repeat;">
	<h1 align="center">Power Generator Management</h1>
	<div class="container">
		<div class="row">
		<div class="col-13">
				<div id="divPGGrid"">
			 	<%
				 	PowerGenerator pGen = new PowerGenerator(); 
				 	out.print(pGen.readPowerGenerators()); 
			 	%>
				</div>
				<br>
		</div> 
		
		<div class="col-8" style="background-color:#e6b3cc"> 
				<br>
				<form id="formPowerGenerators" name="formPowerGenerators">
				<h4 align="center">NEW POWER GENERATOR</h4><br>
			 		<b>Power Generator code (format:gxxxx):</b> 
			 		<input id="gCode" name="gCode" type="text" class="form-control form-control-sm">
			 		<br> 
			 		<b>Power Generator name:</b> 
			 		<input id="gName" name="gName" type="text" class="form-control form-control-sm">
			 		<br> 
			 		<b>Power Generator Type:</b>
			 		<input id="gType" name="gType" type="text" class="form-control form-control-sm">
			 		<br> 
			 		<b>Power Generator Location:</b>
			 		<input id="gLocation" name="gLocation" type="text" class="form-control form-control-sm">
			 		<br> 
			 		<b>Unit Price:</b>
			 		<input id="gUnitPrice" name="gUnitPrice" type="text" class="form-control form-control-sm">
			 		<br> 
			 		<b>Registered Date:</b>
			 		<input id="gRegDate" name="gRegDate" type="date" class="form-control form-control-sm">
			 		<br>
	 		
	 				<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
	 				<input type="hidden" id="hidgIDSave" name="hidgIDSave" value="">
				</form>
				<br>
				<div id="alertSuccess" class="alert alert-success"></div>
				<div id="alertError" class="alert alert-danger"></div>
				<br>
		</div>
		
		</div>
	</div> 
	
</div>
</body>
</html>
