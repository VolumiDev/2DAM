const mongoose = require('mongoose');
const { Schema } = mongoose;

const EmpleSchema = new Schema({
  nombre: { type: String, require: true },
  cargo: { type: String, require: true },
  departamento: { type: String, required: true },
  salario: { type: Number, required: true }
})

module.exports = mongoose.model('Empleado', EmpleSchema)

