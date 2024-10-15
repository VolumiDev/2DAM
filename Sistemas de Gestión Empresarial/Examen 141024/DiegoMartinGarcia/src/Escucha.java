import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class Escucha implements ActionListener {

	private Ventana vent;
	private boolean estado;
	
	public Escucha(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
		estado = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vent.getReserva().getRadios()[0]) {
			//vent.eliminarBanquete();
			vent.eliminarCongreso();
			vent.eliminarBotones();
			vent.ampliarVentana();
			vent.insertarBanquete();
			vent.insertarBotones();
			vent.repaint();
			vent.revalidate();
			//validaRadio();
		}else if(e.getSource() == vent.getReserva().getRadios()[1]) {
			vent.eliminarBanquete();
			//vent.eliminarCongreso();
			vent.eliminarBotones();
			vent.ampliarVentana();
			vent.insertarCongreso();
			vent.insertarBotones();
			vent.repaint();
			vent.revalidate();
			//validaRadio();
		}else if(e.getSource() == vent.getpBotones().getBtns()[0]) {
			try {
				reservar();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}else if(e.getSource() == vent.getpBotones().getBtns()[1]) {
			limpiar();
			vent.minimizarVentana();
		}else if(e.getSource() == vent.getpBotones().getBtns()[2]) {
			System.exit(0);
		}
	}
	
	
	
	private void validaRadio() {
		if(vent.getReserva().getRadios()[0].isSelected() == true) {
			vent.eliminarBanquete();
			vent.eliminarCongreso();
			vent.eliminarBotones();
			vent.ampliarVentana();
			vent.insertarBanquete();
			vent.insertarBotones();
		}else if(vent.getReserva().getRadios()[1].isSelected() == true){
			vent.eliminarBanquete();
			vent.eliminarCongreso();
			vent.eliminarBotones();
			vent.ampliarVentana();
			vent.insertarCongreso();
			vent.insertarBotones();
		}
	}
	
	private void reservar() throws IOException {
		
		if(isVacios()) {
			File res = new File("reserva.txt");
			FileWriter fw = new FileWriter(res,true);
			PrintWriter pw = new PrintWriter(fw);
			
			pw.println("NOMBRE: " + vent.getDatos().getTxts()[0].getText());
			pw.println("TELEFONO: " + vent.getDatos().getTxts()[1].getText());
			
			if(vent.getReserva().getRadios()[0].isSelected()) {
				pw.println("TIPO DE EVENTO: Banquete");
			}else {
				pw.println("TIPO DE EVENTO: Congreso");
			}
			pw.println("FECHA DE EVENTO" + vent.getReserva().getTxtEvento().getText());
			pw.println("TIPO COCINA: " + vent.getReserva().getTiposCocina().getSelectedItem());
			pw.println("Nº PERSONAS: " + vent.getReserva().getTxtNumPersonas().getText());
			pw.println("------------------------");
			pw.close();
			fw.close();
			vent.getpBotones().getBtns()[0].setEnabled(false);
		}else {
			JOptionPane.showMessageDialog(vent, "Rellene todos los campos");
		}
	}
	
	private void limpiar() {
		for (int i = 0; i < vent.getDatos().getTxts().length; i++) {
			vent.getDatos().getTxts()[i].setText("");
		}
		vent.getReserva().getTxtEvento().setText("");
		vent.getReserva().getTxtNumPersonas().setText("");
		vent.eliminarBanquete();
		vent.eliminarBotones();
		vent.eliminarCongreso();
		vent.getReserva().desseleccionar();
		vent.getpBotones().getBtns()[0].setEnabled(true);
	}
	
	private boolean isVacios(PAux panel) {
		boolean flag = true;
		for (int i = 0; i < vent.getDatos().getTxts().length; i++) {
			if(vent.getDatos().getTxts()[i].getText().isEmpty()) {
				flag = false;
			}
		}
		if(vent.getReserva().getTxtEvento().getText().isEmpty() || vent.getReserva().getTxtNumPersonas().getText().isEmpty()) {
			flag = false;
		}
		for (int i = 0; i < panel.getRadios().length; i++) {
			if(panel.getRadios()[i].isSelected() == false) {
				flag = false;
			}
		}
		return flag;
	}
}
