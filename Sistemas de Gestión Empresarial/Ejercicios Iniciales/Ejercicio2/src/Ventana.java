import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.concurrent.Flow;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame{

	private JLabel title;
	private JTextField input;
	private JButton btn;
	
	Ventana(){
		super();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(100, 100, 300, 300);
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		title = new JLabel("Par o Impar");
		title.setForeground(Color.RED);
		title.setBorder(new EmptyBorder(20, 20, 20, 20));
		
		input = new JTextField(20);
		
		
		btn = new JButton("Comprobar");
		btn.setFont(new Font("Sans", Font.PLAIN, 20) );
		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(290, 70));
		
		this.getContentPane().add(title);
		this.getContentPane().add(input);
		this.getContentPane().add(panel);
		this.getContentPane().add(btn);
		
		
		
		ClaseEscuchadora escuchador = new ClaseEscuchadora(this);
		btn.addActionListener(escuchador);
	}

	

	public void setTitle(JLabel title) {
		this.title = title;
	}

	public JTextField getInput() {
		return input;
	}

	public void setInput(JTextField input) {
		this.input = input;
	}

	public JButton getBtn() {
		return btn;
	}

	public void setBtn(JButton btn) {
		this.btn = btn;
	}
}
