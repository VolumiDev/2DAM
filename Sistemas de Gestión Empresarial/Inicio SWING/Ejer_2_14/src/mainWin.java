import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainWin extends JFrame{

	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	
	
	mainWin(String title){
		super(title);
		
		lbl_1 = new JLabel("ROJO");
		lbl_2 = new JLabel("AMARILLO");
		lbl_3 = new JLabel("AZUL");
		
		this.setSize(400, 200);
		
		this.getContentPane().setLayout(new GridLayout(3, 1));
		this.getContentPane().add(lbl_1);
		this.getContentPane().add(lbl_2);
		this.getContentPane().add(lbl_3);
		
		
		this.setVisible(true);
	}
}
