using FireSharp.Response;
using System.Text;
using System.Windows;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Navigation;
using System.Windows.Shapes;

namespace Tema5Prueba1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        public MainWindow()
        {
            InitializeComponent();
        }

        private async void tb_login_Click(object sender, RoutedEventArgs e)
        {
            if (!String.IsNullOrEmpty(tb_user.Text) || !String.IsNullOrEmpty(pb_pass.Password))
            {
                var u =await getUser(tb_user.Text);
                if (u != null)
                {
                    if (u.Password == pb_pass.Password)
                    {
                        MessageBox.Show("Usuario logado");
                    }
                    else
                    {
                        MessageBox.Show("Contraseña incorrecta");
                    }
                }
                else
                {
                    MessageBox.Show("No existe el usuario");
                }
            }
        }

        private void tb_register_Click(object sender, RoutedEventArgs e)
        {
            VentanaRegisto regWin = new VentanaRegisto();
            regWin.Show();
        }

        private static async Task<User> getUser(String userName)
        {
            DataBase db = new DataBase();

            FirebaseResponse response = await db.Cli.GetAsync("Users");
            if (response != null)
            {
                Dictionary<string, User> userDic = response.ResultAs<Dictionary<string, User>>();
                return userDic.Values.FirstOrDefault(u => u.Name == userName);
            }
            return null;
        }
    }
}