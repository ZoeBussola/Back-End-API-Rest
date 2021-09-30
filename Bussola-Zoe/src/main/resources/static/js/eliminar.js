function deletePacienteBy(id)
{
            const url = 'http://localhost:8080/pacientes/'+ id;
                   const settings = {
                       method: 'DELETE'
                   }
                   fetch(url,settings)
                   .then(response => response.json())
 .catch(error => {

                console.log(error)
                alert("No se puede Eliminar, posible turno asociado");
            })
 window.location.reload();
}

function deleteOdontologoBy(id)
{
            const url = 'http://localhost:8080/odontologos/'+ id;
                   const settings = {
                       method: 'DELETE'
                   }
                   fetch(url,settings)
                   .then(response => {

                               return response.json();
                           })
 .catch(error => {
               console.log(error)
               console.log(response.status)
               //alert("No se puede Eliminar, posible turno asociado 500");
           })
 window.location.reload();
}

function deleteTurnoBy(id){
    console.log(id)
            const url = 'http://localhost:8080/turnos/'+ id;
                   const settings = {
                       method: 'DELETE'
                   }
                   fetch(url,settings)
                   .then(response => response.json())
 .catch(error => {
               console.log(error)
           })
 window.location.reload();
}