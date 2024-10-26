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
    class User
    {
        private string id;
        private string name;
        private string password;

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

       
    }
}
