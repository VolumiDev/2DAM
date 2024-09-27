using System;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Controls;

namespace AñadirCursoClases
{
    internal class Curso
    {
        private int codigo;
        private String titulo;
        private String turno;
        private String modalidad;
        private String categoria;
        private List<Alumno> alumnos;

        public Curso(string tit, RadioButton rButton, string cat, string mod, List<Alumno> listAlumno, List<Curso> cursos)
        {
            codigo = cursos.Count + 1;
            this.titulo = tit;
            this.modalidad =  mod;
            this.turno = rButton.IsChecked == true ? "Mañana" : "Tarde";
            this.categoria = cat;
            this.Alumnos = listAlumno;
        }

        public void AñadirLista(List<Alumno> lista)
        {
            alumnos = lista;
        }

        public int Codigo { get => codigo; set => codigo = value; }
        public string Titulo { get => titulo; set => titulo = value; }
        public string Turno { get => turno; set => turno = value; }
        public string Modalidad { get => modalidad; set => modalidad = value; }
        public string Categoria { get => categoria; set => categoria = value; }
        internal List<Alumno> Alumnos { get => alumnos; set => alumnos = value; }
    }
}
