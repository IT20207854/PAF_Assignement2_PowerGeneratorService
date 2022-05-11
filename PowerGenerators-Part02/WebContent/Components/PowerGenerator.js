$(document).on("click", "#btnSave", function(event) 
{ 
	// Clear alerts---------------------
	 $("#alertSuccess").text(""); 
	 $("#alertSuccess").hide(); 
	 $("#alertError").text(""); 
	 $("#alertError").hide(); 

	// Form validation-------------------
	/*var status = validatePowerGeneratorForm();
	if (status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}*/
	
	// If valid------------------------
	var type = ($("#hidgIDSave").val() == "") ? "POST" : "PUT"; 
	 $.ajax( 
	 { 
		 url : "PowerGeneratorsAPI", 
		 type : type, 
		 data : $("#formPowerGenerators").serialize(), 
		 dataType : "text", 
		 complete : function(response, status) 
		 { 
		 	onPowerGeneratorSaveComplete(response.responseText, status); 
		 } 
	 }); 
});


function onPowerGeneratorSaveComplete(response, status) 
{ 
if (status == "success") 
{ 
	 var resultSet = JSON.parse(response); 
	 if (resultSet.status.trim() == "success") 
	 { 
		 $("#alertSuccess").text("Successfully saved."); 
		 $("#alertSuccess").show(); 
		 $("#divPGGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
		 $("#alertError").text(resultSet.data); 
		 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
		 $("#alertError").text("Error while saving."); 
		 $("#alertError").show(); 
	 } else
	 { 
		 $("#alertError").text("Unknown error while saving.."); 
		 $("#alertError").show(); 
	 } 
	 $("#hidgIDSave").val(""); 
	 $("#formPowerGenerators")[0].reset(); 
}


function validatePowerGeneratorForm() 
{ 
	// CODE
	if ($("#gCode").val().trim() == "") 
	{ 
	 	return "Insert Power Generator Code."; 
	} 
	
	// NAME
	if ($("#gName").val().trim() == "") 
	{ 
	 	return "Insert Power Generator Name."; 
	} 
	
	// TYPE
	if ($("#gType").val().trim() == "") 
	{ 
	 	return "Insert Power Generator Type."; 
	} 
	
	// LOCATION
	if ($("#gLocation").val().trim() == "") 
	{ 
	 	return "Insert Power Generator Location."; 
	} 
	
	// PRICE-------------------------------
	if ($("#gUnitPrice").val().trim() == "") 
	{ 
	 	return "Insert Unit Price."; 
	} 
	// is numerical value
	var tmpPrice = $("#gUnitPrice").val().trim(); 
	if (!$.isNumeric(tmpPrice)) 
	{ 
	 	return "Insert a numerical value for Unit Price."; 
	} 
	// convert to decimal price
	 $("#gUnitPrice").val(parseFloat(tmpPrice).toFixed(2)); 
	
	// REGISTERED DATE------------------------
	if ($("#gRegDate").val().trim() == "") 
	{ 
	 	return "Insert Registered Date."; 
	} 
	
	return true; 
}


// UPDATE==========================================
$(document).on("click", ".btnUpdate", function(event) {
	$("#hidgIDSave").val($(this).data("gid"));
	$("#gCode").val($(this).closest("tr").find('td:eq(0)').text());
	$("#gName").val($(this).closest("tr").find('td:eq(1)').text()); 
	$("#gType").val($(this).closest("tr").find('td:eq(2)').text()); 
	$("#gLocation").val($(this).closest("tr").find('td:eq(3)').text()); 
	$("#gUnitPrice").val($(this).closest("tr").find('td:eq(4)').text()); 
	$("#gRegDate").val($(this).closest("tr").find('td:eq(5)').text()); 
});


$(document).on("click", ".btnRemove", function(event) 
{ 
	 $.ajax( 
	 { 
		 url : "PowerGeneratorsAPI", 
		 type : "DELETE", 
		 data : "gID=" + $(this).data("gid"),
		 dataType : "text", 
	 	 complete : function(response, status) 
	 { 
	 	onPowerGeneratorDeleteComplete(response.responseText, status); 
	 } 
	 }); 
});


function onPowerGeneratorDeleteComplete(response, status) 
{ 
	if (status == "success") 
	{ 
		 var resultSet = JSON.parse(response); 
		 if (resultSet.status.trim() == "success") 
		 { 
		 $("#alertSuccess").text("Successfully deleted."); 
		 $("#alertSuccess").show(); 
		 $("#divPGGrid").html(resultSet.data); 
	 } else if (resultSet.status.trim() == "error") 
	 { 
		 $("#alertError").text(resultSet.data); 
		 $("#alertError").show(); 
	 } 
	 } else if (status == "error") 
	 { 
		 $("#alertError").text("Error while deleting."); 
		 $("#alertError").show(); 
	 } else
	 { 
		 $("#alertError").text("Unknown error while deleting.."); 
		 $("#alertError").show(); 	
	 } 
}

