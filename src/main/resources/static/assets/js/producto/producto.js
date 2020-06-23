//VARIABLES GLOBALES
	let content = "";
// ELIMINAR
const eliminar = (id) => {
	alertSweeAlertDelete('producto',id);
}

// LISTADO Y PAGINACION
const toList = (page = 0) => {
	$.get(`/producto/listar/page/${page}`, (data) => {
		// console.log(data);
		content = "";
		if (data.content.length > 0) {	
			for (let item of data.content) {			
					content += "<tr>";
				    // content += "<td>"+ item.id +"</td>";
					content += "<td>"+ item.idproducto +"</td>";	
					content += "<td>"+ item.nombre +"</td>";	
					content += "<td>"+ item.serie +"</td>";	
					content += "<td>"+ item.marca.nombre + "</td>";	
					content += "<td>"+ item.pais.nombre +"</td>";	
					// acciones
					content += "<td>";
					content += "<button type='button' style='border:0px;' data-toggle='modal' data-target='#exampleModal'><i style='color:#40B7B3' class='ti-eye'></i></button>";
					content += "<button style='border:0px;'><i style='color:#0099FF' class='ti-printer'></i></button>";
					content += "<button onclick='abrirModal("+ item.idproducto +")' style='border:0px;'  data-toggle='modal' data-target='#exampleModal'><i style='color:#336600' class='ti-pencil-alt'></i></button>";
					content += "<button onclick='eliminar("+ item.idproducto +")' style='border:0px;'><i style='color:#FF0000' class='ti-close'></i></button>";
					content += "</td>";	
					content += "</tr>";
			}
		} else {
			content = "<tr><td class='text-center' colspan='9'>No hay Registro de Productos</td></tr>"
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
	cargarCombo("/producto/marca","","","nombre","Marca","cboMarca");
	//cargarCombo("/producto/pais","","","nombre","Pais","cboPais");
	 
	if (id === 0) {
		limpiarCampos();
	} else {
		cargarCampos(id);
	}		
}
// LLENAR CAMPOS
const cargarCampos = (id) => {
	$.get(`/producto/listar/${id}`, (data) => {
		document.querySelector("#txtID").value = data.idproducto;
		document.querySelector("#txtNombre").value = data.nombre;
		document.querySelector("#txtSerie").value = data.serie;
		document.querySelector("#cboMarca").value = data.marca.id;
		document.querySelector("#cboPais").value = data.pais.idpais;
	});
}



const save = () => {	
	let id = document.querySelector("#txtID").value;
	let nom = document.querySelector("#txtNombre").value;
	let ser = document.querySelector("#txtSerie").value;	
	let mar = document.querySelector("#cboMarca").value
	let pas = document.querySelector("#cboPais").value;
	const formJSON= JSON.stringify({    idproducto:id,										
										nombre:nom,
										serie:ser,																						
										marca: {
											id:mar
										},
										pais: {
											idpais:pas
										}
								  });
	// CONFIRMACION DE SWEEALERT
	alertSweeAlertConfirmacion("/producto/save",formJSON);	
}

//CARGAR COMBOS NORMALES 
const cargarComboPais = () => {	
		$.get(`/producto/pais`, (data) => {
			let combo = "";
				combo += "<option value=''>Pais</option>";		
				for (let item of data) {
					combo += "<option value='"+item.idpais+"'>"+ item.nombre +"</option>";		
				}			
			document.querySelector(`#cboPais`).innerHTML = combo;
		}).fail((jqXHR,textStatus, errorThrown)=> {		
			 errorAJAX(jqXHR,textStatus, errorThrown);
		 });	
}
cargarComboPais();
