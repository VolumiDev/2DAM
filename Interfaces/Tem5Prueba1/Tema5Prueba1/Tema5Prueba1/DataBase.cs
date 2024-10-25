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
        IFirebaseConfig config = new FirebaseConfig
        {
            AuthSecret = "lJFrGoJnREU0vlTfY7m1yHpBrAzlxUWF7HaNhDpm",
            BasePath = "https://tema5prueba1-default-rtdb.europe-west1.firebasedatabase.app/"
        };

        FirebaseClient cli;
        public DataBase()
        { 
            cli = new FirebaseClient(config);
            if(cli == null )
            {
                MessageBox.Show("Error en la conexion a la Base de datos");
            }
        }

        public FirebaseClient Cli { get => cli; set => cli = value; }
    }
}
