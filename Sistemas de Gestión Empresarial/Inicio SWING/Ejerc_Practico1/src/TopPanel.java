import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class TopPanel extends JPanel{

	private ImgPanel iconPanel;
	private LabelPanel p_label;

	
	
	public TopPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new BorderLayout());

		//instance JLabel with an icon
		iconPanel = new ImgPanel();
		iconPanel.setPreferredSize(new Dimension(100, 100));
//		iconPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
		this.add(iconPanel, BorderLayout.WEST);
		
		
		
	
		p_label = new LabelPanel();
		p_label.setPreferredSize(new Dimension(250, 500));

		this.add(p_label, BorderLayout.CENTER);
		
	}
}
