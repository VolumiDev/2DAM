import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ImgPanel extends JPanel{

	private JLabel icon;
	
	public ImgPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout());
		ImageIcon image = new ImageIcon("salesianos1.png");
		icon = new JLabel(image);
//		icon.setPreferredSize(new Dimension(50, 50));
		this.add(icon);
		
		
	}
	
}
