import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.xml.crypto.MarshalException;

public class sPanel extends JPanel{

	private JButton[] btns;
	
	sPanel(){	
		super();
		
		btns = new JButton[2];
		String[] titulos = {
				"INSERTAR DATOS",
				"SALIR"
		};
		
		JPanel pBtn = new JPanel();
		for (int i = 0; i < btns.length; i++) {
			btns[i] = new JButton(titulos[i]);
			btns[i].addActionListener(new  Escuchadora());
			pBtn.add(btns[i]);
			if(i == 0 ) {
				JPanel marginPanel = new JPanel();
				marginPanel.setPreferredSize(new Dimension(100,20));
				pBtn.add(marginPanel);
			}
		}
		
		this.add(pBtn);
		
	
	}
}
