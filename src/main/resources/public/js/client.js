const BASE_URL_CLI = 'https://g0497c038904c6c-dbreto1.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/client/client';

function obtenerCliente(){
    $.ajax({
        url: BASE_URL_CLI,
        type: "GET",
        dataType: "JSON",
        success: function(respuesta){
            console.log(respuesta);
            mostrarClientes(respuesta.items);
        }
    });
}

function mostrarClientes(items){
    $('#consultarCli').text('Ocultar');
    $('#consultarCli').attr('onclick', 'limpiarTabla()');

    let myTable=
        `<table style="border: 1px solid black">
        <thead>
            <th>ID</th>
            <th>Nombre</th>
            <th>Email</th>
            <th>Edad</th>
        </thead>
        <tbody>`;

    for(i=0; i<items.length; i++){
        myTable += "<tr>";
        myTable += "<td>" + items[i].id + "</td>";
        myTable += "<td>" + items[i].name + "</td>";
        myTable += "<td>" + items[i].email + "</td>";
        myTable += "<td>" + items[i].age + "</td>";
        myTable += "<td> <button onclick='borrarCliente(" + items[i].id + ")'>Borrar</button>";
        myTable += "<tr>";
    }
    myTable += "</tbody></table>";

    $("#listaClientes").empty();
    $("#listaClientes").append(myTable);
}

function enviarCliente(){
    let dcliente = {
        id: $("#idCli").val(),
        name: $("#nameCli").val(),
        email: $("#emailCli").val(),
        age: $("#ageCli").val()
    };

    let dataToSend = JSON.stringify(dcliente);

    $.ajax({
        url: BASE_URL_CLI,
        type: "POST",
        data: dataToSend,
        contentType: 'application/json',
        success: function(respuesta){
            obtenerCliente();
        }
    });
}

function actualizarCliente(){
    let dCliente = {
        id: $("#idCli").val(),
        name: $("#nameCli").val(),
        email: $("#emailCli").val(),
        age: $("#ageCli").val()
    };

    let dataToSend = JSON.stringify(dCliente);

    $.ajax({
        url: BASE_URL_CLI,
        type: "PUT",
        data:dataToSend,
        contentType:"application/json",
        success: function(respuesta){
            console.log(respuesta);
            $("#idCli").val("");
            $("#nameCli").val("");
            $("#emailCli").val("");
            $("#ageCli").val("");
            obtenerCliente();
        }
    });
}

function borrarCliente(idCliente){
    let dCliente = {
        id:idCliente
    };

    let dataToSend = JSON.stringify(dCliente);

    $.ajax({
        url: BASE_URL_CLI,
        type: "DELETE",
        data: dataToSend,
        contentType:"application/json",
        success: function(respuesta){
            obtenerCliente();
        }
    });
}

function buscarCliente(){
    let dCliente = $("#idCli").val();

    $.ajax({
        url: `${BASE_URL_CLI}/${dCliente}`,
        type: "GET",
        dataType: "JSON",
        success: function(respuesta){
            console.log(respuesta);
            $("#idCli").val("");
            mostrarClientes(respuesta.items);
        }
    });
}

function limpiarTabla(){
    $('#consultarCli').text('Consultar');
    $('#consultarCli').attr('onclick', 'obtenerCliente()');
    $('#listaClientes').empty();
}