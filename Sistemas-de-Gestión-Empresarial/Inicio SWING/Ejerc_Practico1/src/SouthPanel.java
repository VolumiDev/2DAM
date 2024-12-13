import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.nio.channels.IllegalBlockingModeException;
import java.nio.file.DirectoryNotEmptyException;

import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledEditorKit.AlignmentAction;

public class SouthPanel extends JPanel {

	private JLabel lblImg;
	private JLabel lblText;
	
	public SouthPanel() {
		// TODO Auto-generated constructor stub
		super();
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		ImageIcon icon = new ImageIcon("salesianos1.png");
		lblImg = new JLabel(icon);
		lblImg.setPreferredSize(new Dimension(50, 50));
		this.add(lblImg);

		lblText = new JLabel("<html>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor"
				+ "incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud "
				+ " exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat </html>", SwingConstants.LEFT);
		lblText.setPreferredSize(new Dimension(420, 60));
		lblText.setBorder(new EmptyBorder(10, 20, 10, 20));
		this.add(lblText);
	}
}
