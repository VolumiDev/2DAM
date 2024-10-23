using FireSharp;
using FireSharp.Config;
using FireSharp.Interfaces;
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

namespace AccesoBDFireBase
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        //CONFIGURACION DE LA BASE DE DATOS
        IFirebaseConfig config = new FirebaseConfig
        {
            //CLAVE SECRETA DE TU PROYECTO
            AuthSecret = "Yqz0qaZWSLxTCe2uiqGat0m11LXvHxUBzZuxTNd6",
            //URL DE SU BASE DE DATOS
            BasePath = "https://ejemploclase-15d5a-default-rtdb.europe-west1.firebasedatabase.app/"
        };

        //CREAMOS EL CLIENTE QUE USAREMOS.
        FirebaseClient client;



        public MainWindow()
        {
            InitializeComponent();
            //INICIALIZAMOS LOS COMPONENTESS

            client = new FireSharp.FirebaseClient(config);
            if(client == null)
            {
                MessageBox.Show("Error de conexion");
            }
            else
            {
                MessageBox.Show("Conectado a la bsae de datos");
            }
        }

        private async void Button_Click(object sender, RoutedEventArgs e)
        {
            //VERIFICAMOS VACIOS
            if (String.IsNullOrEmpty(tb_correo.Text) || String.IsNullOrEmpty(tb_nombre.Text) || String.IsNullOrEmpty(cb_rol.Text) || String.IsNullOrEmpty(tb_telefono.Text))
            {
                MessageBox.Show("Rellena todos los campos");
            }
            else
            {
                Usuario user = new Usuario(tb_nombre.Text, tb_telefono.Text, tb_correo.Text, cb_rol.Text);

                //ENVIAMOS LOS DATOS A FIREBASE 
                SetResponse response = await client.SetAsync($"usuario/{user.Nombre}", user);
                Usuario result = response.ResultAs<Usuario>();
                MessageBox.Show($"Usuario {result.Nombre} registrado exitosamente");

                //VACIAMOS LOS CAMPOS DE RELLENAR
                tb_correo.Text = "";
                tb_telefono.Text = "";
                tb_nombre.Text = "";
            }
        }

        private void tabla(object sender, RoutedEventArgs e)
        {
            TablaUsuarios tuser = new TablaUsuarios();
            tuser.Show();
        }
    }
}