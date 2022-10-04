const BASE_URL_MSG = 'https://g0497c038904c6c-dbreto1.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/message/message';
let countID;

function leerMensajes(){
    $.ajax({
        url: BASE_URL_MSG,
        type: 'GET',
        dataType: 'JSON',
        success: (res)=>{
            let mensajes = res.items;

            $('#listaMensajes').empty();
            $('#listaMensajes').append(
                `<thead>
          <th>ID</th>
          <th>Mensaje</th>
        </thead>
        <tbody></tbody>`
            )

            for(let i=0; i<mensajes.length; i++){
                $('#listaMensajes tbody').append(
                    `<tr>
            <th>${mensajes[i].id}</th>
            <td>${mensajes[i].messagetext}</td>
            <td><button onclick="formEditar(${mensajes[i].id}, '${mensajes[i].messagetext}')">Editar</button></td>
            <td><button onclick="borrarMensaje(${mensajes[i].id})">Borrar</button></td>
          </tr>`
                )
            }

            countID = mensajes.length;
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

function formEditar(idMsg, msg){
    $('#mensaje').val(msg);
    $('#enviarMensaje').attr('onclick', `editarMensaje(${idMsg})`)
    $('#enviarMensaje').text('Actualizar')
}

function editarMensaje(idMsg){
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
}

function borrarMensaje(idMsg){
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
}

function limpiar(){
    $('#mensaje').val("");
}