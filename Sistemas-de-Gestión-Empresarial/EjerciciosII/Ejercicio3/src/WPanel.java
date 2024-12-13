import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class WPanel extends JPanel{

	private JRadioButton[] radios;
	
	public WPanel(Ventana v, String template) {
		// TODO Auto-generated constructor stub
		super();
		this.setPreferredSize(new Dimension(100, 200));
		
		ButtonGroup radioGroup = new ButtonGroup();
		radios = new JRadioButton[3];
		for (int i = 0; i < radios.length; i++) {
			radios[i] = new JRadioButton("Opcion " + (i+1));
			this.add(radios[i]);
			radios[i].addActionListener(new ClaseEscucha(v));
			radios[i].setActionCommand("option" + (i+1) + template);
			radioGroup.add(radios[i]);
			
			if(template.equalsIgnoreCase("Copia")) {
				radios[i].setEnabled(false);
			}
		}
	}

	public JRadioButton[] getRadios() {
		return radios;
	}

	public void setRadios(JRadioButton[] radios) {
		this.radios = radios;
	}
}
