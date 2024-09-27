import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ContentPanel extends JPanel{

	private JLabel[] contents;
	
	public ContentPanel() {
		// TODO Auto-generated constructor stub
		super();
		contents = new JLabel[4];
		
		String[] txtConten = {"C:\\Users\\Diego\\Documents\\2DAM\\Sistemas de Gestión Empresarial\\Inicio SWING", "Softonic international", "Aplicacion", "C:\\Users\\Diego\\Documents\\2DAM\\Sistemas de Gestión Empresarial\\Inicio SWING"};

		for (int i = 0; i < contents.length; i++) {
			contents[i] = new JLabel(txtConten[i], JLabel.LEFT);
			contents[i].setPreferredSize(new Dimension(200, 20));
			this.add(contents[i]);
		}
	}
}
