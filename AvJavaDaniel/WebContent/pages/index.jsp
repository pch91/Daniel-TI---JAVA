<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	import="java.util.Date, java.text.*, br.com.daniel.model.WipoModel"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="js/js.js"></script>
<link rel="stylesheet" type="text/css" href="css/style.css">

<title>Insert title here</title>
</head>
<body>
<div class="buscatitle"><div><label class="titulo" >Numero do processo</label></div>
<input class="input2" type="text" id="nprocesso" name="nprocesso"/>
<input class="btnfiltrar" type="button" id="buscar" value="Buscar" name="buscar" />
<input type="button" id="cadastrados" value="Cadastrados" name="cadastrados" onclick="window.location='/AvJavaDaniel/listwipo.jsp';"/>
</div>
</br><hr/>
<div class="filds1">
<div><div><label class="titulo" >Número de pub</label></div>
<input class="input" type="text" id="n_pub" readonly="true"/></br></div>

<div><div><label class="titulo">Número do pedido internacional</label></div>
<input class="input" type="text" id="n_ped_int" readonly="true"/></br></div>

<div><div><label class="titulo">Data de publicação</label></div>
<input class="input" type="text"id="dt_pub" readonly="true"/></br></div>
</div>
<div class="filds2">
<div><div><label class="titulo">Requerentes</label></div>
<textarea class="textarea" type="text" id="req" readonly="true" ></textarea></br></div>

<div><div><label class="titulo">Título</label></div>
<textarea class="textarea" type="text" id="tit" readonly="true" ></textarea></div>
</div>
<div class="salvarbtn"><input class="salvar" type="button" id="Salvar" value="Salvar" name="Salvar" /></div>
</body>
</html>
