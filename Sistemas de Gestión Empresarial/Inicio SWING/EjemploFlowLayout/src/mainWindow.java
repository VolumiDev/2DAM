import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class mainWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame mainW = new JFrame("FlowLayout");
		mainW.setSize(500, 200);
//		mainW.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
//		mainW.getContentPane().setLayout(new GridLayout(1,2));
		mainW.getContentPane().setLayout(new BorderLayout());
		JLabel label_1 = new JLabel("Introduce tu nombre");
		JTextField txt_1 = new JTextField();
		txt_1.setPreferredSize(new Dimension(500,20));
//		mainW.getContentPane().add(label_1);
//		mainW.getContentPane().add(txt_1);
		mainW.getContentPane().add(BorderLayout.WEST, label_1);
		mainW.getContentPane().add(BorderLayout.EAST, txt_1);
		mainW.setVisible(true);
	
	}

}
