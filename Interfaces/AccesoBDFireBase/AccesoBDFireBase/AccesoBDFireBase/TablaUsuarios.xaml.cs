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

        List<Usuario> listUsuarios;
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

                //OBTENEMOS LOS DATOS DE LA BASE DE DATOS EN FORMATO DICCIONARIO
                FirebaseResponse response = await client.GetAsync("usuario");

                //INSTANCIAMOS EL DICCIONARIO
                Dictionary<string, Usuario> usuarios = response.ResultAs<Dictionary<string, Usuario>>();

                //COMBERTIMOS EL DICCIONARIO A LA LISTA
                listUsuarios = new List<Usuario>(usuarios.Values);

                //AÑADIMOS LA LISTA AL DATAGRID NO PODEMOS AÑADIR UN DICCIONARIO
                dataGrid_usuario.ItemsSource = listUsuarios;
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Ocurrio un error: {ex.Message}");
            }
        }



        private async void editorTabla(object sender, DataGridCellEditEndingEventArgs e)
        {
            try
            {
                // OBTENEMOS EL USUARIO QUE FUE EDITADO
                Usuario usuarioEditado = e.Row.Item as Usuario;

                //ENCONTRAMOS la clave del usuario(por ejemplo se puede utilizar el correo como identificador unico)
                var usuarioOriginal = listUsuarios.FirstOrDefault(u => u.Nombre == usuarioEditado.Nombre);

                if (usuarioOriginal != null)
                {
                    //ACTUALIZAMO LOS DATOS DE LA BASE DE DATO EN FIREBASE
                    FirebaseResponse response = await client.UpdateAsync($"usuario/{usuarioEditado.Nombre}", usuarioEditado);
                    if (response.StatusCode == System.Net.HttpStatusCode.OK)
                    {
                        MessageBox.Show("Datos aactualizados correctamente en Firebase");
                    }
                    else
                    {
                        MessageBox.Show("Hubo un error al actualizar los datos");
                    }
                }
            }
            catch (Exception ex)
            {
                {
                    MessageBox.Show($"Hubo un error{ex.Message}");
                }
            }
        }
    }
}
