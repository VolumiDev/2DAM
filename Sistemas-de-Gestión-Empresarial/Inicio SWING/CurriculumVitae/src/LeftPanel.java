import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LeftPanel extends JPanel{

	private Component[] comp;
	private JTextArea text_area;
	private JScrollPane p_scroll;
	
	
	public LeftPanel() {
		// TODO Auto-generated constructor stub
		super();
		//set layout
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//generate elements
		String[] textos = {"Nombre", "Direccion", "Telefono", "Otros datos de interes"};
		int j = 0;
		comp = new Component[7];
		for (int i = 0; i < comp.length; i++) {
			if(i == 0 || i == 2 || i == 4 || i == 6) {
				comp[i] = new JLabel(textos[j]);
				comp[i].setPreferredSize(new Dimension(150, 20));
				j++;
				this.add(comp[i]);
			}else {
				comp[i] = new JTextField(15);
				this.add(comp[i]);
			}
		}
		
		text_area = new JTextArea(7, 15);
		p_scroll = new JScrollPane(text_area, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		this.add(p_scroll);
	}
}
