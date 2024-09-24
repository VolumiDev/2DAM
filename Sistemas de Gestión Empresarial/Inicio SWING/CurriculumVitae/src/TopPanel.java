import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TopPanel extends JPanel{

	private JLabel lbl; 
	private JList<String> items;
	
	public TopPanel() {
		// TODO Auto-generated constructor stub
		super();
		lbl = new JLabel("Selecciona tus estudios");
		lbl.setPreferredSize(new Dimension(150, 20));
		this.add(lbl);
		
		
		String[] carreras = {"Ing. Informatica", "Ing. Mecanica", "Derecho", "Magisterio", "Telecomunicaciones","Ing. Mecanica", "Derecho", "Magisterio", "Telecomunicaciones"};
		items = new JList<String>(carreras);
		
		JScrollPane scroll = new JScrollPane(items);
		
		this.add(scroll);
		
	}
}
