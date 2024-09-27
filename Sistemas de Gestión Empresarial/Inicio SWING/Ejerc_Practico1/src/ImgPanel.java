import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImgPanel extends JPanel{

	private JLabel icon;
	
	public ImgPanel() {
		// TODO Auto-generated constructor stub
		super();
		ImageIcon image = new ImageIcon("salesianos.png");
		icon = new JLabel(image, JLabel.CENTER); 
		icon.setPreferredSize(new Dimension(100, 100));
		this.add(icon, BorderLayout.WEST);
	}
}
