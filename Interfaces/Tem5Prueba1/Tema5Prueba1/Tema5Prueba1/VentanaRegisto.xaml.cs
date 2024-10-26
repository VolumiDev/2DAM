using FireSharp.Response;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Tema5Prueba1
{
    /// <summary>
    /// Lógica de interacción para VentanaRegisto.xaml
    /// </summary>
    public partial class VentanaRegisto : Window
    {
        public VentanaRegisto()
        {
            InitializeComponent();
        }

        private void onClick(object sender, RoutedEventArgs e)
        {
            if(String.IsNullOrEmpty(tb_user.Text) || String.IsNullOrEmpty(tb_pass.Password)){
                MessageBox.Show("Rellena todos los campos");
            }
            else
            {
                User user = new User();
                user.Name = tb_user.Text;
                user.Password = tb_pass.Password;
                userInsert(user);

                
            }
        }
        private async void userInsert(User u)
        {
            DataBase db = new DataBase();
            SetResponse response = await db.Cli.SetAsync($"Users/{u.Id}", u);

            if (response != null)
            {
                MessageBox.Show("Usuario insertado en la BD");
                this.Close();
            }

        }
    }
}
