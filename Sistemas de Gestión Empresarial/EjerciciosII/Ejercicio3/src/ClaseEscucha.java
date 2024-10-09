import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLSyntaxErrorException;

public class ClaseEscucha implements ActionListener {

	Ventana vent;
	
	public ClaseEscucha() {};
	
	public ClaseEscucha(Ventana v) {
		// TODO Auto-generated constructor stub
		vent = v;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(vent.getWestPanel().getRadios()[0].getActionCommand().equalsIgnoreCase("option1Original") || vent.getWestPanel().getRadios()[1].getActionCommand() .equalsIgnoreCase("option2Original") || vent.getWestPanel().getRadios()[2].getActionCommand() .equalsIgnoreCase("option3Original")) {
			radiosChange();
		}
		if(vent.getCenterPanel().getChecks()[0].getActionCommand().equalsIgnoreCase("check4Original") || vent.getCenterPanel().getChecks()[1].getActionCommand().equalsIgnoreCase("check5Original") || vent.getCenterPanel().getChecks()[2].getActionCommand().equalsIgnoreCase("check6Original")){
			checksChange();
		}
		if(vent.getEastPanel().getComboBox().getActionCommand().equalsIgnoreCase("comboOriginal")) {
			comboChange();
		}
		
		
	}

	public void radiosChange() {
		boolean flag = false;
		for (int i = 0; i < vent.getWestPanel().getRadios().length  && flag==false; i++) {
			if(vent.getWestPanel().getRadios()[i].isSelected()) {
				flag = true;
				vent.getWestPanelC().getRadios()[i].setSelected(true);
			}
		}
	}
	
	public void checksChange() {
		for (int i = 0; i < vent.getCenterPanel().getChecks().length; i++) {
			if(vent.getCenterPanel().getChecks()[i].isSelected()) {
				vent.getCenterPanelC().getChecks()[i].setSelected(true);
			}else {
				vent.getCenterPanelC().getChecks()[i].setSelected(false);
			}
		}
	}
	
	public void comboChange() {
		
		vent.getEastPanelC().getComboBox().setSelectedItem(vent.getEastPanel().getComboBox().getSelectedItem());
		
	}
}
