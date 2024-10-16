using System;
using System.Collections.Generic;
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
    /// Lógica de interacción para ConsultaDatos.xaml
    /// </summary>
    public partial class ConsultaDatos : Window
    {

        private List<TextBox> tb_list = new List<TextBox>();
        public ConsultaDatos()
        {
            InitializeComponent();
            this.Loaded += MainWindow_Loaded;
        }


        private void MainWindow_Loaded(object sender, RoutedEventArgs e)
        {
            List<TextBox> listaTextBoxes = Obtener_textBoxes(this);

            // Ahora puedes modificar las propiedades de los TextBox
            foreach (TextBox tb in listaTextBoxes)
            {
                tb.IsReadOnly = true; // Ejemplo: hacerlos de solo lectura
            }
            tb_id.IsReadOnly = false;
        }


        //METODO QUE USAMOS PARA RECOGER DE UNA VENTANA TODOS LOS ELEMENTOS TEXTBOX Y LOS AÑADIMOS A UNA LISTA PARA PODER
        //RECORRERLA Y APLICARLE LAS PROPIEDADES QUE NECESITEMOS A TODOS DE GOLPE.

        private List<TextBox> Obtener_textBoxes(DependencyObject parent)
        {
            List<TextBox> textBoxes = new List<TextBox>();
            int numeroHijos = VisualTreeHelper.GetChildrenCount(parent);

            for (int i = 0; i < numeroHijos; i++)
            {
                DependencyObject hijo = VisualTreeHelper.GetChild(parent, i);
                if(hijo is TextBox tb)
                {
                    textBoxes.Add(tb);
                }
                else
                {
                    textBoxes.AddRange(Obtener_textBoxes(hijo));
                }
            }
            return textBoxes;
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (String.IsNullOrWhiteSpace(tb_id.Text))
            {
                MessageBox.Show("La id no puede esta vacia");
            }
            else
            {
                buscar_empleado(tb_id.Text);
            }
        }

        private void buscar_empleado(String id)
        {
            using (StreamReader sr = new StreamReader("altaEmpleados.txt", true))
            {
                bool flag = true;
                string linea = sr.ReadLine();
                while (linea != null)
                {   
                    if (linea.Contains("NUMERO")){
                        String id_temp = linea.Split(": ")[1];
                MessageBox.Show("entra");
                        if (id_temp.Equals(id))
                        {
                            flag = false;
                            tb_id.Text = id_temp;
                            tb_nombre.Text = sr.ReadLine().Split(": ")[1];
                            tb_codigo.Text = sr.ReadLine().Split(": ")[1];
                            tb_alta.Text = sr.ReadLine().Split(": ")[1];
                            tb_antiguedad.Text = sr.ReadLine().Split(": ")[1];
                            if (sr.ReadLine().Split(": ")[1].Equals("True"))
                            {
                                tb_tiempo.Text = "Si";
                            }
                            else
                            {
                                tb_tiempo.Text = "No";
                            }
                            tb_especialidad.Text = sr.ReadLine().Split(": ")[1];
                            tb_titulacion.Text = sr.ReadLine().Split(": ")[1];
                            tb_categoria.Text = sr.ReadLine().Split(": ")[1];
                            tb_salario.Text = sr.ReadLine().Split(": ")[1];
                            tb_percentil.Text = sr.ReadLine().Split(": ")[1];
                            tb_departamento.Text = sr.ReadLine().Split(": ")[1];
                            tb_grado.Text = sr.ReadLine().Split(": ")[1];
                            tb_comentario.Text = sr.ReadLine().Split(": ")[1];
                            tb_premio.Text = sr.ReadLine().Split(": ")[1];


                            //Empleado e = new Empleado();
                            //e.Numero = int.Parse(id);
                            //e.Nombre = sr.ReadLine().Split(": ")[1];
                            //e.Codigo = sr.ReadLine().Split(": ")[1];
                            //e.FechaAlta = sr.ReadLine().Split(": ")[1];
                            //e.Antiguedad = int.Parse(sr.ReadLine().Split(": ")[1]);
                            //if(sr.ReadLine().Split(": ")[1].Equals("True"))
                            //{
                            //    e.TiempoCompleto = true;
                            //}
                            //else
                            //{
                            //    e.TiempoCompleto = false;
                            //}
                            //e.Especialidad = sr.ReadLine().Split(": ")[1];
                            //e.Titulacion = sr.ReadLine().Split(": ")[1];
                            //e.CatLaboral = sr.ReadLine().Split(": ")[1];
                            //e.Salario =Double.Parse(sr.ReadLine().Split(": ")[1]);
                            //e.Percentil = Double.Parse(sr.ReadLine().Split(": ")[1]);
                            //e.Departamento = sr.ReadLine().Split(": ")[1];
                            //e.Grado = sr.ReadLine().Split(": ")[1];
                            //e.Comentarios = sr.ReadLine().Split(": ")[1];
                            //e.Premios = sr.ReadLine().Split(": ")[1];
                        }
                    }
                    else
                    {
                        linea = sr.ReadLine();
                    }
                }
                if (flag)
                {
                    MessageBox.Show("El codigo de empleado no existe");
                }
            }
        }

        private void focus(object sender, RoutedEventArgs e)
        {
            TextBox elemento = (TextBox)sender;
            elemento.Text = "";
        }
    }
}
