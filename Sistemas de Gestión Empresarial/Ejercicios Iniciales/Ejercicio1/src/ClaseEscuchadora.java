import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ClaseEscuchadora implements ActionListener {

	private Ventana vent;
	
	
	ClaseEscuchadora(Ventana v){
		vent = v;
	}
	
			
			
			
			@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(vent , "Bienvenido " + vent.getTxtInput().getText());
		
	}

}
