using FireSharp.Response;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace Tema5Prueba1
{
    class User
    {
        private int id;
        private string name;
        private string password;

        public User()
        {
        }

        public User(int id, string name, string password)
        {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public int Id { get => id; set => id = value; }
        public string Name { get => name; set => name = value; }
        public string Password { get => password; set => password = value; }

        public async void idQuery()
        {

            DataBase db = new DataBase();

            FirebaseResponse response = await db.Cli.GetAsync("Users");

            if (response.Body =="null")
            {
                this.Id = 1;
            }
            else
            {
                Dictionary<int,User> userDic = response.ResultAs<Dictionary<int,User>>();
                List<User> userList = new List<User>(userDic.Values);
                MessageBox.Show($"la lista tiene {userList.Count}");
                User u = userList.OrderByDescending(x => x.id).FirstOrDefault();
                this.Id = u.Id + 1;
            }  
        }
    }
}
