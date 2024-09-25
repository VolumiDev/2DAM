using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AñadirCursoClases
{
    internal class Curso
    {
        private int codigo;
        private String titulo;
        private String turno;
        private String modalidad;
        private String categoria;
        private List<Alumno> alumno;

        public Curso(int codigo, string titulo, string turno, string modalidad, string categoria, List<Alumno> alumno)
        {
            this.codigo = codigo;
            this.titulo = titulo;
            this.turno = turno;
            this.modalidad = modalidad;
            this.categoria = categoria;
            this.alumno = alumno;
        }

        public int Codigo { get => codigo; set => codigo = value; }
        public string Titulo { get => titulo; set => titulo = value; }
        public string Turno { get => turno; set => turno = value; }
        public string Modalidad { get => modalidad; set => modalidad = value; }
        public string Categoria { get => categoria; set => categoria = value; }
        internal List<Alumno> Alumno { get => alumno; set => alumno = value; }
    }
}
