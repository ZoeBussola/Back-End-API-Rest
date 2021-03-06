window.addEventListener("load", ()=> {

    fetch(`http://localhost:8080/pacientes/`)
    .then(response => response.json())
    .then(data => {
        let tablaPac = document.querySelector(".tablaPacbody")
data.forEach(pac=>{
    tablaPac.innerHTML+=`
    <tr>
                    <td>${pac.id} </td>
                    <td class="td_nombre">${pac.nombre}</td>
                    <td class="td_apellido">${pac.apellido}</td>
                    <td class="td_dni">${pac.dni}</td>
                    <td class="td_fechaIngreso">${pac.fechaIngreso}</td>
                    <td class="td_calle">${pac.domicilio.calle}</td>
                    <td class="td_numero">${pac.domicilio.numero}</td>
                    <td class="td_localidad">${pac.domicilio.localidad}</td>
                    <td class="td_provincia">${ pac.domicilio.provincia}</td>
                     <td> <button type="button" class="btn btn-info" onclick="findPacienteBy('${pac.id}')"
                     id="student_id"> Modificar</button>
                     <button type="button" class="btn btn-danger" onclick="deletePacienteBy('${pac.id}')"
                                          id="student_id"> Eliminar</button>
                                        </td>
</tr>
    `
})
            console.log("Paciente Data" + data);
    })



    .catch(error => console.log(error))

    fetch(`http://localhost:8080/odontologos/`)
        .then(response => response.json())
        .then(data => {

let tablaODO=document.querySelector(".tablaOdobody")

data.forEach(odo => {
    tablaODO.innerHTML+= `
<tr>
                       <tr>
                       <td>${odo.id} </td>
                       <td class="td_Onombre">${odo.nombre}</td>
                       <td class="td_Oapellido">${odo.apellido}</td>
                       <td class="td_Omatricula">${odo.numeroMatricula}</td>
                       <td class="td_Ocalle">${odo.domicilio.calle}</td>
                       <td class="td_Onumero">${odo.domicilio.numero}</td>
                       <td class="td_Olocalidad">${odo.domicilio.localidad}</td>
                       <td class="td_Oprovincia">${ odo.domicilio.provincia}</td>
                        <td> <button type="button" class="btn btn-info" onclick="findOdontologoBy('${odo.id}')"
                        id="odont_id"> Modificar</button>
                        <button type="button" class="btn btn-danger" onclick="deleteOdontologoBy('${odo.id}')"
                                             id="odont_id"> Eliminar</button>
                                           </td>
                       </tr>
                                            </tr>
`
});
                console.log(data);
        })
        .catch(error => console.log(error))



let tablatur=document.querySelector(".tablaTurBody")


        fetch(`http://localhost:8080/turnos/`)
        .then(response => response.json())
        .then(data => {
    console.log(data)
data.forEach(tur => {
    tablatur.innerHTML+= `
<tr>
                    <td class="turId">${tur.id}</td>
                    <td>${tur.paciente.nombre+" " + tur.paciente.apellido}</td>
                    <td>${tur.odontologo.nombre+" " + tur.odontologo.apellido}</td>
                    <td>${tur.fechaHora}</td>
                    <td>
                    <button type="button" class="btn btn-danger" onclick="deleteTurnoBy(${tur.id})"> Eliminar</button>
                   </td>

</tr>
`

console.log(data);
});

        })
        .catch(error => console.log(error))
})