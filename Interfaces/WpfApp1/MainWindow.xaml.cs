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

namespace WpfApp1
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        float n1 = 0;
        float n2 = 0;
        
        public MainWindow()
        {
            InitializeComponent();

        }

        private void btn1_Click(object sender, RoutedEventArgs e)
        {
            String name;
            name = tb_text1.Text;
            cb_comb1.Items.Add(name);
            tb_text1.Text = "";
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            Button btn = (Button)sender;
            string operation =  btn.Content.ToString();
            n1 = float.Parse(tb_num1.Text);
            n2 = float.Parse(tb_num2.Text);

            switch(operation)
            {
                case "+": tb_result.Text = (n1 + n2).ToString();
                    break;
                case "-":
                    tb_result.Text = (n1 - n2).ToString();
                    break;
                case "*":
                    tb_result.Text = (n1 * n2).ToString();
                    break;
                case "/":
                    tb_result.Text = (n1 / n2).ToString();
                    break;
            }
        }

        private void Button_Click_1(object sender, RoutedEventArgs e)
        {
            tb_num1.Text = "";
            tb_num2.Text = "";
            tb_result.Text = "";
        }

        private void Button_Click_2(object sender, RoutedEventArgs e)
        {
            Application.Current.Shutdown();
        }

        private void Button_Click_3(object sender, RoutedEventArgs e)
        {
            var w = new Window1();
            w.Owner = this;
            w.Show();
        }
    }
}