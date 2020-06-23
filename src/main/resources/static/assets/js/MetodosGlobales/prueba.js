// NUEVO Y EDITAR
$(document).ready( () => {	
const save = () => {
	const id   = $("#txtID").val();
	const nom  = $("#txtNombre").val();
	const des  = $("#txtDescripcion").val();
	const int  = $("#txtCodigoInterno").val();
	const bar  = $("#txtCodigoBarra").val();
	const pre  = $("#txtPrecio").val();
	const stka = $("#txtStockActual").val();
	const stkm = $("#txtStockMinimo").val();
	const stkx = $("#txtStockMaximo").val();
	const mar  = $("#txtMarca").val();
	const med  = $("#cboMedida").val();
	const formJSON = JSON.stringify({id:id,codInterno,int,codBarra:bar,nomProducto:nom,nomLargo:des,stkActual:stka,stkMinimo:stkm,stkMaxmimo:stkx,precio:pre,marca:mar,medida:{id:med}});
	alertSweeAlertConfirmacion("/producto/save",formJSON);
}

//CARGAR IMAGENES 
const cargaImagenes = () => {
	const img  = document.querySelector("#img").src;
	
	let frm=new FormData();
	frm.append("image",img);
	$.ajax({
		type: "POST",
		 url: "https://api.imgbb.com/1/upload?key=0743fd8ca8c804293b325a87e4b0a5ec",
		 data: frm,
		 contentType: false,
         processData: false,
		 success: (data)=>{
			 console.log(data.data.image.url);
			 console.log("Exitoso");
		 }
	})
	console.log(img);
}