import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClaseEscucha implements ActionListener {

	private Ventana vent;
	
	
	public ClaseEscucha(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] modulosAsir = {"Implantacion de sistemas", "Lenguaje de marcas", "Redes", "Fundamentos de HW", "Gestion de BD", "FOL"};
		String[] modulosDam = {"Programacion", "Lenguaje de marcas", "Entornos de desarrollo", "Sistemas Operativos", "Bases de Datos", "FOL"};
		
		if(vent.getListaCiclo().getActionCommand() == "ciclos") {
			if(vent.getListaCiclo().getSelectedItem() == "ASIR") {
				vent.getListaModulos().removeAllItems();
				for (int i = 0; i < modulosAsir.length; i++) {
					vent.getListaModulos().addItem(modulosAsir[i]);		
				}
			} else {
				vent.getListaModulos().removeAllItems();
				for (int i = 0; i < modulosDam.length; i++) {
					vent.getListaModulos().addItem(modulosDam[i]);		
				}
			}
		}
	}

}
