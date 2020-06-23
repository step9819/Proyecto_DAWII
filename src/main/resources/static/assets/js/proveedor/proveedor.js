/**
 * 
 */
//VARIABLES GLOBALES
	let content = "";
// ELIMINAR
const eliminar = (id) => {
	alertSweeAlertDelete('proveedor',id);
}

//LISTADO Y PAGINACION
const toList = (page = 0) => {
	$.get(`/proveedor/listar/page/${page}`, (data) => {
		// console.log(data);
		content = "";
		if (data.content.length > 0) {	
			for (let item of data.content) {			
					content += "<tr>";
				    // content += "<td>"+ item.id +"</td>";
					content += "<td>"+ item.idproveedor +"</td>";	
					content += "<td>"+ item.razonsocial +"</td>";	
					content += "<td>"+ item.ruc +"</td>";	
					content += "<td>"+ item.direccion +"</td>";
					content += "<td>"+ item.telefono +"</td>";
					content += "<td>"+ item.celular +"</td>";
					content += "<td>"+ item.contacto +"</td>";
					content += "<td>"+ item.ubigeo.departamento + "</td>";	
						
					// acciones
					content += "<td>";
					content += "<button type='button' style='border:0px;' data-toggle='modal' data-target='#exampleModal'><i style='color:#40B7B3' class='ti-eye'></i></button>";
					content += "<button style='border:0px;'><i style='color:#0099FF' class='ti-printer'></i></button>";
					content += "<button onclick='abrirModal("+ item.idproveedor +")' style='border:0px;'  data-toggle='modal' data-target='#exampleModal'><i style='color:#336600' class='ti-pencil-alt'></i></button>";
					content += "<button onclick='eliminar("+ item.idproveedor +")' style='border:0px;'><i style='color:#FF0000' class='ti-close'></i></button>";
					content += "</td>";	
					content += "</tr>";
			}
		} else {
			content = "<tr><td class='text-center' colspan='9'>No hay Registro de Proveedores</td></tr>"
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
	//cargarCombo("/proveedor/ubigeo","","","departamento","Ubigeo","cboUbigeo");
	 
	if (id === 0) {
		limpiarCampos();
	} else {
		cargarCampos(id);
	}		
}

//LLENAR CAMPOS
const cargarCampos = (id) => {
	$.get(`/proveedor/listar/${id}`, (data) => {
		document.querySelector("#txtID").value = data.idproveedor;
		document.querySelector("#txtRazonSocial").value = data.razonsocial;
		document.querySelector("#txtRuc").value = data.ruc;
		document.querySelector("#txtDireccion").value = data.direccion;
		document.querySelector("#txtTelefono").value = data.telefono;
		document.querySelector("#txtCelular").value = data.celular;
		document.querySelector("#txtContacto").value = data.contacto;
		document.querySelector("#cboUbigeo").value = data.ubigeo.idubigeo;
		
	});
}

const save = () => {	
	let id = document.querySelector("#txtID").value;
	let raz = document.querySelector("#txtRazonSocial").value;
	let ruc = document.querySelector("#txtRuc").value;	
	let dir = document.querySelector("#txtDireccion").value;	
	let tlf = document.querySelector("#txtTelefono").value;	
	let cel = document.querySelector("#txtCelular").value;	
	let con = document.querySelector("#txtContacto").value;	
	let ubi = document.querySelector("#cboUbigeo").value;
	const formJSON= JSON.stringify({    idproveedor:id,										
										razonsocial:raz,
										ruc:ruc,
										direccion:dir,
										telefono:tlf,
										celular:cel,
										contacto:con,
										ubigeo: {
											idubigeo:ubi
										}
								  });
	
	// CONFIRMACION DE SWEEALERT
	alertSweeAlertConfirmacion("/proveedor/save",formJSON);	
}


//CARGAR COMBOS NORMALES 
const cargarComboUbigeo = () => {	
		$.get(`/proveedor/ubigeo`, (data) => {
			let combo = "";
				combo += "<option value=''>Ubigeo</option>";		
				for (let item of data) {
					combo += "<option value='"+item.idubigeo+"'>"+ item.departamento +"</option>";		
				}			
			document.querySelector(`#cboUbigeo`).innerHTML = combo;
		}).fail((jqXHR,textStatus, errorThrown)=> {		
			 errorAJAX(jqXHR,textStatus, errorThrown);
		 });	
}
cargarComboUbigeo();
