import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class ClaseEscuchadora implements ActionListener{
	private Ventana vent;
	
	public ClaseEscuchadora(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String contenidoInput = vent.getInput().getText();
		boolean flag = false;
		if (contenidoInput.equalsIgnoreCase("")) {
			flag = true;
		}
		for (int i = 0; i < contenidoInput.length() && flag == false; i++) {
			if(contenidoInput.charAt(i) < '0' || contenidoInput.charAt(i) > '9' || contenidoInput.equalsIgnoreCase("")) {
				flag = true;
			}
		}
		
		if(flag) {
			JOptionPane.showMessageDialog(vent, "Introduce un dato numerico", "Error...", JOptionPane.ERROR_MESSAGE);;
		}else {
			JOptionPane.showMessageDialog(vent, parImpar(contenidoInput));
		}
	}
	
	public static String parImpar(String cad) {
		String mensaje;
		int num = Integer.parseInt(cad);
		if(num % 2 == 0) {
			mensaje = "El numero es par"; 
		}else {
			mensaje = "El numero es impar";
		}
		return mensaje;
	}
}
