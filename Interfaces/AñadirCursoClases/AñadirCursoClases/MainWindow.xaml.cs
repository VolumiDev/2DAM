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

        public MainWindow()
        {
            InitializeComponent();
            cursos = new List<Curso>(); 
            alumnos = new List<Alumno>();
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
            }
        }
    }
}