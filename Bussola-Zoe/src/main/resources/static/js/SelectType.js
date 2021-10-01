window.addEventListener("load", ()=> {


    let btnOdon = document.querySelector(".btnodont")
    let btnPac = document.querySelector(".btnpac")

    let formOdont =document.querySelector(".FormOdont")
    let formPac = document.querySelector(".FormPacien")

    btnOdon.addEventListener('click',function () {
    formOdont.classList.toggle("desp")
    formPac.classList.add("desp")
    })

    btnPac.addEventListener('click',function () {
        formOdont.classList.add("desp")
        formPac.classList.toggle("desp")
        })


        let settings = (method, body) => {
            return ({
                method: method,
                headers:{
                    'Content-Type':'application/json'
                 },
                body: JSON.stringify(body)
            })
        }




    /*Odontologo */
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

formOdont.addEventListener('submit',(e)=>{
            e.preventDefault();

     let dataOdo  = {
            "numeroMatricula": matricula.value,
                "nombre": nombreOD.value,
                "apellido": apellidoOD.value,
            "domicilio": {
                "calle": calleOD.value,
                "numero": numerocalleOD.value,
                "localidad": barrioOD.value,
                "provincia": provinciaOD.value
            }
        }
    console.log(dataOdo)

        fetch("http://localhost:8080/odontologos/save", settings("POST", dataOdo))
        .then(response => {
            if(response.status == 409){
                alert("Esa informacion ya existe");
                throw new Error("Esa informacion ya existe");
            }
            return response.json();
        })
        .then(data => {alert("Odontologo Registrado"); window.location.pathname= '/'})
        .catch(error => console.log(error))
    })




       /*Paciente */

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


    formPac.addEventListener('submit',(e)=>{
            e.preventDefault();

        let dataPc  = {
                   "fechaIngreso":frechaPC.value,
                "nombre": nombrePC.value,
                "apellido": apellidoPC.value,
            "domicilio": {
                "calle": callePC.value,
                "numero": numerocallePC.value,
                "localidad": barrioPC.value,
                "provincia": provinciaPC.value
            },
            "dni": dniPC.value
        }
        console.log("Paciente Agregado" + dataPc.fechaIngreso);

        fetch("http://localhost:8080/pacientes/save", settings("POST", dataPc))
        .then(response => {
            if(response.status == 409){
                alert("Esa informacion ya existe");
                throw new Error("Esa informacion ya existe");
            }
            return response.json();
        })
        .then(data => {alert("Paciente Registrado"); window.location.pathname= '/'})
        .catch(error => console.log(error))
    })
    })