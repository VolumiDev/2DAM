import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BottomPanel extends JPanel{

	private JRadioButton[] sexo;
	private JCheckBox[] options;
	
	public BottomPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		sexo = new JRadioButton[2];
		
		ButtonGroup btn_radios = new ButtonGroup();
		for (int i = 0; i < sexo.length; i++) {
			if(i == 0) {
				sexo[i] = new JRadioButton("Hombre");
				this.add(sexo[i]);
			}else {
				sexo[i] = new JRadioButton("Mujer");
			}
			btn_radios.add(sexo[i]);
			this.add(sexo[i]);
		}
		
		String[] txt = {"Disponibilidad para viajar", "Posee coche propio", "Exento servicio militar"};
		options = new JCheckBox[3];
		for (int i = 0; i < options.length; i++) {
			options[i] = new JCheckBox(txt[i]);
			this.add(options[i]);
		}
		
	}
}
