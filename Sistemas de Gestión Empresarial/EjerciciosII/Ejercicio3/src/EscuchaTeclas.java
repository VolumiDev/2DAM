import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EscuchaTeclas implements KeyListener {

	private Ventana vent;
	
	public EscuchaTeclas() {
		
	}
	
	public EscuchaTeclas(Ventana v) {
		vent = v;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		vent.getEastPanelC().getTxt().setText(vent.getEastPanel().getTxt().getText());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
