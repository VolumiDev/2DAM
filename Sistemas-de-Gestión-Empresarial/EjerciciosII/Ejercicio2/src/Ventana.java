import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Ventana extends JFrame{

	private JLabel ciclo, modulos;
	private JComboBox<String> listaCiclo, listaModulos;
	
	Ventana(){
		super();
		this.setLayout(new BorderLayout());
		this.setBounds(400, 400, 300, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel north = new JPanel();
		
		ciclo =new JLabel("Ciclo Formativo:", SwingConstants.RIGHT);
		north.add(ciclo);
		listaCiclo = new JComboBox<String>();
		listaCiclo.setPreferredSize(new Dimension(150, 20));
		listaCiclo.addItem("ASIR");
		listaCiclo.addItem("DAM");
		north.add(listaCiclo);
		
		listaCiclo.addActionListener(new ClaseEscucha(this));
		listaCiclo.setActionCommand("ciclos");
		
		this.getContentPane().add(north, BorderLayout.NORTH);
		
		
		JPanel center = new JPanel();
		modulos =new JLabel("Modulos:", SwingConstants.RIGHT);
		center.add(modulos);
		listaModulos = new JComboBox<String>();
		listaModulos.setPreferredSize(new Dimension(150, 20));
		center.add(listaModulos);
		
		this.getContentPane().add(center, BorderLayout.CENTER);
	}

	public JLabel getCiclo() {
		return ciclo;
	}

	public void setCiclo(JLabel ciclo) {
		this.ciclo = ciclo;
	}

	public JLabel getModulos() {
		return modulos;
	}

	public void setModulos(JLabel modulos) {
		this.modulos = modulos;
	}

	public JComboBox<String> getListaCiclo() {
		return listaCiclo;
	}

	public void setListaCiclo(JComboBox<String> listaCiclo) {
		this.listaCiclo = listaCiclo;
	}

	public JComboBox<String> getListaModulos() {
		return listaModulos;
	}

	public void setListaModulos(JComboBox<String> listaModulos) {
		this.listaModulos = listaModulos;
	}
	
}
