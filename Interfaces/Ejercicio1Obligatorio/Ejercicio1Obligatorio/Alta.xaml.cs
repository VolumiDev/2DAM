using System;
using System.Collections.Generic;
using System.Configuration;
using System.IO;
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

namespace Ejercicio1Obligatorio
{
    /// <summary>
    /// Lógica de interacción para Alta.xaml
    /// </summary>
    public partial class Alta : Window
    {
        
        public Alta()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            escribirEmpleado();
        }

        
        public void escribirEmpleado()
        {
            //VALIDAMOS QUE LOS CAMPOS NUMERICOS SEAN VALIDO
            if (validarVacios() == false)
            {
                Empleado e = new Empleado();

                int numeroTemp, antigTemp;
                double salarioTemp, percentilTemp;

                bool numeroValido = int.TryParse(tb_numEmpleado.Text, out numeroTemp);
                bool salarioValido = double.TryParse(tb_salario.Text, out salarioTemp);
                bool antigValida = int.TryParse(tb_antiguedad.Text, out antigTemp);
                bool percentilValido = double.TryParse(tb_percentil.Text, out percentilTemp);   

                if (!numeroValido || !salarioValido || !antigValida)
                {
                    if (!numeroValido)
                    {
                        MessageBox.Show("Inserta un valor que sea valido");
                        tb_numEmpleado.Background = Brushes.Red;
                    }
                    if (!salarioValido)
                    {
                        MessageBox.Show("Inserta un valor que sea valido");
                        tb_salario.Background = Brushes.Red;
                    }
                    if (!antigValida)
                    {
                        MessageBox.Show("Inserta un valor que sea valido");
                        tb_antiguedad.Background = Brushes.Red;
                    }
                    if (!percentilValido)
                    {
                        MessageBox.Show("Inserta un valor que sea valido");
                        tb_percentil.Background = Brushes.Red;
                    }
                    return;
                }
                e.Antiguedad = antigTemp;
                e.Numero= numeroTemp;
                e.Salario= salarioTemp;
                e.Nombre = tb_nombre.Text;
                e.Codigo = tb_codigo.Text;
                e.FechaAlta = dp_alta.Text;
                if (rb_si.IsChecked == true)
                {
                    e.TiempoCompleto = true;
                }
                else
                {
                    e.TiempoCompleto = false;
                }
                e.Especialidad = tb_especialidad.Text;
                e.Titulacion = tb_categoria.Text;
                e.CatLaboral = tb_categoria.Text;
                e.Percentil = percentilTemp;
                e.Comentarios = tb_comentario.Text;
                e.Premios = tb_premio.Text;
                e.Departamento = cb_departamento.Text;
                e.Grado = cb_grado.Text;

                e.escribirEmpleado("altaEmpleados.txt");
                vaciarCampos();
                MessageBox.Show("Añadido al fichero");
                calcularNumero();

            }
            else
            {
                MessageBox.Show("No pueden quedar campo vacios");
            }
            
        }


        public void calcularNumero()
        {
            int numEmpleado = 1;
            if (File.Exists("altaEmpleados.txt"))
            {


                using (StreamReader sr = new StreamReader("altaEmpleados.txt", true))
                {
                    string linea = sr.ReadLine();
                    while (linea != null)
                    {
                        if (linea.Contains("NUMERO"))
                        {
                            numEmpleado = int.Parse(linea.Split(": ")[1]);
                            numEmpleado++;
                        }
                        linea = sr.ReadLine();
                    }
                }
            }
            tb_numEmpleado.Text = numEmpleado.ToString();   
        }

        public bool validarVacios()
        {
            bool flag = false;

            if (String.IsNullOrWhiteSpace(tb_numEmpleado.Text) || String.IsNullOrWhiteSpace(tb_nombre.Text) || String.IsNullOrWhiteSpace(tb_codigo.Text) || String.IsNullOrWhiteSpace(dp_alta.Text) || String.IsNullOrWhiteSpace(tb_antiguedad.Text) ||
                String.IsNullOrWhiteSpace(tb_especialidad.Text) || String.IsNullOrWhiteSpace(tb_titulacion.Text) || String.IsNullOrWhiteSpace(tb_categoria.Text) || String.IsNullOrWhiteSpace(tb_salario.Text) || String.IsNullOrWhiteSpace(tb_percentil.Text) || 
                String.IsNullOrWhiteSpace(cb_departamento.Text) || String.IsNullOrWhiteSpace(cb_grado.Text) || String.IsNullOrWhiteSpace(tb_codigo.Text))
            {
                flag = true;    
            }
            if (!flag && !(rb_si.IsChecked ?? false) && !(rb_no.IsChecked ?? false))
            {
                flag = true;
            }
            return flag;
        }

        private void focus(object sender, RoutedEventArgs e)
        {
            TextBox elemento = (TextBox)sender;
            elemento.Text = "";
        }

        private void vaciarCampos()
        {
            tb_numEmpleado.Text = String.Empty;
            tb_antiguedad.Text = String.Empty;
            tb_nombre.Text = String.Empty;
            tb_codigo.Text = String.Empty;
            dp_alta.Text = String.Empty;
            tb_especialidad.Text = String.Empty;
            tb_titulacion.Text = String.Empty;
            tb_categoria.Text = String.Empty;
            tb_salario.Text = String.Empty;
            tb_percentil.Text = String.Empty;
            tb_comentario.Text = String.Empty;
            tb_premio.Text = String.Empty;
            cb_departamento.Text = String.Empty;
            cb_grado.Text = String.Empty;

        }
    }
    
}
