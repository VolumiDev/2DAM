import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ClaseEscuchadora implements ActionListener{

	private static Ventana vent;
	
	
	public ClaseEscuchadora(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch(e.getActionCommand()) {
		case "btnAutor":
			JOptionPane.showMessageDialog(vent, "Diego Martin Garcia");
			break;
		case "fondoRojo":
			cambiafondo();
		case "fondoVerde":
			cambiafondo();
			break;
		case "izq":
			justificacion();
			break;
		case "center":
			justificacion();
			break;
		case "der":
			justificacion();
			break;
		case "cursiva":
			estilo();
			break;
		case "negrita":
			estilo();
			break;
		default:
			break;
		
		}
	}
	
	public static void cambiafondo() {
		if (vent.getpRadios().getRadFondo()[0].isSelected()){
			vent.getTxtInput().setBackground(Color.red);
			vent.getTxtInput().setOpaque(true);
		}else {
			vent.getTxtInput().setBackground(Color.GREEN);
			vent.getTxtInput().setOpaque(true);
		}
	}
	
	public static void justificacion() {
		System.out.println("entramos");

		if(vent.getpRadios().getRadAlineacion()[0].isSelected()) {
			vent.getTxtInput().setHorizontalAlignment(SwingConstants.LEFT);
		}else if(vent.getpRadios().getRadAlineacion()[1].isSelected()) {
			vent.getTxtInput().setHorizontalAlignment(SwingConstants.CENTER);
		}else {
			vent.getTxtInput().setHorizontalAlignment(SwingConstants.RIGHT	);
		}
	}
	
	public static void estilo() {
		System.out.println("entramos");

		if (vent.getpCheckBtn().getJchecks()[0].isSelected() && vent.getpCheckBtn().getJchecks()[1].isSelected()){
			vent.getTxtInput().setFont(new Font("sans", Font.ITALIC+Font.BOLD, 15));
			//vent.getTxtInput().setFont(new Font("sans", Font.BOLD, 15));
		}else if(vent.getpCheckBtn().getJchecks()[0].isSelected()){
			vent.getTxtInput().setFont(new Font("sans", Font.ITALIC, 15));
		}else if(vent.getpCheckBtn().getJchecks()[1].isSelected()){
			vent.getTxtInput().setFont(new Font("sans", Font.BOLD, 15));
		}else {
			vent.getTxtInput().setFont(new Font("sans", Font.PLAIN, 15));
		}
	}
	
	

}
