using FireSharp.Response;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Tema5Prueba1
{
    public class User
    {
        //ATRIBUTOS DE LOS USUARIOS
        private string id;
        private string name;
        private string password;

        //CONSTRUCTORES CON LOS QUE GENERAMOS UNA ID MEDIANTE EL GENERADOR DE IDS UNICAS
        public User()
        {
            Guid guid = Guid.NewGuid();
            this.id = guid.ToString("N");
        }

        public User(string id, string name, string password)
        {
            Guid guid = Guid.NewGuid();
            this.id = guid.ToString("N");
            this.name = name;
            this.password = password;
        }

        public string Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Password { get => password; set => password = value; }



        //RECOGEMOS DE MANEA ASYNCRONA TODOS LOS USUARIOS.
        public async Task<List<User>> getAllUser()
        {
            DataBase db = new DataBase();
            FirebaseResponse res = await db.Cli.GetAsync("Users");
            Dictionary<string, User> usersDic = res.ResultAs<Dictionary<string, User>>();
            List<User> users = new List<User>(usersDic.Values);
            return users;
        }
       
    }
}
