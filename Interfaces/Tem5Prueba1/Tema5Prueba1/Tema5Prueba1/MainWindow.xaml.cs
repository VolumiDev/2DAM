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
            //COMPROBAMOS QUE LOS CAMPOS NO ESTEN VACIOS
            if (!String.IsNullOrEmpty(tb_user.Text) || !String.IsNullOrEmpty(pb_pass.Password))
            {
                //RECOGEMOS EL USUARIO QUE COINCIDE CON EL NOMBRE RECOGIDO EN EL INPUT
                var u =await getUser(tb_user.Text);
                //COMPROBAMOS QUE NO SEA NULL INDICANDO QUE EL USUARIO EXISTE, SI NO MANDAMOS EL MENSAJE ADECUADO AL USUARIO
                if (u != null)
                {
                    //VALIDAMOS QUE LA CONTRSEÑA INTRODUCIDA ES LA MISMA QUE TIENE ALMACENADA EL USUARIO EN LA BASE DE DATOS
                    if (u.Password == pb_pass.Password)
                    {
                        //SI ES CORRECTO INICIAMOS AL VENTANA DE CONTROL DE MENSAJES
                        MessageWindow messageWindow = new(u);
                        messageWindow.Show();
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


        //EN EL BOTON DE REGISTRO LANZAMOS LA NUEVA VENTANA DE REGISTRO
        private void tb_register_Click(object sender, RoutedEventArgs e)
        {
            VentanaRegisto regWin = new VentanaRegisto();
            regWin.Show();
        }

        //METODO QUE RECOGE DE MANERA ASINCRONA LOS USUARIOS QUE ESTAN REGISTRADOS RETORNA EL USUARIO QUE COINCIDE CON 
        //EL NOMBRE QUE SE LE PASA COMO PARAMETRO A LA FUNCION
        private static async Task<User> getUser(String userName)
        {
            DataBase db = new DataBase();
            //RECOGEMOS LA RESPUESTA CON TODOS LOS USUARIOS DE LA BASE DE DATOS
            FirebaseResponse response = await db.Cli.GetAsync("Users");
            //VALIDAMOS QUE NO SEA NULA
            if (response != null)
            {
                //ALMACENAMOS LOS DATOS EN UN DICCIONARIO Y BUSCAMOS EL USUARIO CUYO NOMBRE DE USUARIO LE HEMOS PASADO COMO PARAMETRO
                Dictionary<string, User> userDic = response.ResultAs<Dictionary<string, User>>();
                return userDic.Values.FirstOrDefault(u => u.Name == userName);
            }
            return null;
        }
    }
}