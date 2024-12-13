import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class pIzq extends JPanel{

	private JLabel lblTitulo;
	private JTextField txtTitulo;
	private JButton btnAñadir;
	
	
	public pIzq(Ventana v) {
		// TODO Auto-generated constructor stub
		super();
		this.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		
		JPanel marginTop = new JPanel();
		marginTop.setPreferredSize(new Dimension(230, 30));
		this.add(marginTop);
		
		lblTitulo = new JLabel("Escribe el titulo de la pelicula");
		this.add(lblTitulo);
		
		JPanel marginTop1 = new JPanel();
		marginTop1.setPreferredSize(new Dimension(230, 30));
		this.add(marginTop1);

		txtTitulo = new  JTextField(20);
		this.add(txtTitulo);
		
		JPanel marginTop2 = new JPanel();
		marginTop2.setPreferredSize(new Dimension(230, 30));
		this.add(marginTop2);
		
		btnAñadir = new JButton("Añadir");
		this.add(btnAñadir);
		
		btnAñadir.addActionListener(new ClaseEscuchadora(v));
		btnAñadir.setActionCommand("añadir");
		
	}


	public JLabel getLblTitulo() {
		return lblTitulo;
	}


	public void setLblTitulo(JLabel lblTitulo) {
		this.lblTitulo = lblTitulo;
	}


	public JTextField getTxtTitulo() {
		return txtTitulo;
	}


	public void setTxtTitulo(JTextField txtTitulo) {
		this.txtTitulo = txtTitulo;
	}


	public JButton getBtnAñadir() {
		return btnAñadir;
	}


	public void setBtnAñadir(JButton btnAñadir) {
		this.btnAñadir = btnAñadir;
	}
}
