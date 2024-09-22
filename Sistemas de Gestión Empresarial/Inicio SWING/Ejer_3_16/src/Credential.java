import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Credential extends JFrame{

	private JTextField user, pass;
	private JLabel lblUser, lblPass;
	private Button btn;
	
	Credential(){
		super();
		 this.setTitle("Incorrecto!!!");
		 this.setBounds(100, 100, 500, 300);
		 
		 this.setLayout(null);

		 lblUser = new JLabel("User:");
		 lblUser.setLocation(20, 20);
		 this.getContentPane().add(lblUser);
		 
		 this.setVisible(true);
	}
}
