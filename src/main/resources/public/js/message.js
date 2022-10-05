const BASE_URL_MSG = 'http://localhost:8080/api/Message';
console.log("Holaaa");

function leerMensajes(){
    $.ajax({
        url: `${BASE_URL_MSG}/all`,
        type: 'GET',
        dataType: 'JSON',
        success: (res)=>{
            console.log(res);
            let mensajes = res;

            $('#listaMensajes').empty();
            $('#listaMensajes').append(
                `<table id="tablaMensajes" style="border: 1px solid black">
                    <thead>
                        <th>Cliente</th>
                        <th>Bicicleta</th>
                        <th>Mensaje</th>
                    </thead>
                    <tbody></tbody>
                </table>`
            )

            for(let i=0; i<mensajes.length; i++){
                $('#tablaMensajes tbody').append(
                    `<tr>
                        <th>${mensajes[i].client.name}</th>
                        <th>${mensajes[i].bike.name}</th>
                        <td>${mensajes[i].messageText}</td>
                    </tr>`
                )
            }
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        },
        complete: ()=>{
            $('#listarMensajes').text('Ocultar');
            $('#listarMensajes').attr('onclick', 'ocultarMensajes()');
        }
    })
}

function ocultarMensajes(){
    $('#listarMensajes').text('Consultar');
    $('#listarMensajes').attr('onclick', 'leerMensajes()');
    $('#listaMensajes').empty();
}

function guardarMensaje(){
    $.ajax({
        url: BASE_URL_MSG,
        type: 'POST',
        data: JSON.stringify({
            id: countID+1,
            messagetext: $('#mensaje').val()
        }),
        contentType: 'application/json',
        success: (res)=>console.log('Guardando mensaje...'),
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        },
        complete: ()=>{
            $('#mensaje').val("");
            leerMensajes();
        }
    })
}

/*function formEditar(idMsg, msg){
    $('#mensaje').val(msg);
    $('#enviarMensaje').attr('onclick', `editarMensaje(${idMsg})`)
    $('#enviarMensaje').text('Actualizar')
}*/

/*function editarMensaje(idMsg){
    $.ajax({
        url: BASE_URL_MSG,
        type: 'PUT',
        data: JSON.stringify({
            id: idMsg,
            messagetext: $('#mensaje').val()
        }),
        contentType: 'application/json',
        success: (res)=>console.log('Editando mensaje...'),
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        },
        complete: ()=>{
            $('#mensaje').val('');
            $('#enviarMensaje').attr('onclick', `guardarMensaje()`)
            $('#enviarMensaje').text('Guardar');
            leerMensajes();
        }
    })
}*/

/*function borrarMensaje(idMsg){
    $.ajax({
        url: BASE_URL_MSG,
        type: 'DELETE',
        data: JSON.stringify({id:idMsg}),
        contentType: 'application/json',
        success: (res)=>{
            console.log('Eliminando mensaje...')
        },
        error: (err)=>{
            alert(`Error: Status ${err.status}`)
        },
        complete: ()=>leerMensajes()
    })
}*/

function limpiar(){
    $('#mensaje').val("");
}