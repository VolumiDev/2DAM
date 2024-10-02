import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends JFrame{

	private JLabel lbl;
	private JButton btn;
	private int cont;
	
	Ventana(){
		super();
		this.setLayout(new FlowLayout(FlowLayout.CENTER));
		this.setBounds(100, 100, 350, 200);
		
		lbl = new JLabel("Numero de click en el boton:" + cont);
		lbl.setFont(new Font("Arial", Font.BOLD, 20));
		lbl.setPreferredSize(new Dimension(200,50));

		this.add(lbl);
		
		btn = new JButton("Contar Pulsaciones");
		btn.setForeground(Color.RED);
		btn.setPreferredSize(new Dimension(200,50));
		this.add(btn);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
