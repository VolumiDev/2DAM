const mongoose = require('mongoose');  //REQUERIMOS LA DEPENDECIA DE MONGOOSE
const URI = 'mongodb://127.0.0.1:27017/mean-crud';   //CONSTANTE QUE NECESIMOS PARA HACER LA CONEXION 

mongoose.connect(URI)
    .then(db => console.log("Conectada a la base de datos"))
    .catch(err => console.log(err,"Error de conexion"));


module.exports = mongoose;
