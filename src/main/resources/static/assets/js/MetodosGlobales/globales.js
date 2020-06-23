// PAGINACION
const pagination = (data) => {
	const total = data.totalPages;
	if(total > 1){
		let desde = Math.min(Math.max(1,data.number - 4), data.totalPages - 5) ;
		let hasta = Math.max(Math.min(data.totalPages , data.number + 4 ), 6) ;
		let paginas = [];
		if (data.totalPages > 5){
			this.paginas = new Array(hasta - desde + 1).fill(0).map((_valor, indice) => indice + desde);
		} else {
			this.paginas = new Array(data.totalPages).fill(0).map((_valor, indice)=> indice + 1 );
		}			
		content += "<tr>"
		content += "<td colspan='9'>"
		content += "<ul class='pagination justify-content-center'>"
		if(total > 5){
			content += "<li class='page-item'><button class='page-link' onclick='toList("+ 0 +")'>Inicio</button></li>"
		}
		for(let pag of this.paginas){			
			if ((pag-1) == data.number){
				content += "<li class='page-item disabled'><button class='page-link' onclick='toList("+ (pag-1) +")'>"+ pag +"</button></li>";
			} else {
				content += "<li class='page-item'><button class='page-link' onclick='toList("+ (pag-1) +")'>"+ pag +"</button></li>";		
			}				
		}
		if(total > 5){	
			content += "<li class='page-item'><button class='page-link' onclick='toList("+ (data.totalPages-1) +")'>Ultima</button></li>";
		}
		content += "</ul>";
		content += "</td>";
		content += "</tr>";
	}
}

// LIMPIAR CAMPOS
const limpiarCampos = () => {
	let control = document.getElementsByClassName("borrar");	
	for (var i = 0; i < control.length; i++) {
		control[i].value = "";
	}
}

// ALERT DE CONFIRMACION CON GUARDADO
const alertSweeAlertConfirmacion = (dir,dataJSON) => {
	 Swal.fire({
		  title: 'Desea Guardar?',		
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Si, Por Favor!'
		}).then((result) => {
		  if (result.value) {
			  $.ajax({
					url: dir,
					type: 'POST',
					dataType: 'json',
					contentType: "application/json; charset=utf-8",
					data: dataJSON,
					success: ( ) => {
							toList();
							document.querySelector("#btnCancelar").click();
							Swal.fire({
						    	title:'EXITOSO',
						    	text: 'Guardado Exitoso!',
							    icon: 'success',
							    timer: 1000 
						    })
							},
					error: (jqXHR,textStatus, errorThrown) => {
						errorAJAX(jqXHR,textStatus, errorThrown);
					}
					
			});		    
		  }
		})
}

// ALERT DE CONFIRMACION DE ELIMINACION
const alertSweeAlertDelete = (controlador,id) => {
	// console.log(id);
	Swal.fire({
		  title:'Esta Seguro de Eliminar?',		  
		  icon: 'warning',
		  showCancelButton: true,
		  confirmButtonColor: '#3085d6',
		  cancelButtonColor: '#d33',
		  confirmButtonText: 'Si, Eliminalo!'
		}).then((result) => {        			
		  if (result.value) {
			  $.ajax({
				  type: "POST",
				  url: `/${controlador}/delete/${id}`,
				  contentType: false,
		          processData: false,
		          error: (jqXHR,textStatus, errorThrown) => {
						errorAJAX(jqXHR,textStatus, errorThrown);
				  },
		          success: ( ) => {		
		        	  toList();	
		        	  Swal.fire({	      
		    		      title:'Eliminación Exitosa!',
		    		      icon:'success',
		    		      timer: 1000
		    		  })
		          }			      
			});			  		
		    
		  }
		})			
}

// MANEJOS DE ERRORES EN ELEMENTOS AJAX
 const errorAJAX = (jqXHR,textStatus, errorThrown) => {
	 if (jqXHR.status === 0) {
		 alertSweeAlertError('Error en la Conexion... ');
      } else if (jqXHR.status == 404) {
    	  alertSweeAlertError('Error en URL en Servidor... ');
      } else if (jqXHR.status == 500) {
    	  alertSweeAlertError('Error en la Terminal del Servidor...');
      } else if (textStatus === 'parsererror') {
    	  alertSweeAlertError('Error de Formato de Envio u Obtencion... ');
      } else if (textStatus === 'timeout') {
    	  alertSweeAlertError('Tiempo de Espera ah Sobrepasado');
      } else if (textStatus === 'abort') {
    	  alertSweeAlertError('Error de Cancelacion.');
      } else {
    	  alertSweeAlertError('Otros errores: ' + jqXHR.responseText);
      }
 }
 
 // ALERTA DE ERROR
 const alertSweeAlertError = (texto) => {
	 Swal.fire({
		 title: 'ERROR',
		 text : texto,
		 icon: 'error',
		 timer: 5000
	 })
 }
 
 // CARGAR COMBOS NORMALES O ANIDADOS
 const cargarCombo = (url,id,campoOne,campoTwo,primera,comboID) => {	
		$.get(`${url}/${id}`, (data) => {
			let combo = "";
				combo += "<option value=''>"+ primera +"</option>";
			if (campoOne === "") {
				for (let item of data) {
					combo += "<option value='"+item.id+"'>"+ item[campoTwo] +"</option>";		
				}
			} else {
				for (let item of data[campoOne]) {
					combo += "<option value='"+item.id+"'>"+ item[campoTwo] +"</option>";		
				}
			}
			document.querySelector(`#${comboID}`).innerHTML = combo;
		}).fail((jqXHR,textStatus, errorThrown)=> {		
			 errorAJAX(jqXHR,textStatus, errorThrown);
		 });	
}
 
 

 