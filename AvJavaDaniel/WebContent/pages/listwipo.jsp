<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/jquery.jsontotable.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/style.css">

</head>
<body>
<div style="margin-top: 0px;margin-bottom: 3px;" ><input type="button" id="impFiltro" value="Voltar" onclick="window.location='/AvJavaDaniel/';" /></div>
<div class="filtrotitle">
	<div><label class="lfiltro">N processo:  </label><input type="text" class="impfiltro" id="impFiltropros" value="" />
	     <label class="lfiltro">Requerente:  </label><input type="text" class="impfiltrolast" id="impFiltroreq" value="" />
	     </div>
	     <div>
	     <input class="btnfiltrar" type="button" id="impFiltrobtn" value="Filtrar" /><input type="button" id="limpar" value="Limpar" /></div>
</div>
</br>
<div id="List" class="jsontotable"></div>

<script type="text/javascript">
$( document ).ready(function() {
	function addcab(obj){
		obj.splice(0,0,{"n_pud":"Número de Publicação","requerentes":"Requerentes","n_ped_int":"Número do Pedido Internacional","titulo":"Título","dt_pub":"Data de Publicação"});
		return obj;
	}
	
	function loadall(){
		$.get("ListWipo", function(data, status){
			data = addcab(data);
			$.jsontotable(data, {
				id: "#List",
				className: "table table-hover"
			});
		});
	}
	
	$("#limpar").click(function(){
		$("#impFiltropros").val(""); 
		$("#impFiltroreq").val("");
		$("#List table").remove();
		loadall();
	});
	
	loadall();
	
	$("#impFiltrobtn").click(function(){
		if($("#impFiltropros").val() != "" || $("#impFiltroreq").val() != ""){
			$.get("ListWipoBy", {"nProcesso":$("#impFiltropros").val(),"req":$("#impFiltroreq").val()} , function(data, status){
				data = addcab(data);
				$("#List table").remove();
				$.jsontotable(data, {
					id: "#List",
					className: "table table-hover"
				});
			});
		}else{
			$("#List table").remove();
			loadall();
		}
	});
	
	
});
</script>
</body>
</html>
