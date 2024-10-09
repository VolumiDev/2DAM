import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

public class EPanel extends JPanel{

	private JTextField txt;
	private JSpinner spinner;
	private JComboBox<String> comboBox;
	
	public EPanel(Ventana v, String template) {
		// TODO Auto-generated constructor stub		
		super();
		this.setPreferredSize(new Dimension(100, 200));
		
		txt = new JTextField(8);
		txt.setText("");
		this.add(txt);
		txt.addKeyListener(new EscuchaTeclas(v));

		
		JPanel marginbot = new JPanel();
		marginbot.setPreferredSize(new Dimension(100, 10));
		this.add(marginbot);
		
		spinner = new JSpinner();
		spinner.setPreferredSize(new Dimension(95, 20));
		this.add(spinner);
		spinner.addChangeListener(new actionSpinner(v));
//		spinner.setActionCommand("spinner" + template);
		
		JPanel marginbot1 = new JPanel();
		marginbot1.setPreferredSize(new Dimension(100, 10));
		this.add(marginbot1);
		
		
		comboBox = new JComboBox<String>();
		comboBox.setPreferredSize(new Dimension(95, 20));
		comboBox.addItem("ITEM 1");
		comboBox.addItem("ITEM 2");
		comboBox.addItem("ITEM 3");
		comboBox.addItem("ITEM 4");
		this.add(comboBox);
		comboBox.addActionListener(new ClaseEscucha(v));
		comboBox.setActionCommand("combo" + template);
		
		if(template.equalsIgnoreCase("copia")) {
			txt.setEnabled(false);
			spinner.setEnabled(false);
			comboBox.setEnabled(false);
		}
	}

	public JTextField getTxt() {
		return txt;
	}

	public void setTxt(JTextField txt) {
		this.txt = txt;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public void setSpinner(JSpinner spinner) {
		this.spinner = spinner;
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
	
}
