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
	<body>
		<div class="container">
	 		<div class="row">
	 			<div class="col">
	 				<form id="formPowerGenerators" name="formPowerGenerators">
						 Power Generator Code: <input name="gCode" type="text" class="form-control form-control-sm"><br> 
						 Power Generator Name: <input name="gName" type="text" class="form-control form-control-sm"><br> 
						 Power Generator Type: <input name="gType" type="text" class="form-control form-control-sm"><br> 
						 Power Generator Location: <input name="gLocation" type="text" class="form-control form-control-sm"><br> 
						 Unit Price: <input name="gUnitPrice" type="text" class="form-control form-control-sm"><br> 
						 Registered Date: <input name="gRegDate" type="text" class="form-control form-control-sm"><br> 
						 
 						<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 						<input type="hidden" id="hidgIDSave" name="hidgIDSave" value="">
					</form>
					
					<div id="alertSuccess" class="alert alert-success"></div>
					<div id="alertError" class="alert alert-danger"></div>
					<br>
					
					<div id="divPGGrid">
					 <%
 						PowerGenerator pGen = new PowerGenerator(); 
						out.print(pGen.readPowerGenerators()); 
 					%>
					</div>
	 			</div>
	 		</div>
		</div>
		
	</body>
</html>