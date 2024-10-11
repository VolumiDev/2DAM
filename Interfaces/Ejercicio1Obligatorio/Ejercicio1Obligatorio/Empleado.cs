using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Ejercicio1Obligatorio
{
    class Empleado
    {
        private int numero, antiguedad;
        private string nombre, codigo, fechaAlta, especialidad, titulacion, catLaboral, departamento, grado, comentarios, premios;
        private bool tiempoCompleto;
        private float salario, percentil;

        

        public Empleado()
        {
        }

        public int Numero { get => numero; set => numero = value; }
        public int Antiguedad { get => antiguedad; set => antiguedad = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Codigo { get => codigo; set => codigo = value; }
        public string FechaAlta { get => fechaAlta; set => fechaAlta = value; }
        public string Especialidad { get => especialidad; set => especialidad = value; }
        public string Titulacion { get => titulacion; set => titulacion = value; }
        public string CatLaboral { get => catLaboral; set => catLaboral = value; }
        public string Departamento { get => departamento; set => departamento = value; }
        public string Grado { get => grado; set => grado = value; }
        public string Comentarios { get => comentarios; set => comentarios = value; }
        public string Premios { get => premios; set => premios = value; }
        public bool TiempoCompleto { get => tiempoCompleto; set => tiempoCompleto = value; }
        public float Salario { get => salario; set => salario = value; }
        public float Percentil { get => percentil; set => percentil = value; }
    }
}
