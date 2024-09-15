const express = require('express');
const morgan = require('morgan')

const app = express();

const { mongoose } = require('./database');   //importamos del archivo database.js solo la constante mongoose.

//configuracion del server (Settings)
app.set('port', process.env.PORT || 3000); //Aqui le decimos que nos inicie en el puerto que le de el SO o en caso que no lo tenga que inicie en el 3000

// procesar datos (Middelawares)
app.use(morgan('dev'));  // nos da información mediante la consola de la conexión con el server.
app.use(express.json())  // con esto le entendemos el formato de json que venga desde el navegador.


// Rutas (Routes)
app.use('/api/empleados',require('./routes/empleados.routes'));

// Lanzamiento del server 
app.listen(app.get('port'), () => {
  console.log('Server on port', app.get('port'));
});
