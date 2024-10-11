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
          
        }

        
        public void escribirEmpleado()
        {
           Empleado e = new Empleado();
            int numero;
            if (!int.TryParse(tb_numEmpleado.Text, out numero))
            {

            }

            e.Nombre = tb_nombre.Text;
            e.Codigo = tb_codigo.Text;
            e.FechaAlta = dp_alta.Text;
            e.Antiguedad =int.Parse(tb_antiguedad.Text);
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
            e.Salario = float.Parse(tb_salario.Text);
            e.Percentil = float.Parse(tb_percentil.Text);  
            e.Comentarios = tb_comentario.Text;
            e.Premios = tb_premio.Text;
        }
        
        
        public int calcularNumero()
        {
            if (File.Exists("altaEmpleados.txt") == false)
            {
                numEmpleado = 0;
            }
            else
            {
                StreamReader sr = new StreamReader("altaEmpleados.txt");
                string linea = sr.ReadLine();
                while(linea != null)
                {
                    if()

                    linea = sr.ReadLine();
                }
            }

            return numEmpleado;
        }
    }
    
}
