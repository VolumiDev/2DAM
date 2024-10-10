import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.http.WebSocketHandshakeException;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Escucha implements ActionListener {

	private Ventana vent;
	private String palabra;
	private char[] secretWord;
	private int intentos;
	
	public Escucha(Ventana v, String cad, char[] sw) {
		// TODO Auto-generated constructor stub
		vent = v;
		palabra = cad;
		secretWord = sw;
		intentos = 1;
	}
	public Escucha() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(vent.getWestPanel().getBtnAceptar().getActionCommand() == "btnAceptar") {
			buscarEleccion(hacerEleccion(), secretWord);
		}
	}

	
	public String hacerEleccion() {
		String eleccion = vent.getWestPanel().getCBLetras().getSelectedItem().toString();
		return eleccion;
	}
	
	public void buscarEleccion(String eleccion, char[] secretWord) {
		boolean encontrada = false;
		for (int i = 0; i < palabra.length(); i++) {
			if(palabra.charAt(i) == eleccion.charAt(0)) {
				secretWord[i] = eleccion.charAt(0);
				encontrada = true;
			}
		}
		
		if(encontrada) {
			CambiarlblPalabra();
			
		}else {
			intentos++;
			ImageIcon icon = new ImageIcon("imagenes/" + intentos + ".gif");
			vent.getEastPanel().getLblIcon().setIcon(icon);
		}
		
		actualizarIntentos(eleccion);
		actualizarMensajes();
		victoriaDerrota();
	}
	
	public void CambiarlblPalabra() {
		vent.getWestPanel().getLblPalabra().setText(deCharArrayToString(secretWord));
	}
	
	public String deCharArrayToString(char[] vector) {
		String hid = "";
		for (int i = 0; i < vector.length; i++) {
			hid += vector[i] + " ";
		}
		return hid;
	}
	
	public void actualizarIntentos(String eleccion){
		vent.getWestPanel().getLblIntentos().setText(vent.getWestPanel().getLblIntentos().getText() + eleccion);
	}
	
	public void victoriaDerrota() {
		boolean flagPalabra = true;
		int seleccion = -1;
		for (int i = 0; i < secretWord.length; i++) {
			if(secretWord[i] == '_') {
				flagPalabra = false;
			}
		}
		
		if(flagPalabra && intentos < 7) {
			vent.getWestPanel().getBtnAceptar().setEnabled(false);
			seleccion = JOptionPane.showOptionDialog(vent, "Ha ganado, quiere reiniciar partida", "Partida terminada", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Reiniciar", "No", "Cancelar"}, "Reiniciar");
		}else if(!false && intentos >= 7) {
			vent.getWestPanel().getBtnAceptar().setEnabled(false);
			seleccion = JOptionPane.showOptionDialog(vent, "Ha Perdido, quiere reiniciar partida", "Partida terminada", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Reiniciar", "No", "Cancelar"}, "Reiniciar");
		}
		
		if(seleccion == 0) {
			WPanel w = new WPanel();
			palabra = w.randomWord();
			secretWord = w.hiddenWord(palabra);
			intentos = 1;
			vent.getWestPanel().getLblPalabra().setText("");
			vent.getWestPanel().reiniciarPalabra(vent.getWestPanel().getpPalabra(), secretWord);
			vent.getWestPanel().reiniciarIntentos(vent.getWestPanel().getpIntentos());
			actualizarMensajes();
			ImageIcon img = new ImageIcon("imagenes/" + intentos + ".gif");
			vent.getEastPanel().getLblIcon().setIcon(img);
		}
	}
	
	public void actualizarMensajes() {
		String[] mensajes = {
				"Tranquilo por el momento",
				"Que comienze el juego",
				"Un fallo lo tiene cualquiera",
				"Ojo empieza a ser preligroso", 
				"Presta atencion o te costara caro",
				"Ves un luz al final del tunel",
				"Ahorcado"
		};
		
		vent.getWestPanel().getLblMensajes().setText(mensajes[intentos-1]);
				
	}
}
