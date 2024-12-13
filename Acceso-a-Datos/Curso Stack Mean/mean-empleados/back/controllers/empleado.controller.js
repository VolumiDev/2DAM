const Empleado = require('../models/empleado');   // Importamos el modelo de datos de los empleados para que se
const empleadoCtrl = {};

empleadoCtrl.getEmpleados = async (req, res) => {
  const empleados = await Empleado.find();
  res.json(empleados)
}

empleadoCtrl.crearEmpleado = async (req, res) => {
  const empleado = new Empleado(req.body);
  await empleado.save();
  res.json({
    'status': 'Empleado guradado',
  });
}; 

empleadoCtrl.getEmpleado = async (req, res) => {
  const empleado = await Empleado.findById(req.params.id);
  res.json(empleado);
};

empleadoCtrl.editEmpeleado = async (req, res) => {
  const {id} = req.params;
  const empleadoEditar = {
    nombre: req.body.nombre,
    cargo: req.body.cargo,
    departamento: req.body.departamento,
    salario: req.body.salario
  }
  await Empleado.findByIdAndUpdate(ida, { $set: empleadoEditar }, {new: true});
  res.json({
    status: 'Empleado actualizado'
  });
};

empleadoCtrl.deleteEmpleado = async(req, res) => {
  const { id } = req.params;
  await Empleado.findByIdAndDelete(id);
  res.json({staus: 'Empleado eliminado'});
};


module.exports = empleadoCtrl;