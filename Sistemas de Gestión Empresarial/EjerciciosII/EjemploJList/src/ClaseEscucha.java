import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;

public class ClaseEscucha implements ActionListener {

	private  Ventana vent;
	
	public ClaseEscucha(Ventana v) {
		// TODO Auto-generated constructor stub
		super();
		vent = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == vent.getPasar()) {
			System.out.println("entramos");
			vent.getListaDerecha().addElement(vent.getListaI().getSelectedValue());
			vent.getListaAlumnos().remove(vent.getListaI().getSelectedIndex());
		}
	}

}
