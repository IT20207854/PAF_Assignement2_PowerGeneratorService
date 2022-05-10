<%@page import="model.PowerGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/bootstrap.css">
		<title>Electro Grid - Power Generator Management</title>
	</head>
	<body>
		<div class="container">
	 		<div class="row">
	 			<div class="col">
	 				<form method="post" action="PowerGenerators.jsp">
						 Power Generator Code: <input name="PGCode" type="text" class="form-control form-control-sm"><br> 
						 Power Generator Name: <input name="PGName" type="text" class="form-control form-control-sm"><br> 
						 Power Generator Type: <input name="PGType" type="text" class="form-control form-control-sm"><br> 
						 Power Generator Location: <input name="PGLocation" type="text" class="form-control form-control-sm"><br> 
						 Unit Price: <input name="PGUnitPrice" type="text" class="form-control form-control-sm"><br> 
						 Registered Date: <input name="PGRegDate" type="text" class="form-control form-control-sm"><br> 
						 
						 
 						<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">
 						<input type="hidden" id="hidPGIDSave" name="hidPGIDSave" value="">
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