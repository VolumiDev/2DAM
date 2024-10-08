import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClaseEscuchadora implements ActionListener {

	private Ventana vent;
	
	ClaseEscuchadora(Ventana v){
		vent = v;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand() == "añadir") {
			vent.getPanelDer().getLista().addItem(vent.getPanelIzq().getTxtTitulo().getText());
			vent.getPanelIzq().getTxtTitulo().setText("");
		}
	}

}
