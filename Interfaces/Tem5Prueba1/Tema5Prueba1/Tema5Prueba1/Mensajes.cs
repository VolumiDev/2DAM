using FireSharp.Response;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Documents;

namespace Tema5Prueba1
{
    class Mensajes
    {
        //ATRIBUTOS DE LOS MENSAJES
        private string idMessage;
        private string nameUser;
        private string message;
        private DateTime date;

        //CONSTRUCTOR SOBRECARGADO EN QUE ASIGNAMOS UNA ID MEDIANTE EL GENERADOR DE IDS UNICAS
        public Mensajes(string nameUser, string message, DateTime date)
        {
            Guid guid = Guid.NewGuid();
            this.idMessage = guid.ToString("N");
            this.nameUser = nameUser;
            this.message = message;
            this.date = date;
        }

        public Mensajes()
        {
        }

        public string IdMessage { get => idMessage; set => idMessage = value; }
        public string NameUser { get => nameUser; set => nameUser = value; }
        public string Message { get => message; set => message = value; }
        public DateTime Date { get => date; set => date = value; }

        //METODO ASINCRONO CON EL QUE ALMANCENAMOS EN LA BASE DE DATOS DE FIREBASE EL MENSAJE
        public async void SetMessageDB(Mensajes mess)
        {
            DataBase db = new DataBase();
            SetResponse sRes = await db.Cli.SetAsync($"Messages/{this.IdMessage}", this);
            if(sRes != null)
            {
                MessageBox.Show($"Mensaje de {mess.NameUser} guardado");

            }
        }

        //RECOGEMOS TODOS LOS MENSAJES DE LA BASE DE DATOS Y LOS RETORNAMOS DE FORMA ASINCRONA EN UN DICCIONARIO PARA PODER TRARTAR CON ELLOS
        public async Task<Dictionary<string, Mensajes>> GetMesseges()
        {
            DataBase db = new();
            FirebaseResponse resp = await db.Cli.GetAsync("Messages");
            Dictionary<String, Mensajes> allMess = resp.ResultAs<Dictionary<String, Mensajes>>();
            return allMess;
        }

        //RECOGE TODOS LOS MENSAJE CON EL METODO ANTERIOR Y LOS FILTAMOS POR USUARIO Y POR FECHA QUE LE PASAMOS COMO PAREMETRO.
        //EN EL PORCESO DE FILTRADO APLICAMOS LO CRITERIOS DE FILTRADO QUE CONSIDEREMOS CONVENIENTES
        public async Task<List<Mensajes>> UserandDateFilteredMess(String userName, DateTime? date)
        {
            //RECIBIMOS TODOS LOS MENSAJES
            var allMess =await GetMesseges();
            //FILTRAMOS PARA QUE EL USER SEA DISTINTO Y LA FECHA IGUAL
            //DESPUES LO PASAMOS TODO A UNA LISTA Y LA RETORNAMOS 
            var userFilteredMess = allMess
                .Where(m => m.Value.NameUser != userName && m.Value.Date == date)
                .Select(m => m.Value)
                .ToList();
            return userFilteredMess;
        }

        //FILTRA LOS MENSAJES PARA RETORNAR UNA LISTA CON LOS MENSAJES DE DETERMINADO USUARIO
        public async Task<List<Mensajes>> UserFilteredMess(String userName)
        {
            var allMess = await GetMesseges();
            var userFilteredMess = allMess
                .Where(m => m.Value.NameUser == userName)
                .Select(m => m.Value)
                .ToList();
            return userFilteredMess;
        }


    }

}
