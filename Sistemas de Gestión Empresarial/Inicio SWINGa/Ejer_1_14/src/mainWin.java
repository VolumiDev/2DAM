import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainWin extends JFrame{

	private JLabel lbl_1;
	private JLabel lbl_2;
	
	mainWin(String title){
		super(title);
		this.getContentPane().setLayout(new GridLayout(2,1));
		lbl_1 = new JLabel("JDK java dev. kit");
		lbl_2 = new JLabel("19.0.12");
		
		this.setSize(200, 150);
		this.getContentPane().add(lbl_1);
		this.getContentPane().add(lbl_2);
		
		this.setVisible(true);
	}
	
}
