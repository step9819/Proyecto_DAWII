/**
 * 
 */
//VARIABLES GLOBALES
	let content = "";
// ELIMINAR
const eliminar = (id) => {
	alertSweeAlertDelete('usuario',id);
}

//LISTADO Y PAGINACION
const toList = (page = 0) => {
	$.get(`/usuario/listar/page/${page}`, (data) => {
		// console.log(data);
		content = "";
		if (data.content.length > 0) {	
			for (let item of data.content) {			
					content += "<tr>";
				    // content += "<td>"+ item.id +"</td>";
					content += "<td>"+ item.idusuario +"</td>";	
					content += "<td>"+ item.nombre +"</td>";	
					content += "<td>"+ item.apellido +"</td>";	
					content += "<td>"+ item.dni + "</td>";	
					content += "<td>"+ item.login +"</td>";	
					content += "<td>"+ item.password +"</td>";
					// acciones
					content += "<td>";
					content += "<button type='button' style='border:0px;' data-toggle='modal' data-target='#exampleModal'><i style='color:#40B7B3' class='ti-eye'></i></button>";
					content += "<button style='border:0px;'><i style='color:#0099FF' class='ti-printer'></i></button>";
					content += "<button onclick='abrirModal("+ item.idusuario +")' style='border:0px;'  data-toggle='modal' data-target='#exampleModal'><i style='color:#336600' class='ti-pencil-alt'></i></button>";
					content += "<button onclick='eliminar("+ item.idusuario +")' style='border:0px;'><i style='color:#FF0000' class='ti-close'></i></button>";
					content += "</td>";	
					content += "</tr>";
			}
		} else {
			content = "<tr><td class='text-center' colspan='9'>No hay Registro de Usuario</td></tr>"
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
	$.get(`/usuario/listar/${id}`, (data) => {
		document.querySelector("#txtID").value = data.idusuario;
		document.querySelector("#txtNombre").value = data.nombre;
		document.querySelector("#txtApellido").value = data.apellido;
		document.querySelector("#txtDNI").value = data.dni;
		document.querySelector("#txtLogin").value = data.login;
		document.querySelector("#txtPassword").value = data.password;
	});
}

const save = () => {	
	let id = document.querySelector("#txtID").value;
	let nom = document.querySelector("#txtNombre").value;
	let ape = document.querySelector("#txtApellido").value;	
	let dni = document.querySelector("#txtDNI").value;
	let log = document.querySelector("#txtLogin").value;
	let pas = document.querySelector("#txtPassword").value;
	const formJSON= JSON.stringify({    idusuario:id,										
										nombre:nom,
										apellido:ape,
										dni:dni,
										login:log,
										password:pas
										
									});

	// CONFIRMACION DE SWEEALERT
	alertSweeAlertConfirmacion("/usuario/save",formJSON);	
}