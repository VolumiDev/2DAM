import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Credential extends JFrame{

	private JTextField user, pass;
	private JLabel lblUser, lblPass;
	private JButton btn;
	
	Credential(){
		super();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setTitle("Incorrecto!!!");
		this.setBounds(100, 100, 300, 200);
		 
		this.setLayout(null);

		lblUser = new JLabel("User:");
		lblUser.setBounds(20, 20, 80, 25);
		this.getContentPane().add(lblUser);
		 
		user = new JTextField();
		user.setBounds(110, 20, 150, 25);
		this.getContentPane().add(user);
		
		lblPass = new JLabel("Password:");
		lblPass.setBounds(20, 60, 80, 25);
		this.getContentPane().add(lblPass);
 		 
		pass = new JPasswordField();
		pass.setBounds(110, 60, 150, 25);
		this.getContentPane().add(pass);
		
		btn = new JButton("Login");
		btn.setBounds(100, 100, 100, 25);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(user.getText().equalsIgnoreCase("Juan") && pass.getText().equalsIgnoreCase("abc123")) {
					JButton boton =(JButton) e.getSource();
					boton.setText("Correcto");
				}else {
					JButton boton =(JButton) e.getSource();
					boton.setText("Incorrecto!!");
				}
			}
		});
		this.getContentPane().add(btn);
		
		this.setVisible(true);
	}
}
