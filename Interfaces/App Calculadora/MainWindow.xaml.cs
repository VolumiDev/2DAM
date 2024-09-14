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

namespace Calcauladora
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private float n1 = 0;
        private float n2 = 0;
        private string operacion = "";
        private bool nuevoNumero = false;

        public MainWindow()
        {
            InitializeComponent();

        }

        private void btn_Click(object sender, RoutedEventArgs e)
        {
            var boton = sender  as Button;
            if (boton != null)
            {
                if (texto.Text == "0" || nuevoNumero)
                {
                    texto.Text = boton.Content.ToString();
                    nuevoNumero = false;
                }else
                {
                    texto.Text += boton.Content.ToString();
                }
            }

        }

        private void limpiar_Click(object sender, RoutedEventArgs e)
        {
            texto.Text = "0";
            n1 = 0;
            n2 = 0;
            operacion = "";
            nuevoNumero = false;
    }

        private void btn_Operacion_click(object sender, RoutedEventArgs e)
        {
            var boton = sender as Button;
            if (boton != null) 
            { 
                n1 = float.Parse(texto.Text);
                operacion = boton.Content.ToString();
                nuevoNumero = true;
            }
        }

        private void btnIgual_Click(object sender, RoutedEventArgs e)
        {
            n2 = float.Parse(texto.Text);
            float resultado = 0;

            switch (operacion)
            {
                case "+":
                    resultado = n1 + n2; 
                    break;
                case "-":
                    resultado = n1 - n2;
                    break;
                case "*":
                    resultado = n1 * n2;
                    break;
                case "/":
                    if (n2 == 0)
                    {
                        MessageBox.Show("No se puede dividir entre cero");
                    }else
                    {
                        resultado = n1 / n2;
                    }
                    break;
            }

            texto.Text = resultado.ToString();
            nuevoNumero = true;
        }
    }
}