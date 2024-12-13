import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class LinePanel extends JPanel{

	private JLabel title;
	private JLabel content;

	public LinePanel(String txt, String txt1) {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		title = new JLabel(txt, SwingConstants.RIGHT);
		title.setPreferredSize(new Dimension(70, 20));
		this.add(title);
		
		
		content = new JLabel(txt1, SwingConstants.LEFT);
		content.setPreferredSize(new Dimension(270, 20));
		this.add(content);
	}
}
