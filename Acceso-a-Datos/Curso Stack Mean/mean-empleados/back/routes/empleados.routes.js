const express = require('express');
const router = express.Router();

const empleadoCtrl = require('../controllers/empleado.controller')

router.get('/', empleadoCtrl.getEmpleados);
router.post('/', empleadoCtrl.crearEmpleado);
router.get('/:id', empleadoCtrl.getEmpleado);
router.put('/:id', empleadoCtrl.editEmpeleado);
router.delete('/:id', empleadoCtrl.deleteEmpleado);

module.exports = router;