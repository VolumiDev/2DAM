import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CenterView extends JPanel{
	
	private LeftPanel left;
	private RightPanel rigth;

	
	CenterView(){
		super();
		// set layout
		this.setLayout(new GridLayout(1, 2));
		left = new LeftPanel();
		this.add(left);
		
		rigth = new RightPanel();
		this.add(rigth);
	}
}
