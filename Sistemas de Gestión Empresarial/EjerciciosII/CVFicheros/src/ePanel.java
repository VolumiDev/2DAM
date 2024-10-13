import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ScrollPane;

import javax.swing.ButtonGroup;
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
		
		
		JPanel marginTop = new JPanel();
		marginTop.setPreferredSize(new Dimension(200, 30));
		this.add(marginTop);
		
		
		sexo = new JRadioButton[2];
		ButtonGroup radioOptions = new ButtonGroup();
		String[] titRadios = {"Hombre", "Mujer"};
		for (int i = 0; i < sexo.length; i++) {
			sexo[i] = new JRadioButton(titRadios[i]);
			radioOptions.add(sexo[i]);
			sexo[i].setPreferredSize(new Dimension(80,20));
			this.add(sexo[i]);
		}
		sexo[0].setSelected(true);
		
		
		
		JPanel marginTop1 = new JPanel();
		marginTop1.setPreferredSize(new Dimension(200, 30));
		this.add(marginTop1);
		
		
		String[] titCheck = {
				"Disponibilidad para viajar",
				"Coche propio",
				"Exento de servicio militar"
		};
		
		JPanel checkPanel = new JPanel();
		checkPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		checkPanel.setPreferredSize(new Dimension(200, 200));
		otrosDatos = new JCheckBox[3];
		for (int i = 0; i < otrosDatos.length; i++) {
			otrosDatos[i] = new JCheckBox(titCheck[i]);
			checkPanel.add(otrosDatos[i]);
		}
		this.add(checkPanel);
	}

	
	public void limpiar() {
		sexo[0].setSelected(true);
		for (int i = 0; i < otrosDatos.length; i++) {
			otrosDatos[i].setSelected(false);
		}
	}
	
	
	public JComboBox<String> getEstudios() {
		return estudios;
	}

	public void setEstudios(JComboBox<String> estudios) {
		this.estudios = estudios;
	}

	public JRadioButton[] getSexo() {
		return sexo;
	}

	public void setSexo(JRadioButton[] sexo) {
		this.sexo = sexo;
	}

	public JCheckBox[] getOtrosDatos() {
		return otrosDatos;
	}

	public void setOtrosDatos(JCheckBox[] otrosDatos) {
		this.otrosDatos = otrosDatos;
	}
	
}
