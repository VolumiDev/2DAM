import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainWin extends JFrame{

	private JLabel lbl_1;
	private JLabel lbl_2;
	private JLabel lbl_3;
	
	
	mainWin(String title){
		super(title);

		this.getContentPane().setLayout(new GridLayout(3, 1));
		
		lbl_1 = new JLabel("ROJO");
		lbl_1.setBackground(Color.RED);
		lbl_1.setOpaque(true);
		
		lbl_2 = new JLabel("AMARILLO");
		lbl_2.setBackground(Color.YELLOW);
		lbl_2.setOpaque(true);
		
		lbl_3 = new JLabel("AZUL");
		lbl_3.setBackground(Color.BLUE);
		lbl_3.setOpaque(true);
		
		this.setSize(400, 200);
		
		this.getContentPane().add(lbl_1);
		this.getContentPane().add(lbl_2);
		this.getContentPane().add(lbl_3);
		
		
		this.setVisible(true);
	}
}
