import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "1":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "2":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "3":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "4":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "5":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "6":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "7":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
			}
			break;
		case "8":
			if(mw.getModosJuego()[0].isSelected()) {
				eleccionTirada(command, mw.getJugador());
				mw.tiradaComputadora();
			}else {
				eleccionTirada(command, mw.getJugador());
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
	
	
	
}
