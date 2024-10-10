import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SPanel extends JPanel{

	private JButton[] btns;
	
	public SPanel() {
		// TODO Auto-generated constructor stub
		super();
		btns = new JButton[3];
		String[] titulos = {
			"ALTA",
			"LIMPIAR",
			"CERRAR"
		};
		this.setLayout(new GridLayout());
		
		for (int i = 0; i < btns.length; i++) {
			JPanel panel = new JPanel();
			btns[i] = new JButton(titulos[i]);
			panel.add(btns[i]);
			this.add(panel);
		}
		
	}
}
