const express = require('express');   //REQUERIMOS EL OBJETO EXPRESS PARA USO
const app = express();   
 
const { mongoose } = require('./database')


const morgan = require('morgan');     //NOS  DA INFORMACION POR CONSOLA DE LAS PETICIONES GET 
app.use(morgan('dev'));



//SETTINGS
app.set('port', process.env.PORT || 3000);  //ASIGNAMOS A LA VARIABLE PORT EL PUERTO ESTABLECIDO POR SO O POR DEFECTO CON EL 3000


//MIDDELWARES
app.use(express.json());  //LE INDICAMOS QUE ENTIENDA LOS JSON QUE LE LLEGARAN DESDE LA PETICION GET

//ROUTES

app.listen(app.get('port'), () => {                             //HACEMOS QUE LA APP ESCUCHE EN EL EL PUERTO PORT QUE HEMOS ESTABLECIDO ARRIBA.
    console.log('server ejecutandose en', app.get('port'));
}); 