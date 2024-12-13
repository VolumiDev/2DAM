import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class pDer extends JPanel{

	private JLabel lblPeliculas;
	private JComboBox<String> lista;
	
	pDer(Ventana v){
		super();
		
this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
		JPanel marginTop = new JPanel();
		marginTop.setPreferredSize(new Dimension(230, 30));
		this.add(marginTop);
		
		lblPeliculas = new JLabel("Pelicula:");
		this.add(lblPeliculas);
		
		JPanel marginTop1 = new JPanel();
		marginTop1.setPreferredSize(new Dimension(230, 30));
		this.add(marginTop1);
		
		lista = new JComboBox<String>();
		lista.setPreferredSize(new Dimension(150,20));
		this.add(lista);
	}

	public JLabel getLblPeliculas() {
		return lblPeliculas;
	}

	public void setLblPeliculas(JLabel lblPeliculas) {
		this.lblPeliculas = lblPeliculas;
	}

	public JComboBox<String> getLista() {
		return lista;
	}

	public void setLista(JComboBox<String> lista) {
		this.lista = lista;
	}
	
}
