using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace WpfApp1
{
    class Persona
    {
        String nombre;
        String cargo;
        String especialidad;
        String curso;

        //GENERAMOS LOS GETTER Y LOS SETTER
        public string Nombre { get => Nombre; set => Nombre = value; }
        public string Cargo { get => Cargo; set => Cargo = value; }
        public string Especialidad { get => especialidad; set => especialidad = value; }
        public string Curso { get => curso; set => curso = value; }
    }
}
