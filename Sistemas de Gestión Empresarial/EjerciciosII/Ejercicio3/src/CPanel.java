import java.awt.Dimension;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CPanel extends JPanel{

	private JCheckBox[] checks;
	
	CPanel(Ventana v, String template){
		super();
		this.setPreferredSize(new Dimension(100, 200));
		
		checks = new JCheckBox[3];
		for (int i = 0; i < checks.length; i++) {
			checks[i] = new JCheckBox("Opcion " + (i+4));
			this.add(checks[i]);
			checks[i].addActionListener(new ClaseEscucha(v));
			checks[i].setActionCommand("check" + (i+4) + template);
			if(template.equalsIgnoreCase("Copia")) {
				checks[i].setEnabled(false);
			}
		}
	}

	public JCheckBox[] getChecks() {
		return checks;
	}

	public void setChecks(JCheckBox[] checks) {
		this.checks = checks;
	}
}
