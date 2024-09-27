import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class TopPanel extends JPanel{

	private ImgPanel iconPanel;
	private LabelPanel p_label;

	
	
	public TopPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(150,400));

		//instance JLabel with an icon
		iconPanel = new ImgPanel();
		this.add(iconPanel, BorderLayout.WEST);
		
		
		
	
		p_label = new LabelPanel();
		this.add(p_label, BorderLayout.CENTER);
		
	}
}
