import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class WPanel extends JPanel{

	private JLabel[] lbls;
	
	public WPanel() {
		// TODO Auto-generated constructor stub
		
		super();
		lbls = new JLabel[5];
		String[] titulos = {
				"CODIGO",
				"NOMBRE",
				"LOCALIDAD",
				"NACIONAL",
				"DATOS DE INTERES"
		};
		
		this.setLayout(new GridLayout(6, 1));
		
		for (int i = 0; i < titulos.length; i++) {
			lbls[i] = new JLabel(titulos[i]);
			lbls[i].setBorder(new EmptyBorder(30,30,30,30));
			this.add(lbls[i]);
		}
		
	}
}
