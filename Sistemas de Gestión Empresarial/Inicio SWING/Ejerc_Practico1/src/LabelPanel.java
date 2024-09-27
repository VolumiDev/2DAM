import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.naming.ContextNotEmptyException;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LabelPanel extends JPanel{

	private TitlesPanel titles;
	private ContentPanel contens;
	
	public LabelPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(350, 150));
		
		titles = new TitlesPanel();
		contens = new ContentPanel();
		
		this.add(titles, BorderLayout.WEST);
		this.add(contens, BorderLayout.CENTER);
		
		
//		}
	}
}
