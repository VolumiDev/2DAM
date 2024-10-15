import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class PBotones extends JPanel{

	private JButton[] btns;
	
	public PBotones(Ventana v) {
		// TODO Auto-generated constructor stub
		super();
		String[] btnTit = {"RESERVAR", "LIMPIAR", "CERRAR"};
		
		JPanel botones = new JPanel();
		botones.setBorder(new LineBorder(Color.LIGHT_GRAY, 1));
		botones.setPreferredSize(new Dimension(450, 40));
		botones.setLayout(new FlowLayout(FlowLayout.CENTER));

		
		
		btns = new JButton[3];
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(btnTit[i]);
			btns[i].setPreferredSize(new Dimension(120,25));
			botones.add(btns[i]);
			btns[i].addActionListener(new Escucha(v));
		}
		
		this.add(botones);
	}

	public JButton[] getBtns() {
		return btns;
	}

	public void setBtns(JButton[] btns) {
		this.btns = btns;
	}
	
}
