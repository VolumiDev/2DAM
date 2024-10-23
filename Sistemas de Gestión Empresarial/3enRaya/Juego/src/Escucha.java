import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Escucha implements ActionListener {

	private MainWin mw;
	
	
	
	public Escucha(MainWin mw) {
		super();
		this.mw = mw;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch(command) {
		case "0":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "1":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "2":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "3":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "4":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "5":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "6":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "7":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		case "8":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
				validarPartida("X");
				validarPartida("O");
			}else {
				eleccionTirada(command, mw.getJugador());
				validarPartida("X");
				validarPartida("O");
			}
			break;
		}
	}
	
	private boolean eleccionTirada(String numBtn, int jugador) {
		boolean flag = true;
		if(mw.getBtns()[Integer.parseInt(numBtn)].getText() == "") {
			if(jugador == 1) {
				mw.getBtns()[Integer.parseInt(numBtn)].setText("X");
				mw.setJugador(2);
			}else {
				mw.getBtns()[Integer.parseInt(numBtn)].setText("O");
				mw.setJugador(1);
			}
		}
		return flag;
	}
	
	
	private boolean validarPartida(String dato) {
		JButton[] btns = mw.getBtns();
		boolean victoria = false;
		boolean vacios = true;
		for (int i = 0; i < btns.length && victoria == false; i++) {
			if(btns[0].getText().equalsIgnoreCase(dato) && btns[3].getText().equalsIgnoreCase(dato) && btns[6].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}else if(btns[1].getText().equalsIgnoreCase(dato) && btns[4].getText().equalsIgnoreCase(dato) && btns[7].getText().equalsIgnoreCase(dato)){
				victoria = true;
			}else if(btns[2].getText().equalsIgnoreCase(dato) && btns[5].getText().equalsIgnoreCase(dato) && btns[8].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}else if(btns[0].getText().equalsIgnoreCase(dato) && btns[1].getText().equalsIgnoreCase(dato) && btns[2].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}else if(btns[3].getText().equalsIgnoreCase(dato) && btns[4].getText().equalsIgnoreCase(dato) && btns[5].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}else if(btns[6].getText().equalsIgnoreCase(dato) && btns[7].getText().equalsIgnoreCase(dato) && btns[8].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}else if(btns[0].getText().equalsIgnoreCase(dato) && btns[4].getText().equalsIgnoreCase(dato) && btns[8].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}else if(btns[2].getText().equalsIgnoreCase(dato) && btns[4].getText().equalsIgnoreCase(dato) && btns[6].getText().equalsIgnoreCase(dato)) {
				victoria = true;
			}
		}
		
		if(victoria) {
			if(dato.equalsIgnoreCase("X")) {
				mw.getResultado().setText("Gana el jugador 1");
			}else {
				mw.getResultado().setText("Gana el jugador 2");
			}
		}else {
			for (int i = 0; i < btns.length; i++) {
				if(!btns[i].getText().equalsIgnoreCase("")) {
					vacios = false;
				}
			}
			if(!vacios) {
				mw.getResultado().setText("Fue un empate");
			}
		}
		
		return victoria;
	}
		
	
}
