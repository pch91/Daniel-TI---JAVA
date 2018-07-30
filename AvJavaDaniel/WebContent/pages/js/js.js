$( document ).ready(function() {
	var wipo = null;
	
	$("#buscar").click(function(){
		$.get("BuscarWipo?nProcesso="+$("#nprocesso").val(), function(data, status){
			wipo = null;
			if(!(data.hasOwnProperty("msg"))){
				$("#n_pub").val(data.n_pud);
				$("#n_ped_int").val(data.n_ped_int);
				$("#dt_pub").val(data.dt_pub);
				$("#req").text(data.requerentes);
				$("#tit").text(data.titulo);
				wipo = data;
			}else{
				alert(data.msg);
			}
	    }).fail(function( jqXHR, textStatus, errorThrown ) {
	        alert( jqXHR.responseText );
	    });
	});
	
	$("#Salvar").click(function(){
		if(wipo != null){
			$.post( "SaveWipo", { "wipo": JSON.stringify(wipo) }, function( data ) {
				  alert(data.msg);
				  if(data.sucess == 1){
					    $("#nprocesso").val("");
						$("#n_pub").val("");
						$("#n_ped_int").val("");
						$("#dt_pub").val("");
						$("#req").text("");
						$("#tit").text("");
				  }
			}, "json");
		}else{
			alert("É necessario buscar um processo antes");
		}
	});
	
	
	
	
});
	