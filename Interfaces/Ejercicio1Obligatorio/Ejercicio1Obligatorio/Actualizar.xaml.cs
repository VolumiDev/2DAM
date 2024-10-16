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
    /// Lógica de interacción para Actualizar.xaml
    /// </summary>
    public partial class Actualizar : Window
    {
        public Actualizar()
        {
            InitializeComponent();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if (sender.Equals(btn_buscar))
            {
            buscar_empleado(tb_id.Text);
            }
            else if(sender.Equals(btn_guradar))
            { 
                if(validarVacios() == false)
                {
                    modificarFichero(tb_id.Text);
                    vaciarCampos();
                }
                else
                {
                    MessageBox.Show("No puede dejar campos vacios");
                }

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
                    if (linea.Contains("NUMERO"))
                    {
                        String id_temp = linea.Split(": ")[1];
                        if (id_temp.Equals(id))
                        {
                            flag = false;
                            tb_id.Text = id_temp;
                            tb_nombre.Text = sr.ReadLine().Split(": ")[1];
                            tb_codigo.Text = sr.ReadLine().Split(": ")[1];
                            dp_alta.Text = sr.ReadLine().Split(": ")[1];
                            tb_antiguedad.Text = sr.ReadLine().Split(": ")[1];
                            if (sr.ReadLine().Split(": ")[1].Equals("True"))
                            {
                                rb_si.IsChecked = true;
                            }
                            else
                            {
                                rb_si.IsChecked = true;
                            }
                            tb_especialidad.Text = sr.ReadLine().Split(": ")[1];
                            tb_titulacion.Text = sr.ReadLine().Split(": ")[1];
                            tb_categoria.Text = sr.ReadLine().Split(": ")[1];
                            tb_salario.Text = sr.ReadLine().Split(": ")[1];
                            tb_percentil.Text = sr.ReadLine().Split(": ")[1];
                            
                            cb_departamento.Text = sr.ReadLine().Split(": ")[1];
                            cb_grado.Text = sr.ReadLine().Split(": ")[1];

                            //tb_departamento.Text = sr.ReadLine().Split(": ")[1];
                            //tb_grado.Text = sr.ReadLine().Split(": ")[1];
                            tb_comentario.Text = sr.ReadLine().Split(": ")[1];
                            tb_premio.Text = sr.ReadLine().Split(": ")[1];
                        }
                    }
                    linea = sr.ReadLine();

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

        private void modificarFichero(String id)
        {
            using (StreamReader sr = new StreamReader("altaEmpleados.txt", true))
            {
                String linea = sr.ReadLine();
                while (linea != null)
                {
                    Empleado e = new Empleado();
                    e.Numero = int.Parse(linea.Split(": ")[1]);
                    linea = sr.ReadLine();
                    e.Nombre = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Codigo = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.FechaAlta = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Antiguedad = int.Parse(linea.Split(": ")[1]);
                    linea = sr.ReadLine();
                    if (linea.Split(": ")[1].Equals("Si")) {
                        e.TiempoCompleto = true;
                    }
                    else
                    {
                        e.TiempoCompleto = false;
                    }
                    linea = sr.ReadLine();
                    e.Especialidad = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Titulacion = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.CatLaboral = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Salario = double.Parse(linea.Split(": ")[1]);
                    linea = sr.ReadLine();
                    e.Percentil=double.Parse(linea.Split(": ")[1]);
                    linea = sr.ReadLine();
                    e.Departamento = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Grado = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Comentarios = linea.Split(": ")[1];
                    linea = sr.ReadLine();
                    e.Premios = linea.Split(": ")[1];
                    linea = sr.ReadLine();

                    if(e.Numero == int.Parse(id))
                    {
                        escribirTemporal("NUMERO: " + tb_id.Text);
                        escribirTemporal("NOMBRE: " + tb_nombre.Text);
                        escribirTemporal("CODIGO: " + tb_codigo.Text);
                        escribirTemporal("FECHA ALTA: " + dp_alta.Text);
                        escribirTemporal("ANTIGUEDAD: " + tb_antiguedad.Text);
                        if (rb_si.IsChecked == true)
                        {
                            escribirTemporal("TIEMPO COMPLETO: " + "Si");
                        }
                        else
                        {
                            escribirTemporal("TIEMPO COMPLETO: " + "No");
                        }
                        escribirTemporal("ESPECIALIDAD: " + tb_especialidad.Text);
                        escribirTemporal("TITULACION: " + tb_titulacion.Text);
                        escribirTemporal("CATEGORIA LABORAL: " + tb_categoria.Text);
                        escribirTemporal("SALARIO: " + tb_salario.Text);
                        escribirTemporal("%: " + tb_percentil.Text);
                        escribirTemporal("DEPARTAMENTO: " + cb_departamento.Text);
                        escribirTemporal("GRADO: " + cb_grado.Text);
                        escribirTemporal("COMENTARIOS: " + tb_comentario.Text);
                        escribirTemporal("PREMIOS: " + tb_premio.Text);
                        escribirTemporal("---------------------------------------");
                    }
                    else
                    {
                        e.escribirEmpleado("altaEmpleadosTemp.txt");
                    }

                    linea = sr.ReadLine();
                }
            }
            File.Replace("altaEmpleadosTemp.txt", "altaEmpleados.txt", "altaEmpleadosBackUp.txt");
            MessageBox.Show("Fichero modificado");
        }

        private void escribirTemporal(String cad)
        {
            using (StreamWriter sw = new StreamWriter("altaEmpleadosTemp.txt", true))
            {
                sw.WriteLine(cad);
            }
        }


        private void vaciarCampos()
        {
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
            tb_id.Text = String.Empty;

        }


        public bool validarVacios()
        {
            bool flag = false;

            if (String.IsNullOrWhiteSpace(tb_id.Text) || String.IsNullOrWhiteSpace(tb_nombre.Text) || String.IsNullOrWhiteSpace(tb_codigo.Text) || String.IsNullOrWhiteSpace(dp_alta.Text) || String.IsNullOrWhiteSpace(tb_antiguedad.Text) ||
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
    }

    
}
