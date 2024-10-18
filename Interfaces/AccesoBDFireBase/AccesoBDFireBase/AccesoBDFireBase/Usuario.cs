using System;
using System.Collections.Generic;
using System.Linq;
using System.Printing;
using System.Text;
using System.Threading.Tasks;

namespace AccesoBDFireBase
{
    internal class Usuario
    {
        private String nombre;
        private String telefono;
        private String correo;
        private String rol;

        public Usuario(string nombre, string telefono, string correo, string rol)
        {
            this.nombre = nombre;
            this.telefono = telefono;
            this.correo = correo;
            this.rol = rol;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public string Telefono { get => telefono; set => telefono = value; }
        public string Correo { get => correo; set => correo = value; }
        public string Rol { get => rol; set => rol = value; }
    }
}
