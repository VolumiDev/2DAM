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

        private void tb_login_Click(object sender, RoutedEventArgs e)
        {

        }

        private void tb_register_Click(object sender, RoutedEventArgs e)
        {
            VentanaRegisto regWin = new VentanaRegisto();
            regWin.Show();
        }
    }
}