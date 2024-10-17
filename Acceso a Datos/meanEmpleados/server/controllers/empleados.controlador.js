 const controladorEmpleado = {};

 controladorEmpleado.mostrarEmpleados = (req, res) => {  // HACEMOS UNA PETICION GET 'REQ' SIEMPRE TIENE UN OBEJTO RESPONSE.
    res.json({                                              //definimos la funcion en el controlador. Deforma que el archivo del controlador
        status: 'Funcionando desde controllers!'                              //va a contener los metodos 
    })
};

controladorEmpleado.mostrarEmpleado = () => {
    
};


 controladorEmpleado.crearEmpleado = () => {
    
 };

 controladorEmpleado.editarEmpleado = () => {
    
 };

 controladorEmpleado.borrarEmpleado = () => {
    
 };


 module.exports = controladorEmpleado;