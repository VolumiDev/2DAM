import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class actionSpinner implements ChangeListener {

	Ventana vent;
	
	public actionSpinner() {
		// TODO Auto-generated constructor stub
	}
	
	public actionSpinner(Ventana v){
		vent = v;
	};
	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		vent.getEastPanelC().getSpinner().setValue(vent.getEastPanel().getSpinner().getValue());
	}

}
