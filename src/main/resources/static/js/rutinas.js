function readURL(input) {
    console.log("Evento onchange activado");  // Asegúrate de que esta línea se ejecute
    if (input.files && input.files[0]) {
        var lector = new FileReader(); // Crea el lector de archivos
        lector.onload = function (e) {
            console.log("Imagen cargada correctamente");  // Confirma que la imagen se cargó
            // Cuando el archivo se haya cargado, actualizamos el elemento con el id 'blah'
            $('#blah').attr('src', e.target.result).height(200).show();
        };

        lector.readAsDataURL(input.files[0]); // Lee el archivo como URL de datos
    }
}

//Esta funcion se ejecuta dentro del browser localmente y lo que realiza es 
//incluir un elemento en el carrito de compras... si hay existencias 

function addCart(formulario){
 var idProducto = formulario.elements[0].value;
 var existencias = formulario.elements[1].value;
 if (existencias>0){
     var ruta="/carrito/agregar/"+idProducto;
     $("#resultBlock").load(ruta);
    } else{
        window.alert("No hay existencias...");
    }
}

