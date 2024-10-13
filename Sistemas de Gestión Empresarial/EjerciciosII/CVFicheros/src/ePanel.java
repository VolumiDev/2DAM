import java.awt.Dimension;
import java.awt.ScrollPane;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class ePanel extends JPanel{

	
	private JComboBox<String> estudios;
	private JRadioButton[] sexo;
	private JCheckBox[] otrosDatos;
	
	public ePanel() {
		// TODO Auto-generated constructor stub
		super();
		
		JLabel tit1 = new JLabel("Elige tus estudios");
		this.add(tit1);
		estudios = new JComboBox<String>();
		estudios.addItem("ESO");
		estudios.addItem("Bachillerato");
		estudios.addItem("FP basica");
		estudios.addItem("Grado Medio");
		estudios.addItem("Grado Superior");
		estudios.addItem("Estudios universitarios");
		JScrollPane scroll1 = new JScrollPane(estudios, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll1.setPreferredSize(new Dimension(200,100));
		this.add(scroll1);
	}
}
