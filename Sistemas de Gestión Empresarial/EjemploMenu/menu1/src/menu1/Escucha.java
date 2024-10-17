package menu1;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class Escucha implements ActionListener {
	private Ventana v;
	
	Escucha(Ventana vent){
		v = vent;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == v.getOpc1() ) 
		{
			generateAuxFrame();
		}
		else if(e.getSource() == v.getOpc2())
		{
			generateInternalFrame();
		}
		else if(e.getSource() == v.getOpc3())
		{
			v.getContentPane().setBackground(Color.BLUE);
		}
		
	}
	
	private void generateAuxFrame() {
		VentanaAux vAux = new VentanaAux();
	}
	
	private void generateInternalFrame() {
		InternalFrame intFram = new InternalFrame();
		intFram.setSize(new Dimension(40,40));
		intFram.setVisible(true);
		v.getContentPane().removeAll();
		v.getContentPane().add(intFram);
	}

}
