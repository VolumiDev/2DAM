//con esto permitimos que express se conecte a la base de datos de mongoDb   "npm install mongoose"
const mongoose = require('mongoose') 

const URI = 'mongodb://localhost/mean-crud';

mongoose.connect(URI)                                           // nos conectamos a la direccion que le pasasmos como parametro. Hacemos una promesa para que si se conecta correctamente.
  .then(db => console.log('DB Conneccted'))                     // lance un mensaje de conexion exitosa.
  .catch(err => console.error('Connection failure'));           // lance un mensaje por consola de error de conexion.

module.exports = mongoose;            // Exportamos el modulo de moongose para poder importarlo donde lo necesitemos mediante un 'require'