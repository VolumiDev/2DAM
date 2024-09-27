import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TitlesPanel extends JPanel{

	private JLabel[] titles;
	
	public TitlesPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout());
		this.setPreferredSize(new Dimension(70,110));
//		this.setBackground(Color.BLUE);
		
		titles = new JLabel[4];
		
		
		String[] txt_titles = {"Nombre: ", "Editor: ", "Tipo: ", "De: "};
		
		for (int i = 0; i < titles.length; i++) {
			titles[i] = new JLabel(txt_titles[i], JLabel.RIGHT);
			titles[i].setPreferredSize(new Dimension(50, 20));
			this.add(titles[i]);
		}
	}
}
