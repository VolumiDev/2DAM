const express = require("express");
const router = express.Router();
const cltrEmple = require('../controllers/empleados.controlador');

//muestra empleados
router.get('/', cltrEmple.mostrarEmpleados);

//muestra empleado
router.get('/:id', cltrEmple.mostrarEmpleado);

//crear empleados
router.post('/', cltrEmple.crearEmpleado);


//editar
router.put('/:id', cltrEmple.editarEmpleado);

//borrar
router.delete('/:id', cltrEmple.borrarEmpleado);


module.exports = router;  