window.addEventListener("load", ()=> {
    const formulario = document.querySelector('#update_Paciente_form');

    formulario.addEventListener('submit', function (event) {
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

      let pacienteId_td = document.querySelector('.idPC').value;
             let usuarioPC_td = document.querySelector(".usuarioPC").value;
             let passwordPC_td = document.querySelector(".passwordPC").value;
             let nombrePC_td = document.querySelector(".nombrePC").value;
             let apellidoPC_td = document.querySelector(".apellidoPC").value;
             let dniPC_td = document.querySelector(".dniPC").value;
             let frechaPC_td = document.querySelector(".fechaPC").value
             let callePC_td = document.querySelector(".callePC").value;
             let numerocallePC_td = document.querySelector(".numeroPC").value;
             let barrioPC_td = document.querySelector(".barrioPC").value;
             let provinciaPC_td = document.querySelector(".provinciaPC").value;

console.log(nombrePC_td)
              let dataPc  = {
                         "id":pacienteId_td,
                         "usuario": {
                             "id":idUS,
                             "nombre": nombrePC_td,
                             "apellido": apellidoPC_td,
                             "usuario": usuarioPC_td,
                             "password": passwordPC_td
                         },
                         "fechaIngreso": frechaPC_td,
                         "domicilio": {
                             "id":idDom,
                             "calle": callePC_td,
                             "numero": numerocallePC_td,
                             "localidad": barrioPC_td,
                             "provincia": provinciaPC_td
                         },
                         "dni": dniPC_td
                     }
             console.log(dataPc)
               fetch("http://localhost:8080/pacientes/",settings('PUT',dataPc))
               .then(response => response.json())
               .then(data => {alert("Paciente Modificado");window.location.reload()})
         })




             const formularioOdo = document.querySelector('#update_Odontologo_form');

             formularioOdo.addEventListener('submit', function (event) {
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

                 let odontologoId_tdO = document.querySelector(".idOD").value;
                                 let usuarioPC_tdO = document.querySelector(".usuarioOD").value;
                                 let passwordPC_tdO = document.querySelector(".passwordOD").value;
                                 let nombrePC_tdO = document.querySelector(".nombreOD").value;
                                 let apellidoPC_tdO = document.querySelector(".apellidoOD").value;
                                 let matriculaPC_tdO = document.querySelector(".matriculaOD").value;
                                 let callePC_tdO = document.querySelector(".calleOD").value;
                                 let numerocallePC_tdO = document.querySelector(".numeroOD").value;
                                 let barrioPC_tdO = document.querySelector(".barrioOD").value;
                                 let provinciaPC_tdO = document.querySelector(".provinciaOD").value;

                 let dataOD  = {
                     "id":odontologoId_tdO,
                     "numeroMatricula": matriculaPC_tdO,
                     "admin": isAdmin,
                     "usuario": {
                         "id":idUSOd,
                         "nombre": nombrePC_tdO,
                         "apellido": apellidoPC_tdO,
                         "usuario": usuarioPC_tdO,
                         "password": passwordPC_tdO
                     },
                     "domicilio": {
                         "id":idDomOd,
                         "calle": callePC_tdO,
                         "numero": numerocallePC_tdO,
                         "localidad": barrioPC_tdO,
                         "provincia": provinciaPC_tdO
                     }
                 }
                 console.log(dataOD)

             console.log(dataOD.usuario)
             console.log(dataOD.domicilio)
                   fetch("http://localhost:8080/odontologos/",settings('PUT',dataOD))
                   .then(response => response.json())
                   .then(data => {alert("Odontologo Modificado");window.location.reload()})
             })
      })

      let idPC = document.querySelector(".idPC");
      let usuarioPC = document.querySelector(".usuarioPC");
            let passwordPC = document.querySelector(".passwordPC");
            let nombrePC = document.querySelector(".nombrePC");
            let apellidoPC = document.querySelector(".apellidoPC");
            let dniPC = document.querySelector(".dniPC");
            let frechaPC = document.querySelector(".fechaPC")
            let callePC = document.querySelector(".callePC");
            let numerocallePC = document.querySelector(".numeroPC");
            let barrioPC = document.querySelector(".barrioPC");
            let provinciaPC = document.querySelector(".provinciaPC");
            let idUS;
            let idDom;
         function findPacienteBy(id) {
               const url = '/pacientes'+"/"+id;
               const settings = {
                   method: 'GET'
               }
               fetch(url,settings)
               .then(response => response.json())
               .then(data => {
                   let paciente = data;
                   idPC.value = paciente.id;
                   nombrePC.value = paciente.usuario.nombre;
                   apellidoPC.value = paciente.usuario.apellido;
                   usuarioPC.value = paciente.usuario.usuario;
                   passwordPC.value = paciente.usuario.password;
                   dniPC.value = paciente.dni;
                   frechaPC.value = paciente.fechaIngreso;
                   callePC.value = paciente.domicilio.calle;
                   numerocallePC.value = paciente.domicilio.numero;
                   barrioPC.value = paciente.domicilio.localidad;
                   provinciaPC.value = paciente.domicilio.provincia;
                   idUS = paciente.usuario.id;
                   idDom = paciente.domicilio.id;
                   document.querySelector('#div_paciente_updating').style.display = "block";
               }).catch(error => {
                   alert("Error: " + error);
               })
             }




    let idOD = document.querySelector(".idOD");
        let usuarioOD = document.querySelector(".usuarioOD");
        let passwordOD = document.querySelector(".passwordOD");
        let nombreOD = document.querySelector(".nombreOD");
        let apellidoOD = document.querySelector(".apellidoOD");
        let calleOD = document.querySelector(".calleOD");
        let numerocalleOD = document.querySelector(".numeroOD");
        let barrioOD = document.querySelector(".barrioOD");
        let provinciaOD = document.querySelector(".provinciaOD");
        let admin = document.querySelector(".admin");
        let matricula = document.querySelector(".matriculaOD");
        let isAdmin;
        let idUSOd;
        let idDomOd;

    function findOdontologoBy(id) {
          const url = '/odontologos'+"/"+id;
          const settings = {
              method: 'GET'
          }
          fetch(url,settings)
          .then(response => response.json())
          .then(data => {
              let odontologo = data;

              idOD.value = odontologo.id;
              nombreOD.value = odontologo.usuario.nombre;
              apellidoOD.value = odontologo.usuario.apellido;
              usuarioOD.value = odontologo.usuario.usuario;
              passwordOD.value = odontologo.usuario.password;
              matricula.value = odontologo.numeroMatricula;
              calleOD.value = odontologo.domicilio.calle;
              numerocalleOD.value = odontologo.domicilio.numero;
              barrioOD.value = odontologo.domicilio.localidad;
              provinciaOD.value = odontologo.domicilio.provincia;
              isAdmin = odontologo.admin
              idUSOd = odontologo.usuario.id;
              idDomOd = odontologo.domicilio.id;
              document.querySelector('#div_Odonto_updating').style.display = "block";
          }).catch(error => {
              alert("Error: " + error);
          })
        }