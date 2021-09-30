

let infopac = document.querySelector(".inpIdPaciente").value

let fromTur = document.querySelector("#update_Turno_form")
let divForm = document.querySelector(".formturno")
let btnAgen = document.querySelector(".agen")
let aleOdo = document.querySelector(".aleOdo")
let alePac = document.querySelector(".alePac")




btnAgen.addEventListener("click" ,function () {
    divForm.classList.toggle("aparece")
})


fromTur.addEventListener("submit",function (event) {
    event.preventDefault()

    let settings = (method, body) => {
        return ({
            method: method,
            headers:{
                'Content-Type':'application/json'
             },
            body: JSON.stringify(body)
        })
    }

            let dataTur={
                "fechaHora": document.querySelector(".inpFyH").value,
                "odontologo": odontologoInfo,
                "paciente": pacienteInfo,
            }
        if (dataTur.fechaHora == "") {
            alert("ingrese una Fecha!")
            console.log(dataTur.fechaHora);
            console.log(odontologoInfo);
            console.log(pacienteInfo);
        }
        else{


            fetch("http://localhost:8080/turnos/save", settings("POST", dataTur))
            .then(response => {
                if(response.status == 409){
                    alert("Esa informacion ya existe");
                    throw new Error("Esa informacion ya existe");
                }
                else if (response.status == 500) {
                    alert("Falta informacion");
                    throw new Error("Falta informacion");
                }
                return response.json();
            })
            .then(data => {alert("Turno Registrado"); window.location.pathname= '/listar.html'})
            .catch(error => console.log(error))

        }


 })


let odontologoInfo;
let pacienteInfo;

console.log(odontologoInfo)

        function findOdontologoTurBy(id) {
            id=document.querySelector(".inpIdOdontologo").value;
            if(id == ""){
                alert("Ingresa un ID valido");
           throw new Error("Ingresa un ID valido");
       }
            console.log("id " + id);
          const url = '/odontologos'+"/"+id;
          console.log(url);
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => {
            if(response.status == 409){
                alert("Esa informacion ya existe");
                throw new Error("Esa informacion ya existe");
            }
            else if(response.status == 500){
                 alert("Odontologo no Encontrado, vuleve a intentarlo");
            throw new Error("Odontologo no Encontrado");
        }

            return response.json();
        })
          .then(data => {
        odontologoInfo =data
        aleOdo.style.display = 'block'
       aleOdo.innerHTML += data.usuario.nombre+" "+data.usuario.apellido
          }).catch(error => {
              console.log(error)
          })
        }





           function findPacienteTurBy(id) {
            id=document.querySelector(".inpIdPaciente").value;
             if(id == ""){
                            alert("Ingresa un ID valido");
                       throw new Error("Ingresa un ID valido");
                   }
                 const url = '/pacientes'+"/"+id;
                 const settings = {
                     method: 'GET'
                 }
                 console.log(url);
                 fetch(url,settings)
                 .then(response => {
                            if(response.status == 409){
                                alert("Esa informacion ya existe");
                                throw new Error("Esa informacion ya existe");
                            }
                            else if(response.status == 500){
                                 alert("Paciente no Encontrado, vuleve a intentarlo");
                            throw new Error("Paciente no Encontrado");
                        }

                            return response.json();
                        })
                 .then(data => {
                                      pacienteInfo= data
                                      alePac.style.display = 'block'
                                      alePac.innerHTML += data.usuario.nombre+" " + data.usuario.apellido
                                  }).catch(error => {
                     console.log(error)
                 })
               }

