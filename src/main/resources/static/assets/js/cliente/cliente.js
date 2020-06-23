//VARIABLES GLOBALES
	let content = "";
// ELIMINAR
const eliminar = (id) => {
	alertSweeAlertDelete('cliente',id);
}

// LISTADO Y PAGINACION
const toList = (page = 0) => {
	$.get(`/cliente/listar/page/${page}`, (data) => {
		// console.log(data);
		content = "";
		if (data.content.length > 0) {	
			for (let item of data.content) {			
					content += "<tr>";
				    // content += "<td>"+ item.id +"</td>";
					content += "<td>"+ item.id +"</td>";	
					content += "<td>"+ item.correo +"</td>";	
					content += "<td>"+ item.fechaRegistro +"</td>";
					content += "<td>"+ item.login +"</td>";
					content += "<td>"+ item.password +"</td>";
					content += "<td>"+ item.direccion +"</td>";
					content += "<td>"+ item.estado +"</td>";
					content += "<td>"+ item.ubigeo.departamento + "</td>";	
						
					// acciones
					content += "<td>";
					content += "<button type='button' style='border:0px;' data-toggle='modal' data-target='#exampleModal'><i style='color:#40B7B3' class='ti-eye'></i></button>";
					content += "<button style='border:0px;'><i style='color:#0099FF' class='ti-printer'></i></button>";
					content += "<button onclick='abrirModal("+ item.id +")' style='border:0px;'  data-toggle='modal' data-target='#exampleModal'><i style='color:#336600' class='ti-pencil-alt'></i></button>";
					content += "<button onclick='eliminar("+ item.id +")' style='border:0px;'><i style='color:#FF0000' class='ti-close'></i></button>";
					content += "</td>";	
					content += "</tr>";
			}
		} else {
			content = "<tr><td class='text-center' colspan='9'>No hay Registro de Clientes</td></tr>"
		}		
		pagination(data);
		document.querySelector("#table").innerHTML = content;
	}).fail((jqXHR,textStatus, errorThrown)=> {		
		 errorAJAX(jqXHR,textStatus, errorThrown);
	 });
}
toList();


// ABRIR MODAL
const abrirModal = (id) =>{
	 // CARGA DE COMBOS NORMALES
	//cargarCombo("/cliente/ubigeo","","","departamento","Ubigeo","cboUbigeo");
	 
	if (id === 0) {
		limpiarCampos();
	} else {
		cargarCampos(id);
	}		
}
// LLENAR CAMPOS
const cargarCampos = (id) => {
	$.get(`/cliente/listar/${id}`, (data) => {
		document.querySelector("#txtID").value = data.id;
		document.querySelector("#txtCorreo").value = data.correo;
		document.querySelector("#txtfechaRegistro").value = data.fechaRegistro;
		document.querySelector("#txtLogin").value = data.login;
		document.querySelector("#txtPassword").value = data.password;
		document.querySelector("#txtDireccion").value = data.direccion;
		document.querySelector("#txtEstado").value = data.estado;
		document.querySelector("#cboUbigeo").value = data.ubigeo.idubigeo;
	});
}



const save = () => {	
	let id = document.querySelector("#txtID").value;
	let cor = document.querySelector("#txtCorreo").value;
	let fec = document.querySelector("#txtfechaRegistro").value;	
	let log = document.querySelector("#txtLogin").value;
	let pas = document.querySelector("#txtPassword").value;
	let dir = document.querySelector("#txtDireccion").value;
	let est = document.querySelector("#txtEstado").value;
	let ubi = document.querySelector("#cboUbigeo").value;
	const formJSON= JSON.stringify({    id:id,	
										correo:cor,
										fechaRegistro:fec,
										login:log,
										password:pas,
										direccion:dir,
										estado:est,
										ubigeo: {
											idubigeo:ubi
										}
								  });
	// CONFIRMACION DE SWEEALERT
	alertSweeAlertConfirmacion("/cliente/save",formJSON);	
}

//CARGAR COMBOS NORMALES 
const cargarComboUbigeo = () => {	
		$.get(`/cliente/ubigeo`, (data) => {
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
