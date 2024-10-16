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
    }
}