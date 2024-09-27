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

namespace AñadirCursoClases
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        private List<Curso> cursos;
        private List<Alumno> alumnos;

        private List<UIElement> inputs;
        public MainWindow()
        {
            InitializeComponent();
            cursos = new List<Curso>(); 
            alumnos = new List<Alumno>();
            inputs = new List<UIElement>();

            inputs.Add(txt_nombrecurso);
            inputs.Add(rb_manana);
            inputs.Add(rb_tarde);
            inputs.Add(cb_categoriacurso);
            inputs.Add(cb_modalidad);
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            if(txt_nombre.Text == "")
            {
                MessageBox.Show("Complete los campo");
            }
            else
            {
                Alumno alum = new Alumno(txt_nombre.Text);
                lb_alumnos.Items.Add(alum.Nombre);
                txt_nombre.Text = "";
            }
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            bool flagtxt = false;
            bool flagrb = false; 
            bool flagcb = false;

            if(txt_nombrecurso.Text == "")
            {
                flagtxt = true;
                MessageBox.Show("Introduce el nombre");
            }
            if(rb_manana.IsChecked == false && rb_tarde.IsChecked == false)
            {
                flagrb = true;
                MessageBox.Show("Introduce el turno");
            }
            if(cb_categoriacurso.SelectedIndex == -1 || cb_modalidad.SelectedIndex == -1)
            {
                flagcb = true;
                MessageBox.Show("Introduce la categoria");
            }
            if (flagtxt == false && flagrb == false && flagcb == false)
            {
                String curso = txt_nombrecurso.Text.ToString();
                RadioButton rbDeMañana = rb_manana;
                String cat = ((ComboBoxItem)cb_categoriacurso.SelectedItem).Content.ToString();
                String mod = ((ComboBoxItem)cb_modalidad.SelectedItem).Content.ToString();
                Curso c = new Curso(curso, rbDeMañana, cat, mod, alumnos, cursos);


                txt_nombre.Text = "";
                rb_manana.IsChecked = false;
                rb_tarde.IsChecked = false;
                cb_categoriacurso.SelectedIndex = -1;
                cb_modalidad.SelectedIndex = -1;

                String infoCursoFormat = $"Codigo: {c.Codigo}, Titulo: {c.Titulo}, Turno: {c.Turno}, Catergoria: {c.Categoria}, Modalidad: {c.Modalidad}";

                lb_cursos.Items.Add(infoCursoFormat);

            }
        }

        private void lb_cursos_SelectionChanged(object sender, SelectionChangedEventArgs e)
        {
            //se visualice un boton que esta en oculto
            int index = lb_cursos.SelectedIndex;
            cursos[index].Alumnos = lb_alumnos.Items;
            btn_hidden.IsEnabled=false;
            //cursos[index].AñadirLista(alumnos);
        }
    }
}