using FireSharp;
using FireSharp.Config;
using FireSharp.Interfaces;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Tema5Prueba1
{
    class DataBase
    {
        //INICIAMOS LA CONFIGURACION DE LA CONEXION A LA BASE DE DATOS
        IFirebaseConfig config = new FirebaseConfig
        {
            //SECRETO DE LA BASE DE DATOS DE FIREBASE
            AuthSecret = "lJFrGoJnREU0vlTfY7m1yHpBrAzlxUWF7HaNhDpm",
            //URL DE LA BASE DE DATOS DE FIREBASE
            BasePath = "https://tema5prueba1-default-rtdb.europe-west1.firebasedatabase.app/"
        };

        FirebaseClient cli;

        //COSNTRUCTOR EN EL QUE INICALIZAMOS EL CLIENTE CON EL QUE REALIZAREMOS LAS OPERACIONES EN LA BASE DE DATOS
        public DataBase()
        { 
            cli = new FirebaseClient(config);
            //CONTRALAMOS SI HAY ALGUN ERROR PARA AVISAR AL USUARIO
            if(cli == null )
            {
                MessageBox.Show("Error en la conexion a la Base de datos");
            }
        }

        public FirebaseClient Cli { get => cli; set => cli = value; }
    }
}
