 const controladorEmpleado = {};
 const empleadosModels = require('../models/empleados');

 controladorEmpleado.mostrarEmpleados =async (req, res) => {  // HACEMOS UNA PETICION GET 'REQ' SIEMPRE TIENE UN OBEJTO RESPONSE.
    const leerEmppleados = await empleadosModels.find();
        //definimos la funcion en el controlador. Deforma que el archivo del controlador
        //va a contener los metodos 
    res.json(leerEmppleados)
};
//LE PASAMOS UNA VARIABLE POR POST PARA QUE NOS DEVUELVA LA INFORMACION DEL EMPLEADO
controladorEmpleado.mostrarEmpleado = async (req, res) => {   
    const idEmpleado = req.params.id;            
    const leerEmpleado = await empleadosModels.findById(idEmpleado);
    res.json(leerEmpleado);
};
 controladorEmpleado.crearEmpleado = async (req, res) => {
    const nuevoEmpleado = new empleadosModels(req.body);
    await nuevoEmpleado.save();
    res.json('Empleado guardado');
 };

 controladorEmpleado.editarEmpleado = () => {
    
 };

 controladorEmpleado.borrarEmpleado = () => {
    
 };


 module.exports = controladorEmpleado;