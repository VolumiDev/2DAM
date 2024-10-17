const mongoose = require('mongoose');
const { Schema } = mongoose;            //IMPORTAMOS LOS SCQUEMAS DE LA BD PARA PODER TRABAJAR CON ELLA

const empleadosSchema = new Schema({                                  // EL SCHEMA DEFINE LA ESTRUCTURA DE LOS DOCUMENTOS EN UNA COLECTION
    nombre: {type: String, require: true },                     // LOS DOCUMENTOS SON LOS OBJETOS QUE SE ALMACENAN EN JSON (EQUIVALE A LAS TUPLAS)
    cargo: {type: String, require: true },                      // UNA COLECCION EN MONGO ES UNA AGRUPACION DE DOCUMENTOS (EQIVALE A LAS TABLAS)
    departamento: {type: String, require: true },
    salario: {type: Number, require: true },
});

module.exports = mongoose.model('Empleado', empleadosSchema);

