import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SPanel extends JPanel{

	private JButton[] btns;
	
	public SPanel(Ventana v) {
		// TODO Auto-generated constructor stub
		super();
		btns = new JButton[3];
		String[] titulos = {
			"ALTA",
			"LIMPIAR",
			"CERRAR"
		};
		this.setLayout(new GridLayout(1,3));
		

		for (int i = 0; i < btns.length; i++) {
			JPanel panel = new JPanel();
			btns[i] = new JButton(titulos[i]);
			panel.add(btns[i]);
			this.add(panel);
			btns[i].addActionListener(new Escucha(v));
		}
		
		btns[1].setEnabled(false);
		
	}

	public JButton[] getBtns() {
		return btns;
	}

	public void setBtns(JButton[] btns) {
		this.btns = btns;
	}
}
