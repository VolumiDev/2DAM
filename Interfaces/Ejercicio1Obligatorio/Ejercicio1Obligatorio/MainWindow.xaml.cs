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

namespace Ejercicio1Obligatorio
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

        private void nuevaAlta(object sender, RoutedEventArgs e)
        {
            Alta alta = new Alta();
            alta.calcularNumero();
            alta.Show();

        }

        private void nuevaConsulta(object sender, RoutedEventArgs e)
        {
            ConsultaDatos consulta = new ConsultaDatos();
            consulta.Show();
        }

        private void nuevaActulizar(object sender, RoutedEventArgs e)
        {
            Actualizar actualizar = new Actualizar();
            actualizar.Show();
        }

        private void cerrarApp(object sender, RoutedEventArgs e)
        {
            MessageBoxResult confirmacion = MessageBox.Show("¿Esta seguro que desea salir de la app?", "Confirmación", MessageBoxButton.YesNo, MessageBoxImage.Question);
            if(confirmacion == MessageBoxResult.Yes)
            {
                Application.Current.Shutdown();
            }
        }

        private void nuevaAcercaDe(object sender, RoutedEventArgs e)
        {
            AcercaDe acercaDe = new AcercaDe();
            acercaDe.Show();
        }

        private void nuevaAyuda(object sender, RoutedEventArgs e)
        {
            Ayuda help = new Ayuda();
            help.Show();
        }
    }
}