using FireSharp;
using FireSharp.Config;
using FireSharp.Interfaces;
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

namespace AccesoBDFireBase
{
    /// <summary>
    /// Lógica de interacción para TablaUsuarios.xaml
    /// </summary>
    public partial class TablaUsuarios : Window
    {
        IFirebaseConfig config = new FirebaseConfig
        {
            //CLAVE SECRETA DE TU PROYECTO
            AuthSecret = "Yqz0qaZWSLxTCe2uiqGat0m11LXvHxUBzZuxTNd6",
            //URL DE SU BASE DE DATOS
            BasePath = "https://ejemploclase-15d5a-default-rtdb.europe-west1.firebasedatabase.app/"
        };

        FirebaseClient client;

        
public TablaUsuarios()
        {
            InitializeComponent();
            client = new FireSharp.FirebaseClient(config);
            if (client == null)
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
            try
            {
                //obtenemos los datos de la base de dato en formato diccionario
                FirebaseResponse response = await client.GetAsync("usuario");
                //instanciamos el diccionario
                Dictionary<string, Usuario> usuarios = response.ResultAs<Dictionary<string, Usuario>>();
                //combertimos el diccionario a lista 
                List<Usuario> listUsuario = new List<Usuario>(usuarios.Values);
                //añadimos la lista al dataGrid
                dataGrid_usuario.ItemsSource = listUsuario;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Ocurrio un error: {ex.Message}");
            }
        }

        

        private void editorTabla(object sender, DataGridCellEditEndingEventArgs e)
        {

        }
    }
}
