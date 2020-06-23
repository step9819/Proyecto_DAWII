/**
 * 
 */
//VARIABLES GLOBALES
	let content = "";
// ELIMINAR
const eliminar = (id) => {
	alertSweeAlertDelete('comprobante',id);
}

//LISTADO Y PAGINACION
const toList = (page = 0) => {
	$.get(`/comprobante/listar/page/${page}`, (data) => {
		// console.log(data);
		content = "";
		if (data.content.length > 0) {	
			for (let item of data.content) {			
					content += "<tr>";
				    // content += "<td>"+ item.id +"</td>";
					content += "<td>"+ item.idcomprobante +"</td>";	
					content += "<td>"+ item.fechaRegistro +"</td>";	
					content += "<td>"+ item.fechaPago +"</td>";	
					content += "<td>"+ item.estado + "</td>";	
					content += "<td>"+ item.pedido +"</td>";	
					content += "<td>"+ item.cliente +"</td>"; // 
					content += "<td>"+ item.usuario +"</td>";	
					// acciones
					content += "<td>";
					content += "<button type='button' style='border:0px;' data-toggle='modal' data-target='#exampleModal'><i style='color:#40B7B3' class='ti-eye'></i></button>";
					content += "<button style='border:0px;'><i style='color:#0099FF' class='ti-printer'></i></button>";
					content += "<button onclick='abrirModal("+ item.idcomprobante +")' style='border:0px;'  data-toggle='modal' data-target='#exampleModal'><i style='color:#336600' class='ti-pencil-alt'></i></button>";
					content += "<button onclick='eliminar("+ item.idcomprobante +")' style='border:0px;'><i style='color:#FF0000' class='ti-close'></i></button>";
					content += "</td>";	
					content += "</tr>";
			}
		} else {
			content = "<tr><td class='text-center' colspan='9'>No hay Registro de Comprobantes</td></tr>"
		}		
		pagination(data);
		document.querySelector("#table").innerHTML = content;
	}).fail((jqXHR,textStatus, errorThrown)=> {		
		 errorAJAX(jqXHR,textStatus, errorThrown);
	 });
}
toList();

//ABRIR MODAL
const abrirModal = (id) =>{
	 // CARGA DE COMBOS NORMALES
	//cargarCombo("/producto/marca","","","nombre","Marca","cboMarca");
	//cargarCombo("/producto/pais","","","nombre","Pais","cboPais");
	 
	if (id === 0) {
		limpiarCampos();
	} else {
		cargarCampos(id);
	}		
}

//LLENAR CAMPOS
const cargarCampos = (id) => {
	$.get(`/comprobante/listar/${id}`, (data) => {
		document.querySelector("#txtID").value = data.idcomprobante;
		document.querySelector("#txtfechaRegistro").value = data.fechaRegistro;
		document.querySelector("#txtfechaPago").value = data.fechaPago;
		document.querySelector("#estado").value = data.estado;
		document.querySelector("#pedido").value = data.pedido;
		document.querySelector("#cliente").value = data.cliente;
		document.querySelector("#usuario").value = data.usuario;
	});
}

const save = () => {	
	let id = document.querySelector("#txtID").value;
	let fer = document.querySelector("#txtfechaRegistro").value;
	let fep = document.querySelector("#txtfechaPago").value;	
	let est = document.querySelector("#txtestado").value
	let ped = document.querySelector("#txtpedido").value;
	let cli = document.querySelector("#txtcliente").value;
	let usu = document.querySelector("#txtusuario").value;
	const formJSON= JSON.stringify({    idcomprobante:id,										
										fechaRegistro:fer,
										fechaPago:fep,
										estado:est,
										pedido:ped,
										cliente:cli,
										usuario:usu,
										
								  });
	// CONFIRMACION DE SWEEALERT
	alertSweeAlertConfirmacion("/comprobante/save",formJSON);	
}
