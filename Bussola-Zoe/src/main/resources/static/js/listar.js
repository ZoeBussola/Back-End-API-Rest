window.addEventListener("load", ()=> {

let tablatur=document.querySelector(".tablaTurBody")


        fetch(`http://localhost:8080/turnos/`)
        .then(response => response.json())
        .then(data => {

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