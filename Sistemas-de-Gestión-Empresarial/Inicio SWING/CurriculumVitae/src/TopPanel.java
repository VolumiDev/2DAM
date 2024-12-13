import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TopPanel extends JPanel{

	private JLabel lbl; 
	private JList<String> list;
	
	public TopPanel() {
		// TODO Auto-generated constructor stub
		super();
		lbl = new JLabel("Selecciona tus estudios");
		this.add(lbl);
		
		
		String[] carreras = {"Ing. Informatica", "Ing. Mecanica", "Derecho", "Magisterio", "Telecomunicaciones","Ing. Mecanica", "Derecho", "Magisterio", "Telecomunicaciones"};
		list = new JList<String>(carreras);
		list.setPreferredSize(new Dimension());
		
		JScrollPane scroll = new JScrollPane(list, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//		scroll.setPreferredSize(new Dimension(150, 140));
		
		this.add(scroll);
		
	}
}
 