using Microsoft.Win32;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.IO;
using System.Windows.Controls;
using System.Windows.Data;
using System.Windows.Documents;
using System.Windows.Input;
using System.Windows.Media;
using System.Windows.Media.Imaging;
using System.Windows.Shapes;

namespace Tema5Prueba1
{
    /// <summary>
    /// Lógica de interacción para MessageWindow.xaml
    /// </summary>
    public partial class MessageWindow : Window
    {
        //ALMACENAMOS EL USUARIO QUE ESTA LOGADO EN UN ATRIBUTO PARA OPERAR CON EL
        User user;
        public MessageWindow(User user)
        {
            InitializeComponent();
            this.user = user;
        }

        private void BtnSend_Click(object sender, RoutedEventArgs e)
        {
            if (String.IsNullOrEmpty(inputMessage.Text))
            {
                MessageBox.Show("No pueden quedar campos vacios");
            }
            else
            {
                Mensajes mess = new(user.Name, inputMessage.Text, DateTime.Today);
                mess.SetMessageDB(mess);
                limpiarCampos();

            }
        }

        //LIMPIAMOS LOS CAMPOS
        private void limpiarCampos()
        {
            inputMessage.Text = "";
            inputDate.Text = "";

        }

        //VALIDAMOS QUE LA FECHA INTRODUCIDA NO SEA NULA O TENGA UN DIA SUPERIOR AL ACTUAL
        private bool ValidateDate()
        {
            DateTime? date = inputDate.SelectedDate;
            DateTime today = DateTime.Today;
            if (date > today || date == null)
            {
                MessageBox.Show("Selecciona una fecha valida");
                return false;
            }
            return true;
        }

        //RECIBIMOS UNA LISTA CON LOS MENSAJES FILTRADOS Y LOS MOSTRAMOS COMO UNA CADENA DE TEXTO CON EL FORMATO DESEADO
        private async void ShowFilteredMessages(Task<List<Mensajes>> filteredMess)
        {
            List<Mensajes> list = await filteredMess;
            showMessages.Text = "";
            foreach (var item in list)
            {
                showMessages.Text += $"Usuario: {item.NameUser}, Fecha: {item.Date}, Mensaje: {item.Message}\n";
            }

        }

       
        private void btnSearch_Click(object sender, RoutedEventArgs e)
        {
            //VALIDAMOS SI ESTA SELECCIONADO LA OPCION DE MOSTRAR MENSAJES DE TODOS LOS USUARIOS
            if (cbGetMessaage != null && cbGetMessaage.IsChecked == true)
            {
                //MOSTRAMOS TODOS LOS MENSAJES 
                showAllMessAndUSers();
                //RELLEMANOS EL COMBOBOX CON LOS USUARIOS QUE ESCRIBIERON
                fillUserCombobox();
            }
            else
            {
                //SI NO TENEMEOS SELECCIONA LA OPCION DE MOSTRAR TODOS LO MENSAJES VALIDAMOS QUE LA FECHA QUE NOS ELIGE SEA CORRECTA
                Mensajes m = new();
                if (ValidateDate())
                {
                    //RECOGEMOS TODOS LOS MENSAJES QUE COINCIDEN CON NUESTRO CRITERIO DE FILTRADO Y LOS MOSTRAMOS
                    var filteredMess = m.UserandDateFilteredMess(user.Name, inputDate.SelectedDate);
                    ShowFilteredMessages(filteredMess);
                }
            }
            //OPCION QUE COMPRUEBA SI TENEMOS ACTIVADA LA OPCION DE GUARDAR EL FICHERO
            if (cbSave != null && cbSave.IsChecked == true)
            {
                SaveMessTxt();
            }
        }

        //GUARDAMOS EN UN FICHERO DE TEXTO EL CONTENIDO QUE TENEMOS EN LA CAJA MULTILINEA DE MOSTRAR MENSAJES
        private void SaveMessTxt()
        {
            SaveFileDialog saveFileDialog = new SaveFileDialog();
            saveFileDialog.Filter = "Text files (*.txt) | *.txt | All Files (*.*)|*.*";
            saveFileDialog.Title = "Guardar Mensajes el archivo de texto";

            if (saveFileDialog.ShowDialog() == true)
            {
                String path = saveFileDialog.FileName;
                File.WriteAllText(path, showMessages.Text);
                MessageBox.Show("Fichero Guradado.");
            }
        }

        //MOSTRAMOS TODOS LOS MENSAJES DE TODOS LOS USUARIOS
        private async void showAllMessAndUSers()
        {
            showMessages.Text = "";
            Mensajes m = new();
            Dictionary<string, Mensajes> allMessDic = await m.GetMesseges();
            List<Mensajes> list = new List<Mensajes>(allMessDic.Values);
            foreach (var mess in list)
            {
                showMessages.Text += $"Usuario: {mess.NameUser}, Fecha: {mess.Date}, Mensaje: {mess.Message}\n";
            }
        }

        //RELLENAMOS EL COMBO BOX CON LOS USUARIOS QUE ESCRIBIERON
        private async void fillUserCombobox()
        {
            Mensajes m = new();
            User u = new();
            //RECOGEMOS TODOS LOS MENSAJES
            Dictionary<string, Mensajes> allMessDic = await m.GetMesseges();
            List<Mensajes> listMessAndUsers = new List<Mensajes>(allMessDic.Values);
            //RECOGEMOS TODOS LOS USUARIOS
            List<User> userList =await u.getAllUser();
            //RECORREMOS TODOS LOS USUARIOS Y TODOS LO MENSAJES, SI COINCIDE EL USUARIO Y EL MENSAJE LO MOSTRAMOS. DE ESTA MANERA NO MOSTRAMOS LOS 
            //USUARIOS QUE NO HAN ESCRITO MENSAJES PERO ESTEN REGISTRADOS
            foreach (var user in userList)
            {
                bool flag = false;
                for (int i = 0; i < listMessAndUsers.Count && flag == false; i++)
                {
                    if(user.Name == listMessAndUsers[i].NameUser)
                    {
                        flag = true;
                        comboUsers.Items.Add(user.Name);
                    }
                }
            }
        }

        //EVENTO QUE NOS CONTROLA EL EVENTO DE SELECCIONAR EL COMBOBOX PARA CAMBIAR LOS MENSAJES QUE MOSTRAMOS DE CADA USUARIO
        private void selectChange(object sender, SelectionChangedEventArgs e)
        {
            Mensajes m = new();
            ShowFilteredMessages(m.UserFilteredMess(comboUsers.SelectedItem.ToString()));
        }
    }
}

