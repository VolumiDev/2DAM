import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class JugadorPanel extends JPanel{

	private JLabel marcador;
	private JLabel imagen;
	private JButton btn;
	
	JugadorPanel(Ventana v, String jugador){
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setPreferredSize(new Dimension(300,200));
		JLabel mtop = new JLabel();
		mtop.setPreferredSize(new Dimension(200, 30));
		this.add(mtop);
		
		marcador = new JLabel("0", SwingConstants.CENTER);
		marcador.setPreferredSize(new Dimension(200,30));
		JLabel mtop2 = new JLabel();
		mtop2.setPreferredSize(new Dimension(200, 30));
		
		this.add(marcador);
		this.add(mtop2);
		
		imagen = new JLabel(new ImageIcon("espera.png"));
		imagen.setPreferredSize(new Dimension(150,150));
		this.add(imagen);
		
		JLabel mtop1 = new JLabel();
		mtop1.setPreferredSize(new Dimension(200, 30));
		this.add(mtop1);
		
		btn = new JButton("Tirada" + jugador);
		this.add(btn);
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	public JButton getBtn() {
		return btn;
	}

	public JLabel getMarcador() {
		return marcador;
	}

	public void setMarcador(JLabel marcador) {
		this.marcador = marcador;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}
}
