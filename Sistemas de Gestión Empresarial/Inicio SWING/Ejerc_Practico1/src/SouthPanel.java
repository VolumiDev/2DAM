import java.awt.Dimension;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.file.DirectoryNotEmptyException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SouthPanel extends JPanel {

	private JLabel lblImg;
	private JLabel lblText;
	
	public SouthPanel() {
		// TODO Auto-generated constructor stub
		super();
		ImageIcon icon = new ImageIcon("salesianos.png");
		lblImg = new JLabel(icon);
		lblImg.setPreferredSize(new Dimension(100, 100));
		this.add(lblImg);

		lblText = new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod <br> tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,<br> quis nostrud exercitation ullamco laboris nisi ut aliquip ex <br> ea commodo consequat </html>");
		lblText.setPreferredSize(new Dimension(500, 500));
		this.add(lblText);
	}
}
