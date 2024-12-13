import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	private JList<Alumno> listaI;
	private JButton pasar;
	private JList<Alumno> listaD;
	private DefaultListModel<Alumno> listaDerecha;
	private DefaultListModel<Alumno> listaAlumnos;
	
	Ventana(){
		super();
		
		listaAlumnos = new DefaultListModel();
		listaAlumnos.addElement(new Alumno("Diego", "1A", 2));
		listaAlumnos.addElement(new Alumno("Laura", "2B", 1));
		listaAlumnos.addElement(new Alumno("Juan", "3C", 2));
		listaAlumnos.addElement(new Alumno("Laia", "4A", 1));
		
		this.setBounds(100, 100, 600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel izq = new JPanel();
		listaI = new JList<Alumno>(listaAlumnos);
		izq.add(listaI);
		
		
		pasar = new JButton("Pasar");
		izq.add(pasar);
		listaDerecha = new DefaultListModel();
		listaD = new JList<Alumno>(listaDerecha);
		izq.add(listaD);
		this.getContentPane().add(izq);

		
		pasar.addActionListener(new ClaseEscucha(this));
		
	}

	public JList<Alumno> getListaI() {
		return listaI;
	}

	public void setListaI(JList<Alumno> listaI) {
		this.listaI = listaI;
	}

	public JButton getPasar() {
		return pasar;
	}

	public void setPasar(JButton pasar) {
		this.pasar = pasar;
	}

	public JList<Alumno> getListaD() {
		return listaD;
	}

	public void setListaD(JList<Alumno> listaD) {
		this.listaD = listaD;
	}

	public DefaultListModel<Alumno> getListaDerecha() {
		return listaDerecha;
	}

	public void setListaDerecha(DefaultListModel<Alumno> listaDerecha) {
		this.listaDerecha = listaDerecha;
	}

	public DefaultListModel<Alumno> getListaAlumnos() {
		return listaAlumnos;
	}

	public void setListaAlumnos(DefaultListModel<Alumno> listaAlumnos) {
		this.listaAlumnos = listaAlumnos;
	}
	
	
}
