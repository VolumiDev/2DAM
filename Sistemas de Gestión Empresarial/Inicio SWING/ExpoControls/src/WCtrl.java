import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class WCtrl extends JFrame{

	private JLabel lbl;
	private JTextField txt, txt1, txt2;
	private JPasswordField pass;
	
	
	WCtrl(){
		super();
		
		this.setTitle("Controls Window");
		this.setBounds(300, 300, 500, 700);
		this.setLayout(new FlowLayout());
		this.setResizable(true);
		
		Label();
		TextField();
		Pass();
		
		this.setVisible(true);
	}
	
	private void Label() {
		lbl = new JLabel("Ejm_lbl");
		this.getContentPane().add(lbl);
	}
	
	private void TextField() {
		txt = new JTextField(20);
		txt1 = new JTextField("Const_1", 20);
		txt2 = new JTextField(20);
		
		txt1.setFont(new Font("Consolas", 1, 15));
		txt1.setEnabled(false);
		
		this.getContentPane().add(txt);
		this.getContentPane().add(txt1);
		this.getContentPane().add(txt2);
	}
	
	private void Pass() {
		pass = new JPasswordField("pass", 15);
		pass.setEchoChar('#');
		
		this.getContentPane().add(pass);
	}
}
