namespace AñadirCursoClases
{
    internal class Alumno
    {
        private String nombre;

        public Alumno(string nombre)
        {
            Nombre = nombre;
        }

        public string Nombre { get => nombre; set => nombre = value; }
    }
}