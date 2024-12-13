
public class Alumno {

	
	private String nombre;
	private String codigo;
	private int curso;
	
	
	public Alumno(String n, String c, int cur) {
		// TODO Auto-generated constructor stub
		nombre = n;
		codigo = c;
		curso  = cur;
	}
	
	public String toString() {
		return ""+codigo+"-"+nombre ;
	}
}
